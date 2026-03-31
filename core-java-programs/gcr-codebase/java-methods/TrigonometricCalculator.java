import java.util.Scanner;

public class TrigonometricCalculator {

    public double[] calculateTrigonometricFunctions(double angle) {
        double[] result = new double[3];

        double radians = Math.toRadians(angle);

        result[0] = Math.sin(radians);   
        result[1] = Math.cos(radians);   
        result[2] = Math.tan(radians);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        TrigonometricCalculator calculator = new TrigonometricCalculator();

        double[] values = calculator.calculateTrigonometricFunctions(angle);

        System.out.println("Sine of angle: " + values[0]);
        System.out.println("Cosine of angle: " + values[1]);
        System.out.println("Tangent of angle: " + values[2]);

        sc.close();
    }
}
