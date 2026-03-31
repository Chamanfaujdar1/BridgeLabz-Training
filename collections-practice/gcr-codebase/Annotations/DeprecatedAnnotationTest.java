class LegacyCode {
    @Deprecated
    void o() {
        System.out.println("Old Method");
    }

    void n() {
        System.out.println("New Method");
    }
}

public class DeprecatedAnnotationTest {
    public static void main(String[] a) {
        LegacyCode x = new LegacyCode();
        x.o();
        x.n();
    }
}