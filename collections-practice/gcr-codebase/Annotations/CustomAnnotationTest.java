import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyCustomAnnotation {
    int p();

    String a();
}

class AnnotatedMethodClass {
    @MyCustomAnnotation(p = 1, a = "Sam")
    void x() {
    }
}

public class CustomAnnotationTest {
    public static void main(String[] a) {
        Method[] m = AnnotatedMethodClass.class.getDeclaredMethods();
        for (Method k : m) {
            if (k.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation t = k.getAnnotation(MyCustomAnnotation.class);
                System.out.println("Priority: " + t.p() + ", Author: " + t.a());
            }
        }
    }
}