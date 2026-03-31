import java.util.Scanner;

public class SplitIntoWords {
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

        int index = 1;
        for(int i=0; i<length; i++){
            if(text.charAt(i) == ' '){
                spaceIndexes[index++] = i;
            }
        }

        String[] words = new String[wordCount];
        for(int i=0; i<wordCount; i++){
            String word = "";
            for(int j=spaceIndexes[i] +1; j<spaceIndexes[i+1]; j++){
                word += text.charAt(j);
            }

            words[i] = word;
        }
        return words;

    }

    public static boolean compareArrays(String[] arr1, String[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }

        for(int i=0; i<arr1.length; i++){
            if(!arr1[i].equals(arr2[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] customWords = customSplit(str);
        String[] builtInWords = str.split(" ");

        boolean result = compareArrays(customWords, builtInWords);

        System.out.println("Custom Split Result: ");
        for(String word : customWords){
            System.out.println(word);
        }

        System.out.println("Built-In Split Result: ");
        for(String word : builtInWords){
            System.out.println(word);
        }

        System.out.println("Do both methods produce the same result? " + result);


    }
}
