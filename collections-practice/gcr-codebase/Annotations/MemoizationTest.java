import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Cacheable {
}

class Calculator {
    Map<Integer, Integer> m = new HashMap<>();

    @Cacheable
    int f(int x) {
        // Ideally, an aspect or proxy would handle this logic based on annotation.
        // Here, logic is embedded for demonstration as provided in original snippet.
        if (m.containsKey(x)) {
            System.out.println("Returning cached value for " + x);
            return m.get(x);
        }
        System.out.println("Calculating value for " + x);
        int r = x * x;
        m.put(x, r);
        return r;
    }
}

public class MemoizationTest {
    public static void main(String[] a) {
        Calculator c = new Calculator();
        System.out.println(c.f(4));
        System.out.println(c.f(4));
    }
}