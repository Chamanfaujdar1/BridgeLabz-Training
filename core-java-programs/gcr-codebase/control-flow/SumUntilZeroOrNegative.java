import java.util.*;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double number;
        number = sc.nextDouble();

        while(true){
            number = sc.nextDouble();

            if(number <= 0){
                break;
            }

            total += number;
        }

        System.out.println(total);
    }
}
