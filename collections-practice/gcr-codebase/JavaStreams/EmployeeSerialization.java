import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {

    static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;

        int id;
        String name;
        String department;
        double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee {" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    private static final String FILE_NAME = "employees.dat";

    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully into " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error while saving employees: " + e.getMessage());
        }
    }

    public static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees loaded successfully from " + FILE_NAME);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error while loading employees: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found while deserializing: " + e.getMessage());
        }

        return employees;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Amit", "IT", 55000));
        employees.add(new Employee(102, "Neha", "HR", 48000));
        employees.add(new Employee(103, "Rahul", "Finance", 60000));

        saveEmployees(employees);

        System.out.println("\n Employees from File:");
        System.out.println("-------");

        List<Employee> loadedEmployees = loadEmployees();
        for (Employee emp : loadedEmployees) {
            System.out.println(emp);
        }
    }
}
