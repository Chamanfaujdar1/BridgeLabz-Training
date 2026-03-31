import java.util.*;

public class Anagram {
    public static boolean isAnagram(String str1, String str2){
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int count1 = 0, count2 = 0;

            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == ch) count1++;
                if (str2.charAt(j) == ch) count2++;
            }

            if (count1 != count2) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String str1 = sc.next();
        System.out.print("Enter second String: ");
        String str2 = sc.next();

        if(isAnagram(str1, str2)){
            System.out.println("Both Strings are anagram");
        }
        else{
            System.out.println("Both strings are not anagram");
        }
    }
}
