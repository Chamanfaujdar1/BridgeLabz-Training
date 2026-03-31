import java.lang.reflect.*;

interface Greeting {
    void hi();
}

class RealGreeting implements Greeting {
    public void hi() {
        System.out.println("Hello");
    }
}

public class DynamicProxyDemo {
    public static void main(String[] a) {
        Greeting g = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[] { Greeting.class },
                (o, m, x) -> {
                    System.out.println("Invoking: " + m.getName());
                    return m.invoke(new RealGreeting());
                });
        g.hi();
    }
}