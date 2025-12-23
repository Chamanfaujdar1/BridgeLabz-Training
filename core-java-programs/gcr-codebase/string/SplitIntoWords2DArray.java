import java.util.*;
public class SplitIntoWords2DArray {
    public static int lengthFinder(String str){
        int count = 0;
        while(true){
            try{
                str.charAt(count);
                count++;
            } catch(Exception e){
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
            for(int j=spaceIndexes[i]+1; j<spaceIndexes[i+1]; j++){
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] wordLengthTable = wordLength2D(words);

        System.out.println("Word Length");

        for(int i=0; i<wordLengthTable.length; i++){
            String word = wordLengthTable[i][0];
            int length = Integer.parseInt(wordLengthTable[i][1]);
            System.out.println(word + " " + length);
        }
    }
}
