// package java8_features_practice.LambdaExpressions;

import java.util.*;

public class PatientIDPrinting {
	public static void main(String[] args) {
		List<String> patientIDs = Arrays.asList(
                "P1001",
                "P1002",
                "P1003",
                "P1004",
                "P1005"
        );

        System.out.println("Printing Patient IDs:");

        patientIDs.forEach(System.out::println);
	}
}
