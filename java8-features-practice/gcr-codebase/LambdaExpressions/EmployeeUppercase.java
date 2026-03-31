// package java8_features_practice.LambdaExpressions;

import java.util.*;
import java.util.stream.Collectors;


public class EmployeeUppercase {
	public static void main(String[] args) {
		List<String> employees = Arrays.asList(
                "Rahul",
                "Priya",
                "Amit",
                "Sneha",
                "Vikas"
        );

        List<String> upperNames = employees.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println("Uppercase Employee Names:");
        upperNames.forEach(System.out::println);
	}
}
