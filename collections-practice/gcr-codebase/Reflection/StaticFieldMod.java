import java.lang.reflect.*;

class Config {
    private static String key = "OLD";
}

public class StaticFieldMod {
    public static void main(String[] a) throws Exception {
        Field f = Config.class.getDeclaredField("key");
        f.setAccessible(true);
        f.set(null, "NEW");
        System.out.println("Modified static field 'key': " + f.get(null));
    }
}