import java.util.*;

public class SubstringOccurrences {
    public static int countSubstring(String str, String subString){
        int count = 0;
        for(int i=0; i<=str.length()-subString.length(); i++){
            int j;

            for(j=0; j<subString.length(); j++){
                if(str.charAt(i+j) != subString.charAt(j)){
                    break;
                }
            }

            if(j == subString.length()){
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        System.out.print("Enter the substring: ");
        String subString = sc.next();

        int res = countSubstring(str, subString);
        System.out.print("Number of times a given string occurred is: " + res);


    }
}
