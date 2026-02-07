import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeSalaryCategorization {
    public static void main(String[] args){
        List<Employee> employees = List.of(
            new Employee("Aman", "IT", 60000),
            new Employee("Riya", "HR", 45000),
            new Employee("Karan", "IT", 70000),
            new Employee("Sneha", "HR", 55000),
            new Employee("Rahul", "Finance", 50000)
        );

        Map<String, Double> avgSalaryByDept =
            employees.stream()
            .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.averagingDouble(Employee::getSalary)
        ));

        System.out.println(avgSalaryByDept);
    }
}
