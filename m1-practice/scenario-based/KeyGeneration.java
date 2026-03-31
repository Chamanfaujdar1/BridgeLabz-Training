import java.util.*;
import java.util.regex.*;

public class KeyGeneration {
    public static String processString(String str){
        if(str.length() == 0){
            return "Invalid Input (empty string)";
        }
        else if(str.length() < 6){
            return "Invalid Input (length < 6)";
        }
        else if(str.contains(" ")){
            return "Invalid Input (contains space)";
        }
        else if(str.matches(".*[0-9].*")){
            return "Invalid Input (contains digits)";
        }
        else if(!str.matches("[a-zA-Z]+")){
            return "Invalid Input (contains special character)";
        }

        str = str.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if((int) ch % 2 != 0){
                sb.append(ch);
            }
        }

        sb.reverse();

        String result = sb.toString();

        StringBuilder ans = new StringBuilder();
        for(int i=0; i<result.length(); i++){
            if(i%2 == 0){
                ans.append(Character.toUpperCase(result.charAt(i)));
            }
            else{
                ans.append(result.charAt(i));
            }
        }

        return "The generated key is - " + ans.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++){
            String input = sc.nextLine();
            System.out.println(processString(input));
        }
    }
}
