import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Role {
    String v();
}

@Role(v = "ADMIN")
class SecureService {
    void run() {
        System.out.println("Service Running");
    }
}

public class RoleBasedAccessTest {
    public static void main(String[] a) throws Exception {
        String role = "USER"; // Simulate current user role
        Role r = SecureService.class.getAnnotation(Role.class);

        if (r != null && r.v().equals(role)) {
            new SecureService().run();
        } else {
            System.out.println("Access Denied!");
        }
    }
}