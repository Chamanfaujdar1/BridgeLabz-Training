public class Fibonacci {

    static int rec(int n) {
        if (n <= 1)
            return n;
        return rec(n - 1) + rec(n - 2);
    }

    static int itr(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int s = a + b;
            a = b;
            b = s;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(itr(50));
    }
}