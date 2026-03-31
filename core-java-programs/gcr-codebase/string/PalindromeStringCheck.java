import java.util.*;
public class PalindromeStringCheck {
    public static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = sc.next();

        if(isPalindrome(str)){
            System.out.println(str + " is Palindromic string");
        }
        else{
            System.out.println(str + " is not Palindromic string");
        }
    }
}
