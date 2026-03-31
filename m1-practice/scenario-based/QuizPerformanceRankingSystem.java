import java.util.*;

class Student{
    String name;
    String department;
    int quiz1, quiz2, quiz3;

    public Student(String name, String department, int quiz1, int quiz2, int quiz3){
        this.name = name;
        this.department = department;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
    }
}

public class QuizPerformanceRankingSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            if (parts[0].equals("Record")) {
                addRecord(parts);
            } 
            else if (parts[0].equals("Top")) {
                if (parts[1].startsWith("Q")) {
                    topQuiz(parts[1]);
                } else {
                    topDepartment(parts[1]);
                }
            }
        }
    }

    public static void addRecord(String[] parts){
        String name = parts[1];
        String dept = parts[2];
        int q1 = Integer.parseInt(parts[3]);
        int q2 = Integer.parseInt(parts[4]);
        int q3 = Integer.parseInt(parts[5]);

        Student s = new Student(name, dept, q1, q2, q3);
        records.add(s);

        System.out.println("Record Added: " + name);
    }

    public static void topDepartment(String dept){
        if (records.isEmpty()) {
            System.out.println("No Records Available");
            return;
        }

        int max = -1;
        boolean found = false;

        for (Student s : records) {
            if (s.department.equals(dept)) {
                found = true;
                max = Math.max(max, s.getTotal());
            }
        }

        if (!found) {
            System.out.println("Department Not Found");
            return;
        }

        for (Student s : records) {
            if (s.department.equals(dept) && s.getTotal() == max) {
                System.out.println(s.name + " " + s.getTotal());
            }
        }
    }

    public static void topQuiz(String quiz){
        if (records.isEmpty()) {
            System.out.println("No Records Available");
            return;
        }

        int max = -1;

        // Find max
        for (Student s : records) {
            if (quiz.equals("Q1")) {
                max = Math.max(max, s.quiz1);
            } else if (quiz.equals("Q2")) {
                max = Math.max(max, s.quiz2);
            } else if (quiz.equals("Q3")) {
                max = Math.max(max, s.quiz3);
            }
        }

        for (Student s : records) {
            if ((quiz.equals("Q1") && s.quiz1 == max) ||
                (quiz.equals("Q2") && s.quiz2 == max) ||
                (quiz.equals("Q3") && s.quiz3 == max)) {

                int score = (quiz.equals("Q1")) ? s.quiz1 :
                            (quiz.equals("Q2")) ? s.quiz2 : s.quiz3;

                System.out.println(s.name + " " + score);
            }
        }
    }
}
