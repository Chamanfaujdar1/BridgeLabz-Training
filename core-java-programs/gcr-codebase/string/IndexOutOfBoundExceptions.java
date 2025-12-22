import java.util.*;

public class IndexOutOfBoundExceptions {
    public static void generateException(String str){
        System.out.println("Character at invalid index: " + str.charAt(str.length()));
    }

    public static void handleException(String str){
        try{
            System.out.println("Character at invalid index: " + str.charAt(str.length()));
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("Exception caught: " + e);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");

        String str = sc.nextLine();

        System.out.println("Generating exception: ");
        try{
            generateException(str);
        }
        catch(Exception e){
            System.out.println("Program stopped due to exception");
        }

        handleException(str);
    }
}
