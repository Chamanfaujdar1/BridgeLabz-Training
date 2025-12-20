import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double  weight = sc.nextDouble();
        double height = sc.nextDouble();

        double bmi = weight / ((height * height)/10000);
        String status;

        if(bmi <= 18.4){
            status = "Underweight";
        }
        else if(bmi >= 18.5 && bmi <= 24.9){
            status = "Normal";
        }
        else if(bmi >= 25.0 && bmi <= 39.9){
            status = "Overweight";
        }
        else{
            status = "Obese";
        }
        System.out.println("\n----- BMI Report -----");
        System.out.println("BMI" + bmi);
        System.out.println("Status: " + status);
    }
}
