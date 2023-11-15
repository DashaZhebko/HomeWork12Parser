package analyzers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analyzer {
    public final int F_LENGTH = 2;
    public final int F_COUNT = 10;

    /**
     * Method for converting String text to List of Strings
     *
     * @param text String text
     * @return List of Strings
     */
    public List<String> getWords(String text) {
        return Arrays.stream(text.split("\\s+")).toList();
    }

    /**
     * Method for filter words by word length > F_LENGTH
     *
     * @param words List of String words
     * @return List of String words
     */
    public List<String> filterWords(List<String> words) {
        return words.stream().filter(word -> word.length() > F_LENGTH).toList();
    }

    /**
     * Method for definition top F_COUNT words that are used in text most often
     *
     * @param words List of String words
     * @return Map, where key = word, value = number of repetitions in the text
     */
    public Map<String, Long> getTopWords(List<String> words) {
        Map<String, Long> groupingWords = words.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        Map<String, Long> topWords = groupingWords.entrySet()
                .stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(F_COUNT)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (el1, el2) -> el1, LinkedHashMap::new));
        return topWords;
    }
}
