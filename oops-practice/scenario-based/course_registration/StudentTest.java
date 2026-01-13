package course_registration;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student("Ram");
        RegistrationService r = new CourseRegistration();

        try {
            r.enroll(s);
            r.enroll(s);
            r.enroll(s);
            r.enroll(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}