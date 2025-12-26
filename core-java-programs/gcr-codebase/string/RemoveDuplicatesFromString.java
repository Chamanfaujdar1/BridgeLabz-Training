
import java.util.*;
public class RemoveDuplicatesFromString {
    public static String duplicateRemover(String str){
        String res = "";
        for(int i=0; i<str.length(); i++){
            char currentChar = str.charAt(i);
            boolean isDuplicate = false;

            for(int j=0; j<i; j++){
                if(str.charAt(j) == currentChar){
                    isDuplicate = true;
                    break;
                }
            }

            if(!isDuplicate){
                res += currentChar;
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();

        System.out.println("String After removing duplicates: " + duplicateRemover(str));
    }
}
