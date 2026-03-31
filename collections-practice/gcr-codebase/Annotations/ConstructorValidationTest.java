import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLen {
    int v();
}

class UserString {
    @MaxLen(v = 5)
    String u;

    UserString(String x) {
        // In a real framework, validation would be done via reflection here based on
        // annotation
        if (x.length() > 5)
            throw new IllegalArgumentException("String too long");
        u = x;
    }
}

public class ConstructorValidationTest {
    public static void main(String[] a) {
        try {
            new UserString("Tom");
            System.out.println("User created successfully");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}