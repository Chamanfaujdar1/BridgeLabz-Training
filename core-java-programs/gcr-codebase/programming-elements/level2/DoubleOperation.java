import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double ans1 = a+b*c;
        double ans2 = a*b+c;
        double ans3 = c+a/b;

        System.out.println(ans1 + ", " + ans2 + ", " + ans3);
    }
}
