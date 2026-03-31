import java.util.Scanner;
public static int lengthFinder(String str){
    int count = 0;

    while(true){
        try{
            str.charAt(count);
            count++;
        }
        catch(Exception e){
            break;
        }
    }

    return count;
}

public class LengthOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int lengthUsingCustomMethod = lengthFinder(str);
        int actualLength = str.length();

        System.out.println("Length using without builtin method: " + lengthUsingCustomMethod);
        System.out.println("Length using built in method: " + actualLength);
    }
}
