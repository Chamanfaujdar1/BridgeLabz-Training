// Base Class (Level 1)
class Course {
    String courseName;
    int durationInWeeks;

    Course(String courseName, int durationInWeeks) {
        this.courseName = courseName;
        this.durationInWeeks = durationInWeeks;
    }

    void displayInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + durationInWeeks + " weeks");
    }
}

// Subclass (Level 2): Inherits Course
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int durationInWeeks, String platform, boolean isRecorded) {
        super(courseName, durationInWeeks);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Format: " + (isRecorded ? "Self-paced (Recorded)" : "Live Sessions"));
    }
}

// Subclass (Level 3): Inherits OnlineCourse (and indirectly Course)
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int durationInWeeks, String platform, 
                     boolean isRecorded, double fee, double discount) {
        super(courseName, durationInWeeks, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        double finalPrice = fee - (fee * discount / 100);
        System.out.println("Base Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Enrollment Price: $" + finalPrice);
    }
}

public class CourseSystem {
    public static void main(String[] args) {
        // Creating the most specialized object
        PaidOnlineCourse javaMastery = new PaidOnlineCourse(
            "Java Backend Development", 
            12, 
            "Udemy", 
            true, 
            199.99, 
            20.0
        );

        System.out.println("=== Course Enrollment Details ===");
        javaMastery.displayInfo();
    }
}
