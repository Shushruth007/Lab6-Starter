package edu.ucsd.cse110.lab6;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.ucsd.cse110.lab6.misc.Constants;

@SuppressWarnings("unused")
public class Exercises {
    public static double mean(List<Integer> numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    public static double standardDeviation(List<Integer> numbers) {
        double mean = mean(numbers);

        double deviationSum = 0;
        for (int number : numbers) {
            deviationSum += Math.pow(mean - number, 2);
        }

        int length = numbers.size();
        double variance = deviationSum / length;
        return Math.sqrt(variance);
    }

    public static double exercise1(List<Integer> numbers) {
        return standardDeviation(numbers);
    }

    public static long exercise2(String input) {
        // This pattern matches the spaces between words, as well as punctuation and apostrophes.
        Pattern re = Pattern.compile("('|'s)?[.,;]?[\\s\\n]", Pattern.MULTILINE);
        Stream<String> wordStream = re.splitAsStream(input);
        Set<String> excludedWords = Constants.excludedWords;

        List <Integer> filtered =  wordStream.map(String::toLowerCase)
                .filter(word -> !excludedWords.contains(word))
                .map(String::length).collect(Collectors.toList());

        int count = 0;
        for (int i : filtered){
            if (i == 6){
                count += 1;
            }
        }
        return count;
    }
}
