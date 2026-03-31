import java.util.*;


public class NumberFormatExceptions {
    public static void generateException(String text){
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    public static void handleException(String text){
        try{
            int number = Integer.parseInt(text);
        }
        catch(NumberFormatException e){
            System.out.println("Number format exception caught: " + e);
        }
        catch(RuntimeException e){
            System.out.println("RuntimeException caught: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Calling method to generate exception:");

        try{
            generateException(input);
        }
        catch(Exception e){
            System.out.println("Program stopped due to runtime exception");
        }

        System.out.println("calling method to handle exception:");
        handleException(input);
    }
}


