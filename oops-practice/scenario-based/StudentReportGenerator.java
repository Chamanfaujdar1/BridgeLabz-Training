import java.util.*;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    public Student(String name, String[] subjects, int[] marks)
            throws InvalidMarkException {

        if (subjects.length != marks.length) {
            throw new IllegalArgumentException(
                "Subjects and marks length mismatch"
            );
        }

        this.name = name;
        this.subjects = subjects;
        this.marks = marks;

        validateMarks();
    }

    private void validateMarks() throws InvalidMarkException {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException(
                    "Invalid mark found: " + mark +
                    " (Marks must be between 0 and 100)"
                );
            }
        }
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / (double) marks.length;
    }

    public String getGrade() {
        double avg = calculateAverage();

        if (avg >= 80) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 40) return "C";
        else return "Fail";
    }

    public void displayReport() {
        System.out.println("\n==============================");
        System.out.println("Student Name : " + name);
        System.out.println("------------------------------");

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-10s : %3d%n", subjects[i], marks[i]);
        }

        System.out.println("------------------------------");
        System.out.printf("Average     : %.2f%n", calculateAverage());
        System.out.println("Grade       : " + getGrade());
        System.out.println("==============================");
    }
}

public class StudentReportGenerator {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();

        String[] subjects = {"Math", "Science", "English"};

        try {
            students.add(new Student(
                "Ravi",
                subjects,
                new int[]{85, 78, 90}
            ));

            students.add(new Student(
                "Amit",
                subjects,
                new int[]{60, 55, 65}
            ));

            students.add(new Student(
                "InvalidStudent",
                subjects,
                new int[]{95, 120, 80}
            ));

        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (Student s : students) {
            s.displayReport();
        }
    }
}
