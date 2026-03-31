import java.util.*;

public class SuppressWarningsTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] a) {
        ArrayList l = new ArrayList();
        l.add(10);
        l.add("A");
        System.out.println(l);
    }
}