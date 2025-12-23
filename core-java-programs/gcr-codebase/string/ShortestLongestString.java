import java.util.Scanner;

public class ShortestLongestString {
    public static int lengthFinder(String str){
        int count = 0;
        while(true){
            try{
                str.charAt(count);
                count++;
            }
            catch(Exception e){
                break;
            }
        }
        return count;
    }

    public static String[] customSplit(String text){
        int length = lengthFinder(text);
        int wordCount = 1;

        for(int i=0; i<length; i++){
            if(text.charAt(i) == ' '){
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount+1];
        spaceIndexes[0] = -1;
        spaceIndexes[wordCount] = length;

        int idx = 1;
        for(int i=0; i<length; i++){
            if(text.charAt(i) == ' '){
                spaceIndexes[idx++] = i;
            }
        }

        String[] words = new String[wordCount];
        for(int i=0; i<wordCount; i++){
            String word = "";
            for(int j=spaceIndexes[i] + 1; j< spaceIndexes[i+1]; j++){
                word += text.charAt(j);
            }
            words[i] = word;

        }
        return words;

    }

    public static String[][] wordLength2D(String[] words){
        String[][] result = new String[words.length][2];

        for(int i=0; i<words.length; i++){
            int len = lengthFinder(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }

        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordLengthTable){
        int shortest = Integer.parseInt(wordLengthTable[0][1]);
        int longest = shortest;

        for (int i = 1; i < wordLengthTable.length; i++) {
            int length = Integer.parseInt(wordLengthTable[i][1]);

            if (length < shortest) {
                shortest = length;
            }

            if (length > longest) {
                longest = length;
            }
        }

        return new int[]{shortest, longest};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] wordLengthTable = wordLength2D(words);

        int[] result = findShortestAndLongest(wordLengthTable);

        System.out.println("Shortest word length: " + result[0]);
        System.out.println("Longest word length: " + result[1]);
    }
}
