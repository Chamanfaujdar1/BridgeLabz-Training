class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    public void updateSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
            System.out.println("Salary updated successfully for ID: " + employeeID);
        } else {
            System.out.println("Error: Salary must be a positive value.");
        }
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(int employeeID, String department, double salary, double bonus) {
        super(employeeID, department, salary);
        this.bonus = bonus;
    }

    public void displayManagerDetails() {
        System.out.println("Manager ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Base Salary: $" + getSalary());
        System.out.println("Manager Bonus: $" + bonus);
        System.out.println("Total Compensation: $" + (getSalary() + bonus));
        System.out.println("-----------------------------------");
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Manager mgr = new Manager(5001, "Engineering", 95000.0, 15000.0);
        
        mgr.displayManagerDetails();
        mgr.updateSalary(105000.0);
        
        System.out.println("\nUpdated Manager Record:");
        mgr.displayManagerDetails();
    }
}