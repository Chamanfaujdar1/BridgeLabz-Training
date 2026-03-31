package com.example.JUnit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {
	public String formatDate(String inputDate) {
        if (inputDate == null || inputDate.isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(inputDate, inputFormat);
        return date.format(outputFormat);
    }
}
