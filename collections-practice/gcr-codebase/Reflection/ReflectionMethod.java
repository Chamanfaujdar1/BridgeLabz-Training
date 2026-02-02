import java.lang.reflect.*;
import java.util.*;

public class ReflectionMethod {
    public static void main(String[] a) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter class name (e.g. java.util.ArrayList): ");
        String className = s.nextLine();
        Class<?> c = Class.forName(className);

        System.out.println("Methods:");
        for (Method m : c.getDeclaredMethods())
            System.out.println(m.getName());

        System.out.println("Fields:");
        for (Field f : c.getDeclaredFields())
            System.out.println(f.getName());

        System.out.println("Constructors:");
        for (Constructor<?> k : c.getDeclaredConstructors())
            System.out.println(k.getName());
    }
}