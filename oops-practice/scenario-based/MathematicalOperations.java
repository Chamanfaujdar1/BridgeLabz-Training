public class MathematicalOperations {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                "Factorial is not defined for negative numbers"
            );
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int a, int b) {
        if (a < 0) a = Math.abs(a);
        if (b < 0) b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                "Fibonacci is not defined for negative numbers"
            );
        }

        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        System.out.println("Factorial Tests:");
        System.out.println("5! = " + factorial(5));
        System.out.println("0! = " + factorial(0));

        System.out.println("\nPrime Tests:");
        System.out.println("7 is prime? " + isPrime(7));
        System.out.println("1 is prime? " + isPrime(1));
        System.out.println("-5 is prime? " + isPrime(-5));

        System.out.println("\nGCD Tests:");
        System.out.println("GCD(48, 18) = " + gcd(48, 18));
        System.out.println("GCD(-20, 10) = " + gcd(-20, 10));

        System.out.println("\nFibonacci Tests:");
        System.out.println("Fibonacci(0) = " + fibonacci(0));
        System.out.println("Fibonacci(1) = " + fibonacci(1));
        System.out.println("Fibonacci(7) = " + fibonacci(7));

    }
}
