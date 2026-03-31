import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String name();
}

@MyAnno(name = "John")
class AnnotatedClass {
}

public class AnnotationReader {
    public static void main(String[] a) {
        MyAnno x = AnnotatedClass.class.getAnnotation(MyAnno.class);
        System.out.println("Annotation name: " + x.name());
    }
}