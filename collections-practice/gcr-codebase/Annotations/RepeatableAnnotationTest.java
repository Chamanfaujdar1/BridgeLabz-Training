import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String d();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class BuggyClass {
    @BugReport(d = "NPE")
    @BugReport(d = "Logic")
    void m() {
    }
}

public class RepeatableAnnotationTest {
    public static void main(String[] a) throws Exception {
        Method m = BuggyClass.class.getDeclaredMethod("m");
        BugReport[] b = m.getAnnotationsByType(BugReport.class);
        for (BugReport x : b)
            System.out.println("Bug Report: " + x.d());
    }
}