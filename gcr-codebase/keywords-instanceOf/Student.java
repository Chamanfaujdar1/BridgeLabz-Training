public class Student {
    static String universityName = "Global University";
    static int totalStudents = 0;

    String name;
    final int rollNumber;
    String grade;

    Student(int rollNumber, String name, String grade){
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;

        totalStudents++;
    }

    static void displayTotalStudents(){
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    void displayDetails(){
        System.out.println("University Name: " + universityName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args){
        Student student1 = new Student(101, "Hemashree", "A");
        Student student2 = new Student(102, "Sharmila", "B");

        Student.displayTotalStudents();

        if(student1 instanceof Student){
            student1.displayDetails();
        }

        if(student2 instanceof Student){
            student2.displayDetails();
        }
    }
}
