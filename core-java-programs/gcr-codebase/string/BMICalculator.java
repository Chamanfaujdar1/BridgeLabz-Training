import java.util.Scanner;

public class BMICalculator {
    public static String[] calculateIndividualBMI(double weight, double heightCm) {
        // Convert height from cm to meters
        double heightM = heightCm / 100.0;
        // Formula: BMI = weight / (height * height)
        double bmi = weight / (heightM * heightM);
        
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.format("%.2f", bmi), status};
    }

    public static String[][] processTeamData(double[][] rawData) {
        String[][] results = new String[rawData.length][4];

        for (int i = 0; i < rawData.length; i++) {
            double weight = rawData[i][0];
            double height = rawData[i][1];
            String[] bmiInfo = calculateIndividualBMI(weight, height);

            results[i][0] = String.valueOf(height);
            results[i][1] = String.valueOf(weight);
            results[i][2] = bmiInfo[0]; // BMI value
            results[i][3] = bmiInfo[1]; // Status
        }
        return results;
    }

    public static void displayTable(String[][] data) {
        System.out.println("\n------------------------------------------------------------");
        System.out.printf("%-10s | %-10s | %-10s | %-15s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s | %-10s | %-10s | %-15s\n", row[0], row[1], row[2], row[3]);
        }
        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] measurements = new double[10][2];

        System.out.println("Enter details for 10 team members:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("  Weight (kg): ");
            measurements[i][0] = sc.nextDouble();
            System.out.print("  Height (cm): ");
            measurements[i][1] = sc.nextDouble();
        }

        String[][] finalReport = processTeamData(measurements);
        displayTable(finalReport);

        sc.close();
    }
}
