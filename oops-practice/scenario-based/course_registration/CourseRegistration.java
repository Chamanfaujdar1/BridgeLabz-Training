package course_registration;

import java.util.*;

public class CourseRegistration implements RegistrationService{
    public void enroll(Student s) throws CourseLimitExceededException {
        s.addCourse();
    }
}
