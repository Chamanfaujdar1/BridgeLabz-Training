public class Course {
    String courseName;
    int duration;
    double fee;

    static String instituteName = "Tech Academy";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
        System.out.println("-------------------------");
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + newName);
    }

    public static void main(String[] args) {

        Course c1 = new Course("Java Full Stack", 12, 1200.0);
        Course c2 = new Course("Data Science", 16, 1500.0);

        System.out.println("Initial Course Details:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        Course.updateInstituteName("Global BridgeLabz");

        System.out.println("\nAfter Update (Affects all instances):");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}