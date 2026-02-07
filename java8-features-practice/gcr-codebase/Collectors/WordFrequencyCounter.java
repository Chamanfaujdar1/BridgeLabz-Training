import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
    public static void main(String[] args){
        String paragraph = "Java is a high-level programming language. Java is widely used for building enterprise applications. Java is also popular for Android app development.";
        Map<String, Integer> wordCount = Arrays.stream(paragraph.toLowerCase().split("\\s+"))
        .collect(Collectors.toMap(
            word -> word,
            word -> 1,
            Integer::sum
        ));

        System.out.println("Word Frequency Count: " + wordCount);
    }
}
