import java.lang.reflect.*;

class PersonP {
    private int age;
}

public class PrivateFieldAccess {
    public static void main(String[] a) throws Exception {
        PersonP p = new PersonP();
        Field f = PersonP.class.getDeclaredField("age");
        f.setAccessible(true);
        f.setInt(p, 25);
        System.out.println("Private field 'age' value: " + f.getInt(p));
    }
}