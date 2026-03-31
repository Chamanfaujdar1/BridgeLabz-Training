import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptions {
    public static void generateException(String[] names){
        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names){
        try{
            System.out.println(names[names.length]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error caught: " + e);
        }
        catch(RuntimeException e){
            System.out.println("Runtime Exception caught: " + e);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of names: ");
        int size = sc.nextInt();

        sc.nextLine();

        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Program stopped due to runtime exception.");
        }

        System.out.println("\nCalling method to handle exception:");
        handleException(names);
    }
}
