public class SortCompare {

    static void bubble(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - 1 - i; j++)
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
    }

    static void merge(int[] a, int l, int r) {
        if (l >= r)
            return;
        int m = (l + r) / 2;
        merge(a, l, m);
        merge(a, m + 1, r);

        int[] t = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r)
            t[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];
        while (i <= m)
            t[k++] = a[i++];
        while (j <= r)
            t[k++] = a[j++];

        for (int x = 0; x < t.length; x++)
            a[l + x] = t[x];
    }

    static int part(int[] a, int l, int h) {
        int p = a[h], i = l - 1;
        for (int j = l; j < h; j++) {
            if (a[j] < p) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[h];
        a[h] = t;
        return i + 1;
    }

    static void quick(int[] a, int l, int h) {
        if (l < h) {
            int p = part(a, l, h);
            quick(a, l, p - 1);
            quick(a, p + 1, h);
        }
    }
}