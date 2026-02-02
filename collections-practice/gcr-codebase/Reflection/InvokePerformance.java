import java.lang.reflect.*;

class TimerTask {
    void run() {
        for (int i = 0; i < 1000000; i++)
            ;
    }
}

public class InvokePerformance {
    public static void main(String[] a) throws Exception {
        Method m = TimerTask.class.getDeclaredMethod("run");
        TimerTask t = new TimerTask();
        long s = System.nanoTime();
        m.invoke(t);
        long e = System.nanoTime();
        System.out.println("Execution time (ns): " + (e - s));
    }
}