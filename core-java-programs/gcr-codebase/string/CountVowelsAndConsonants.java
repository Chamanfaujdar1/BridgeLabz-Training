import java.util.*;
public class CountVowelsAndConsonants {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = sc.nextLine();

        int vowelCount = 0;
        String lowerCase = str.toLowerCase();

        for(char ch : lowerCase.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowelCount++;
            }
        }

        System.out.println("Vowel Count: " + vowelCount);
        System.out.println("Consonant Count: " + (lowerCase.length() - vowelCount));
    }
}
