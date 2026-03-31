import java.lang.reflect.*;

class PersonJ {
    String n = "Max";
    int a = 20;
}

public class ObjectToJson {
    public static void main(String[] a) throws Exception {
        PersonJ o = new PersonJ();
        String r = "{";
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            r += "\"" + f.getName() + "\":\"" + f.get(o) + "\",";
        }
        System.out.println("JSON-like output: " + r.substring(0, r.length() - 1) + "}");
    }
}