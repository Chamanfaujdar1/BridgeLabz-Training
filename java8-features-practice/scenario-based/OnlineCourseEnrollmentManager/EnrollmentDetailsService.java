// package miniProjectAssignment.OnlineCourseEnrollmentManager;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentDetailsService {
	public static List<EnrollmentDetails> filterByCourse(List<EnrollmentDetails> enrollments, String courseName){
		return enrollments.stream()
				.filter(e -> e.getCourseName().equalsIgnoreCase(courseName))
				.collect(Collectors.toList());
	}
	
	public static List<EnrollmentDetails> filterByCourseCategory(List<EnrollmentDetails> enrollments, String courseCategory){
		return enrollments.stream()
				.filter(e -> e.getCourseCategory().equalsIgnoreCase(courseCategory))
				.collect(Collectors.toList());
	}
	
	public static Map<String, List<EnrollmentDetails>> groupByCourseName(List<EnrollmentDetails> enrollments, String courseName){
		return enrollments.stream()
				.collect(Collectors.groupingBy(EnrollmentDetails::getCourseName));
	}
	
	public static Map<String, Long> countNumberOfEnrollmentsPerCategory(List<EnrollmentDetails> enrollments){
		return enrollments.stream()
				.collect(Collectors.groupingBy(EnrollmentDetails::getCourseCategory,
						Collectors.counting()
		));
	}
	
	public static List<EnrollmentDetails> sortByEnrollmentDate(List<EnrollmentDetails> enrollments){
		return enrollments.stream()
				.sorted(Comparator.comparing(EnrollmentDetails::getEnrollmentDate))
				.collect(Collectors.toList());
	}
}
