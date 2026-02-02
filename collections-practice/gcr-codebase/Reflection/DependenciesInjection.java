import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

class ServiceD {
    void show() {
        System.out.println("ServiceD Injected");
    }
}

class ClientC {
    @Inject
    ServiceD d;
}

public class DependenciesInjection {
    public static void main(String[] a) throws Exception {
        ClientC c = new ClientC();
        for (Field f : c.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                f.set(c, new ServiceD());
            }
        }
        c.d.show();
    }
}