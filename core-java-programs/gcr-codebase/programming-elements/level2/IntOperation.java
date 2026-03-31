import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int ans1 = a+b*c;
        int ans2 = a*b+c;
        int ans3 = c+a/b;

        System.out.println(ans1 + ", " + ans2 + ", " + ans3);
    }
}
