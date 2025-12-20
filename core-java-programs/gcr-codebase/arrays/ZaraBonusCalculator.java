import java.util.Scanner;

public class ZaraBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int EMP_COUNT = 10;
        double[] salary = new double[EMP_COUNT];
        double[] yearsOfService = new double[EMP_COUNT];

        double[] bonus = new double[EMP_COUNT];
        double[] newSalary = new double[EMP_COUNT];

        double totalBonus = 0.0;
        double totaloldSalary = 0.0;
        double totalNewSalary = 0.0;

        for(int i=0; i<EMP_COUNT; i++){
            System.out.print("Enter salary of employee " + (i+1) + ": ");
            double sal = sc.nextDouble();
            double yrs = sc.nextDouble();

            if(sal <= 0 || yrs < 0){
                System.out.println("Invalid Input");
                i--; // to repeat the iteration for valid input
                continue;
            }

            salary[i] = sal;
            yearsOfService[i] = yrs;
        }

        for(int i=0; i<EMP_COUNT; i++){
            if(yearsOfService[i] > 5){
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totaloldSalary += salary[i];
            totalNewSalary += newSalary[i];

            System.out.println("ZARA BONUS SUMMARY");
            System.out.println("Total Old Salary: " + totaloldSalary);
            System.out.println("Total Bonus: " + totalBonus);
            System.out.println("Total New Salary: " + totalNewSalary);
        }
    }
}
