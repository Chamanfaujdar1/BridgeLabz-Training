import java.util.*;

public class BMIFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input height in cm and weight in kg
        double height = sc.nextDouble();
        double weight = sc.nextDouble();

        double bmi = weight / ((height * height) / 10000);   // formula to calculate BMI

        // Print BMI value
        if(bmi < 18.5){
            System.out.println("Underweight");
        } else if(bmi >= 18.5 && bmi < 24.9){
            System.out.println("Normal weight");
        } else if(bmi >= 25 && bmi < 29.9){
            System.out.println("Overweight");
        } else {
            System.out.println("Obesity");
        }
    }
}
