import java.util.*;

public class SentenceFormatter {
    public static String formatSentence(String sentence){
        if(sentence == null || sentence.isEmpty()){
            return "";
        }
        String cleanSentence = sentence.trim().replaceAll("\\s+", " ");
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for(int i=0; i<cleanSentence.length(); i++){
            char current = cleanSentence.charAt(i);

            if(capitalizeNext && Character.isLetter(current)){
                result.append(Character.toUpperCase(current));
                capitalizeNext = false;
            }
            else{
                result.append(current);
            }

            if(current == '.' || current == '?' || current == '!'){
                capitalizeNext = true;

                if(i+1 < cleanSentence.length() && cleanSentence.charAt(i+1) != ' '){
                    result.append(" ");
                }
            }
        }

        return result.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String sentence = sc.nextLine();

        System.out.println("Formatted Sentence: \"" + formatSentence(sentence) + "\"");
    }
}
