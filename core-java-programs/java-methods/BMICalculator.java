import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];

            double heightMeters = heightCm / 100;

            double bmi = weight / (heightMeters * heightMeters);

            data[i][2] = bmi;
        }
    }

    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] bmiData = new double[10][3];

        for (int i = 0; i < bmiData.length; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            bmiData[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            bmiData[i][1] = sc.nextDouble();
        }

        calculateBMI(bmiData);

        String[] bmiStatus = determineBMIStatus(bmiData);

        System.out.println("BMI Report: ");
        System.out.println("Person | Weight(kg) | Height(cm) | BMI | Status");
        System.out.println("----------------------");

        for (int i = 0; i < bmiData.length; i++) {
            System.out.printf(
                "%6d | %10.2f | %10.2f | %4.2f | %s%n",
                (i + 1),
                bmiData[i][0],
                bmiData[i][1],
                bmiData[i][2],
                bmiStatus[i]
            );
        }

        sc.close();
    }
}
