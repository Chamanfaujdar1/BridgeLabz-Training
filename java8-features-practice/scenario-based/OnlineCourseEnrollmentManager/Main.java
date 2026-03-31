// package miniProjectAssignment.OnlineCourseEnrollmentManager;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<EnrollmentDetails> enrollments = Arrays.asList(
				new EnrollmentDetails("Aman", "B.Tech", "A", LocalDate.of(2026, 4, 15)),
				new EnrollmentDetails("Arun", "B.Tech", "B", LocalDate.of(2026, 5, 18)),
				new EnrollmentDetails("Naman", "Mechanical", "C", LocalDate.of(2026, 8, 20)),
				new EnrollmentDetails("Pramod", "Civil", "D", LocalDate.of(2026, 4, 15))
		);
		
		System.out.println("Filter By Courses: ");
		EnrollmentDetailsService.filterByCourse(enrollments, "Civil")
		.forEach(System.out::println);
		
		System.out.println("Filter By Course Category: ");
		EnrollmentDetailsService.filterByCourseCategory(enrollments, "B")
		.forEach(System.out::println);
		
		System.out.println("Group By Course Name: ");
		EnrollmentDetailsService.groupByCourseName(enrollments, "Mechanical")
		.forEach((course, list) -> {
			System.out.println(course);
			list.forEach(System.out::println);
		});
		
		System.out.println("Count of Number of enrollments: ");
		EnrollmentDetailsService.countNumberOfEnrollmentsPerCategory(enrollments)
		.forEach((category, count) ->
		System.out.println(category + " : " + count)
		);
		
		System.out.println("Sort By Enrollment Date: ");
		EnrollmentDetailsService.sortByEnrollmentDate(enrollments)
		.forEach(System.out::println);
				
	}

}
