public class StringBufferVsStringBuilder {

    public static void main(String[] args) {

        int n = 1_000_000;
        String word = "hello";

        long startBuilder = System.nanoTime();
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb1.append(word);
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        long startBuffer = System.nanoTime();
        StringBuffer sb2 = new StringBuffer();

        for (int i = 0; i < n; i++) {
            sb2.append(word);
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        System.out.println("StringBuilder Time: " + builderTime + " ns");
        System.out.println("StringBuffer Time : " + bufferTime + " ns");
    }
}
