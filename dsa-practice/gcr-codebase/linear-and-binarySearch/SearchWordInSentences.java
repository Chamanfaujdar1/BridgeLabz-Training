public class SearchWordInSentences {

    public static String findSentenceContainingWord(String[] sentences, String word) {

        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].toLowerCase().contains(word.toLowerCase())) {
                return sentences[i];
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        String[] sentences = {
            "Java is a powerful programming language.",
            "I love learning Data Structures and Algorithms.",
            "Linear search is simple and easy.",
            "Practice daily to improve."
        };

        String word = "search";

        String result = findSentenceContainingWord(sentences, word);
        System.out.println(result);
    }
}
