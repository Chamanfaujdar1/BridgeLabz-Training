import java.lang.reflect.*;
import java.util.*;

class MathM {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }
}

public class MethodInvoke {
    public static void main(String[] a) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter method name (add, sub, mul): ");
        String n = s.nextLine();
        Method m = MathM.class.getMethod(n, int.class, int.class);
        System.out.println("Result: " + m.invoke(new MathM(), 6, 2));
    }
}