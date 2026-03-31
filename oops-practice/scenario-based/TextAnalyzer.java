import java.util.regex.Pattern;

public class TextAnalyzer {

    public static void analyzeParagraph(String text, String target, String replacement) {
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Error: Paragraph is empty or invalid.");
            return;
        }

        String[] words = text.trim().split("\\W+");
        int wordCount = words.length;
        
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        String modifiedText = text.replaceAll("(?i)" + Pattern.quote(target), replacement);

        System.out.println("--- Analysis Results ---");
        System.out.println("Word Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Modified Text: " + modifiedText.trim());
    }

    public static void main(String[] args) {
        String paragraph = "The quick brown fox jumps over the lazy dog. Dog is very lazy!";
        analyzeParagraph(paragraph, "dog", "cat");
    }
}