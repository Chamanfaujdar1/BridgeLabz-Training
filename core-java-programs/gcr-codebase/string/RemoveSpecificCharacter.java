import java.util.*;
public class RemoveSpecificCharacter {
    public static String removeCharacter(String str, char remove){
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != remove) {
                result += ch;
            }
        }
        return result;
    } 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();
        System.out.print("Enter the character to be removed: ");
        char ch = sc.next().charAt(0);

        System.out.println("Modified String: " + removeCharacter(str, ch));


    }

}
