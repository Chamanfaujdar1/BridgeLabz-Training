import java.util.Scanner;

public class StudentVoteChecker {

    public boolean canStudentVote(int age) {

        if (age < 0) {
            return false;
        }

        if (age >= 18) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentVoteChecker checker = new StudentVoteChecker();

        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();

            boolean canVote = checker.canStudentVote(ages[i]);

            if (canVote) {
                System.out.println("Student " + (i + 1) + " is eligible to vote.");
            } else {
                System.out.println("Student " + (i + 1) + " is NOT eligible to vote.");
            }
        }

        sc.close();
    }
}
