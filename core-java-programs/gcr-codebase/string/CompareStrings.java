import java.util.*;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        boolean areEqual = true;

        if(str1.length() != str2.length()){
            areEqual = false;
        }
        else{
            for(int i=0; i<str1.length(); i++){
                if(str1.length() != str2.length() || str1.charAt(i) != str2.charAt(i)){
                    areEqual = false;
                    break;
                }
                else{
                    areEqual = true;
                }

            }
        }
        if(areEqual){
            System.out.println("Strings are equal");
        }
        else{
            System.out.println("Strings are not equal");
        }
    }
}
