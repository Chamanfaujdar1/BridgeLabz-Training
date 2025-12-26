import java.util.*;
public class ReverseString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        String res = "";
        for(int i=str.length()-1; i>=0; i--){
            res += str.charAt(i);
        }

        System.out.println("Reversed String: " + res);
    }
}
