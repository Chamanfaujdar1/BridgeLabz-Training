import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Priority {
    String l() default "HIGH";
}

class Task {
    @Priority
    void a() {
    }

    @Priority(l = "LOW")
    void b() {
    }
}

public class DefaultValueTest {
    public static void main(String[] a) {
        for (Method m : Task.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Priority.class)) {
                System.out.println(m.getName() + " Priority: " + m.getAnnotation(Priority.class).l());
            }
        }
    }
}