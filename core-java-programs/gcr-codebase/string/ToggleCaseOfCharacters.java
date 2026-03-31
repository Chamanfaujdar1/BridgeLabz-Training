import java.util.*;
public class ToggleCaseOfCharacters {
    public static String toggle(String str){
        String ans = "";
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch >= 'A' && ch <= 'Z'){
                ch = (char) (ch + 32);
            }
            else if(ch >= 'a' && ch <= 'z'){
                ch = (char) (ch - 32);
            }

            ans += ch;
        }

        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
  
        System.out.print("Enter the string: " + toggle(str));


    }
}
