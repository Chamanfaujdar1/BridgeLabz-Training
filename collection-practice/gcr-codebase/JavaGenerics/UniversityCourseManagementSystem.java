import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private final String courseCode;
    private final String courseName;
    private final int credits;

    public CourseType(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public abstract String evaluationType();

    @Override
    public String toString() {
        return String.format("Code: %s | Name: %s | Credits: %d | Evaluation: %s",
                courseCode, courseName, credits, evaluationType());
    }
}

class ExamCourse extends CourseType {
    private final int examMarks;

    public ExamCourse(String courseCode, String courseName, int credits, int examMarks) {
        super(courseCode, courseName, credits);
        this.examMarks = examMarks;
    }

    @Override
    public String evaluationType() {
        return "Exam-Based (" + examMarks + " marks)";
    }
}

class AssignmentCourse extends CourseType {
    private final int totalAssignments;

    public AssignmentCourse(String courseCode, String courseName, int credits, int totalAssignments) {
        super(courseCode, courseName, credits);
        this.totalAssignments = totalAssignments;
    }

    @Override
    public String evaluationType() {
        return "Assignment-Based (" + totalAssignments + " assignments)";
    }
}

class ResearchCourse extends CourseType {
    private final String researchTopic;

    public ResearchCourse(String courseCode, String courseName, int credits, String researchTopic) {
        super(courseCode, courseName, credits);
        this.researchTopic = researchTopic;
    }

    @Override
    public String evaluationType() {
        return "Research-Based (Topic: " + researchTopic + ")";
    }
}

class Course<T extends CourseType> {
    private final String departmentName;
    private final List<T> courseList;

    public Course(String departmentName) {
        this.departmentName = departmentName;
        this.courseList = new ArrayList<>();
    }

    public void addCourse(T course) {
        courseList.add(course);
        System.out.println("Added: " + course.getCourseName() + " in " + departmentName + " department");
    }

    public List<T> getAllCourses() {
        return courseList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int totalCourses() {
        return courseList.size();
    }
}

class CourseDisplayUtil {

    public static void displayCourses(List<? extends CourseType> courses) {
        System.out.println("\n University Course List:");
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (CourseType c : courses) {
            System.out.println(c);
        }
    }
}

public class UniversityCourseManagementSystem {
    public static void main(String[] args) {

        Course<ExamCourse> csDepartment = new Course<>("Computer Science");
        Course<AssignmentCourse> itDepartment = new Course<>("Information Technology");
        Course<ResearchCourse> researchDepartment = new Course<>("Research Department");

        csDepartment.addCourse(new ExamCourse("CS101", "Data Structures", 4, 100));
        csDepartment.addCourse(new ExamCourse("CS102", "Operating Systems", 4, 100));

        itDepartment.addCourse(new AssignmentCourse("IT201", "Web Development", 3, 8));
        itDepartment.addCourse(new AssignmentCourse("IT202", "Database Management", 3, 6));

        researchDepartment.addCourse(new ResearchCourse("RS301", "AI Research", 5, "Deep Learning"));
        researchDepartment.addCourse(new ResearchCourse("RS302", "Blockchain Research", 5, "Smart Contracts"));

        CourseDisplayUtil.displayCourses(csDepartment.getAllCourses());
        CourseDisplayUtil.displayCourses(itDepartment.getAllCourses());
        CourseDisplayUtil.displayCourses(researchDepartment.getAllCourses());
    }
}
