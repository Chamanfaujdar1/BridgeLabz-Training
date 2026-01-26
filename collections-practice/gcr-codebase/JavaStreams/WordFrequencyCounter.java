import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String filePath = "input.txt";

        HashMap<String, Integer> map = new HashMap<>();
        long totalWords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                line = line.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

                String[] words = line.trim().split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    totalWords++;
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Total Words in File: " + totalWords);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\n Top 5 Most Frequent Words:");
        System.out.println("--------");

        int top = Math.min(5, list.size());
        for (int i = 0; i < top; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
