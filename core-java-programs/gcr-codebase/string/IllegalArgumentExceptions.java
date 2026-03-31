import java.util.*;
public class IllegalArgumentExceptions {

    public static void generateException(String str){
        System.out.println(str.substring(4, 2));
    }

    public static void handleException(String str){
        try{
            System.out.println(str.substring(4,2));

        }
        catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException caught: " + e);
        }
        catch(RuntimeException e){
            System.out.println("RunTimeException Caught " + e);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println("Calling method to generate exception: ");
        try{
            generateException(str);
        }
        catch(Exception e){
            System.out.println("Program stopped due to runtime exception");
        }

        handleException(str);
    }
}
