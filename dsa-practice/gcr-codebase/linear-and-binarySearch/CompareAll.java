import java.io.*;
import java.nio.charset.StandardCharsets;

public class CompareAll {

    private static long countWords(BufferedReader br) throws IOException {
        long wordCount = 0;
        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            if (words.length == 1 && words[0].isEmpty()) continue;
            wordCount += words.length;
        }
        return wordCount;
    }

    public static void main(String[] args) {

        int n = 1_000_000;
        String word = "hello";

        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(word);
        }
        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) + " ns");

        long startBuffer = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append(word);
        }
        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer Time : " + (endBuffer - startBuffer) + " ns");

        String filePath = "largefile.txt";

        try {
            long startFR = System.nanoTime();

            FileReader fr = new FileReader(filePath);
            BufferedReader brFR = new BufferedReader(fr);

            long wordsFR = countWords(brFR);

            brFR.close();

            long endFR = System.nanoTime();
            System.out.println("\nFileReader Word Count: " + wordsFR);
            System.out.println("FileReader Time      : " + (endFR - startFR) + " ns");

        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }
        try {
            long startISR = System.nanoTime();

            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader brISR = new BufferedReader(isr);

            long wordsISR = countWords(brISR);

            brISR.close();

            long endISR = System.nanoTime();
            System.out.println("\nInputStreamReader Word Count: " + wordsISR);
            System.out.println("InputStreamReader Time      : " + (endISR - startISR) + " ns");

        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }
    }
}
