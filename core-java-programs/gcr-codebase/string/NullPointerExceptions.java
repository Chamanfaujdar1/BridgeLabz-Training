import java.util.*;
public class NullPointerExceptions {
    public static void generateException(){
        String text = null;
        System.out.println(text.length());
    }

    public static void handleException(){
        String text = null;
        try{
            System.out.println(text.length());
        }
        catch(NullPointerException e){
            System.out.println("Caught a NullPointerException: ");
            System.out.println(e.getMessage());

        }
    }
    public static void main(String[] args) {
        System.out.println("Generating NullPointerException:");
        System.out.println("Handling NullPointerException: ");
        handleException();
    }
}
