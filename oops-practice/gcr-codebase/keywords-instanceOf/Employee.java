public class Employee {
    static String companyName = "Tech Solutions Inc.";
    static int employeeCount = 0;

    final int id;
    String name;
    String designation;

    Employee(int id, String name, String designation){
        this.name = name;
        this.id = id;
        this.designation = designation;
        employeeCount++;
    }

    static void displaytotalEmployees(){
        System.out.println("Total Employees: " + employeeCount);
    }
    void displayDetails(){
        System.out.println("Company Name: " + companyName);
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
    }

    public static void main(String[] args){

        Employee employee1 = new Employee(101, "Thamarai", "software Engineer");
        Employee employee2 = new Employee(102, "Rohan", "Project Manager");
        Employee.displaytotalEmployees();

        if(employee1 instanceof Employee){
            employee1.displayDetails();
        }
        if(employee2 instanceof Employee){
            employee2.displayDetails();
        }
    }
}
