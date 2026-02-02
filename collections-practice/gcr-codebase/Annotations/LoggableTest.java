import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Loggable {
}

class TimerJob {
    @Loggable
    void r() {
        for (int i = 0; i < 100000; i++)
            ;
    }
}

public class LoggableTest {
    public static void main(String[] a) throws Exception {
        TimerJob t = new TimerJob();
        Method m = TimerJob.class.getDeclaredMethod("r");
        long s = System.nanoTime();
        m.invoke(t);
        long e = System.nanoTime();
        System.out.println("Execution Time: " + (e - s) + " ns");
    }
}