// Base Class: The foundation for any person in the school
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayBasicInfo() {
        System.out.println("Name: " + name + " | Age: " + age);
    }
}

// Subclass 1: Teacher
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher | Specialization: " + subject);
    }
}

// Subclass 2: Student
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student | Grade: " + grade);
    }
}

// Subclass 3: Staff
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff | Department: " + department);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher prof = new Teacher("Mr. Sharma", 45, "Mathematics");
        Student stud = new Student("Ananya", 16, "11th Grade");
        Staff admin = new Staff("Rajesh", 38, "Administration");

        System.out.println("--- School Directory ---");
        
        prof.displayBasicInfo();
        prof.displayRole();
        System.out.println();

        stud.displayBasicInfo();
        stud.displayRole();
        System.out.println();

        admin.displayBasicInfo();
        admin.displayRole();
    }
}
