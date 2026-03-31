import java.util.Arrays;

public class SearchComparison {

    static int linear(int[] a, int t) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == t)
                return i;
        }
        return -1;
    }

    static int binary(int[] a, int t) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == t)
                return m;
            if (a[m] < t)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 100000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i;

        int t = 99999;

        long s1 = System.nanoTime();
        linear(a, t);
        long e1 = System.nanoTime();

        long s2 = System.nanoTime();
        binary(a, t);
        long e2 = System.nanoTime();

        System.out.println("Linear: " + (e1 - s1));
        System.out.println("Binary: " + (e2 - s2));
    }
}