import java.util.*;

public class LongestWordInASentence {
    public static String longestWord(String str){
        String longestWord = "";
        String currentWord = "";

        for(int i=0; i<=str.length(); i++){
            if(i == str.length() || str.charAt(i) == ' '){
                if(currentWord.length() > longestWord.length()){
                    longestWord = currentWord;
                }
                currentWord = "";
            }
            else{
                    currentWord += str.charAt(i);
            }
        }

        return longestWord;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        System.out.println("Longest Word In A Sentence is: " + longestWord(str));

    }
}
