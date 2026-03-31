public class SearchDataSet {

    static boolean arraySearch(int[] a, int t) {
        for (int x : a)
            if (x == t)
                return true;
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        long s1 = System.nanoTime();
        arraySearch(a, 99999);
        long e1 = System.nanoTime();

        System.out.println("Array search: " + (e1 - s1));
    }
}