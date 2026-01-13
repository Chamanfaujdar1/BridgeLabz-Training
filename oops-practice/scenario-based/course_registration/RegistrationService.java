package course_registration;

public interface RegistrationService {
    void enroll(Student s) throws CourseLimitExceededException;
}