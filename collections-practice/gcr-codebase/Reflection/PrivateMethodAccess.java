import java.lang.reflect.*;

class CalculatorC {
    private int mul(int a, int b) {
        return a * b;
    }
}

public class PrivateMethodAccess {
    public static void main(String[] a) throws Exception {
        CalculatorC c = new CalculatorC();
        Method m = CalculatorC.class.getDeclaredMethod("mul", int.class, int.class);
        m.setAccessible(true);
        System.out.println("Result of private method 'mul': " + m.invoke(c, 3, 4));
    }
}