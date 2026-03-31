public class PalindromeChecker {
    String text;

    PalindromeChecker(String text){
        this.text = text;
    }

    boolean isPalindrome(){
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void displayResult(){
        if(isPalindrome()){
            System.out.println(text + " is palindrome");
        }
        else{
            System.out.println(text + " is nor palindrome");
        }
    }
    public static void main(String[] args){
        PalindromeChecker checker1 = new PalindromeChecker("A man a plan a canal Panama");
        checker1.displayResult();

        PalindromeChecker checker2 = new PalindromeChecker("Hello");
        checker2.displayResult();
    }
}
