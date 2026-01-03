class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails(){
        System.out.println("Employee name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: " + salary);
    }
}

class Manager extends Employee{
    int teamSize;
    Manager(String name, int id, double salary, int teamSize){
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    void displayDetails(){
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee{
    String programmingLanguage;
    Developer(String name, int id, double salary, String programmingLanguage){
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    void displayDetails(){
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee{
    String university;
    Intern(String name, int id, double salary, String university){
        super(name, id, salary);
        this.university = university;
    }
    void displayDetails(){
        super.displayDetails();
        System.out.println("University: " + university);
    }
}

public class EmployeeTest{
    public static void main(String[] args){
        Employee [] employees = {
            new Manager("Aman", 100, 35000.0, 5),
            new Developer("Raman", 101, 40000.0, "Python"),
            new Intern("Kapil", 102, 15000.0, "GLA University")
        };

        for(Employee emp : employees){
            System.out.println("\nEmployee Details");
            emp.displayDetails();
        }
    }
}
