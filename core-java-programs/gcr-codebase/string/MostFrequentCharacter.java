import java.util.*;
public class MostFrequentCharacter {
    public static char frequencyCounter(String str){
        int maxCount = 0;
        char mostFrequent = str.charAt(0);

        for(int i=0; i<str.length(); i++){
            char current = str.charAt(i);
            int count = 0;

            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == current){
                    count++;
                }
            }

            if(count > maxCount){
                maxCount = count;
                 mostFrequent = current;
            }
        }

        return mostFrequent;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.next();

        System.out.print("Most frequent character: " + frequencyCounter(str));
    }
}
