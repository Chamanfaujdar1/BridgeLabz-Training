package course_registration;

public class Student extends Person {
    private int courseCount = 0;
    private final int MAX = 3;

    public Student(String name) {
        super(name);
    }

    public void addCourse() throws CourseLimitExceededException {
        if (courseCount >= MAX)
            throw new CourseLimitExceededException("Course limit exceeded");
        courseCount++;
        System.out.println("Course added");
    }

    public void dropCourse() {
        if (courseCount > 0)
            courseCount--;
    }
}