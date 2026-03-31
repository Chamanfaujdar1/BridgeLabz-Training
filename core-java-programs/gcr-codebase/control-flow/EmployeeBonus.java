import java.util.*;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        int yearsOfService = sc.nextInt();

        if(yearsOfService > 5){
            double bonus = 0.05 * salary;
            System.out.println(bonus);
        } else {
            System.out.println("No bonus");
        }
    }
}
