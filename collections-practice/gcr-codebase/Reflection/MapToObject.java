import java.lang.reflect.*;
import java.util.*;

class UserU {
    public String n;
    public int a;
}

public class MapToObject {
    static <T> T obj(Class<T> c, Map<String, Object> m) throws Exception {
        T o = c.getDeclaredConstructor().newInstance();
        for (String k : m.keySet()) {
            Field f = c.getDeclaredField(k);
            f.setAccessible(true);
            f.set(o, m.get(k));
        }
        return o;
    }

    public static void main(String[] a) throws Exception {
        Map<String, Object> m = new HashMap<>();
        m.put("n", "Sam");
        m.put("a", 30);
        UserU u = obj(UserU.class, m);
        System.out.println("Mapped object: " + u.n + " " + u.a);
    }
}