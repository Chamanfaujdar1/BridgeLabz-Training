import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String n();
}

class UserData {
    @JsonField(n = "user_name")
    String u = "Sam";
}

public class JsonSerializationTest {
    public static void main(String[] a) throws Exception {
        UserData o = new UserData();
        StringBuilder s = new StringBuilder("{");

        for (Field f : o.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(JsonField.class)) {
                f.setAccessible(true);
                s.append("\"").append(f.getAnnotation(JsonField.class).n())
                        .append("\":\"").append(f.get(o)).append("\"");
            }
        }
        s.append("}");
        System.out.println(s);
    }
}