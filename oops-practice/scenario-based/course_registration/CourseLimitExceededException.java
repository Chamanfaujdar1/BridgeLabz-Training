package course_registration;

import java.util.*;

class CourseLimitExceededException extends Exception{
    public CourseLimitExceededException(String message){
        super(message);
    }
}
