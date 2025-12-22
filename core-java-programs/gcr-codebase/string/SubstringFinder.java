import java.util.*;

public class SubstringFinder {

    public static String helper(String str, int startIndex, int endIndex){
        String substring = "";

        for(int i=startIndex; i<endIndex; i++){
            substring += str.charAt(i);
        }
        return substring;
    }

    public static boolean compareUsingCharAt(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                return false;
            }
        }
        return true;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();

        System.out.print("Enter the starting index: ");
        int startIndex = sc.nextInt();
        System.out.print("Enter the ending index: ");
        int endIndex = sc.nextInt();

        String manualSubstring = helper(str, startIndex, endIndex);
        String inBuiltSubstring = str.substring(startIndex, endIndex);

        boolean result = compareUsingCharAt(manualSubstring, inBuiltSubstring);

        System.out.println("Manual Substring: " + manualSubstring);
        System.out.println("In-built Substring: " + inBuiltSubstring);
        System.out.println("Are both substrings equal? " + result);

    }
}
