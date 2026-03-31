import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface TaskDetail {
    String t();

    String a();

    String p() default "MEDIUM";
}

class ProjectTask {
    @TaskDetail(t = "Login", a = "Dev1")
    void m1() {
    }

    @TaskDetail(t = "Pay", a = "Dev2", p = "HIGH")
    void m2() {
    }
}

public class MultiValueAnnotationTest {
    public static void main(String[] a) {
        for (Method m : ProjectTask.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(TaskDetail.class)) {
                TaskDetail t = m.getAnnotation(TaskDetail.class);
                System.out.println("Task: " + t.t() + ", Author: " + t.a() + ", Priority: " + t.p());
            }
        }
    }
}