public class StringCompare {

    public static void main(String[] args) {
        int n = 100000;

        long s1 = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++)
            s += "a";
        long e1 = System.nanoTime();

        long s2 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append("a");
        long e2 = System.nanoTime();

        long s3 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++)
            sbf.append("a");
        long e3 = System.nanoTime();

        System.out.println("String: " + (e1 - s1));
        System.out.println("StringBuilder: " + (e2 - s2));
        System.out.println("StringBuffer: " + (e3 - s3));
    }
}