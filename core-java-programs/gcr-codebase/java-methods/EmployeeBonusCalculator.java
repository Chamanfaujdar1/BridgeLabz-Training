public class EmployeeBonusCalculator {

    public static double[][] generateEmployeeData(int employees) {
        double[][] data = new double[employees][2];

        for (int i = 0; i < employees; i++) {
            
            data[i][0] = (int) (Math.random() * 90000) + 10000;

            data[i][1] = (int) (Math.random() * 10) + 1;
        }
        return data;
    }

    public static double[][] calculateBonus(double[][] employeeData) {

        double[][] result = new double[employeeData.length][4];

        for (int i = 0; i < employeeData.length; i++) {
            double salary = employeeData[i][0];
            int years = (int) employeeData[i][1];

            double bonusRate = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusRate;
            double newSalary = salary + bonus;

            result[i][0] = salary;
            result[i][1] = years;
            result[i][2] = bonus;
            result[i][3] = newSalary;
        }
        return result;
    }

    public static void displaySummary(double[][] data) {

        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;

        System.out.println("------------------------------------------------------");
        System.out.println("Emp | Old Salary | Years | Bonus Amount | New Salary");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            totalOldSalary += data[i][0];
            totalBonus += data[i][2];
            totalNewSalary += data[i][3];

            System.out.printf("%3d | %10.2f | %5d | %12.2f | %10.2f%n",
                    (i + 1),
                    data[i][0],
                    (int) data[i][1],
                    data[i][2],
                    data[i][3]);
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("TOTAL | %10.2f |       | %12.2f | %10.2f%n",
                totalOldSalary, totalBonus, totalNewSalary);
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {

        int employees = 10;

        double[][] employeeData = generateEmployeeData(employees);
        double[][] finalData = calculateBonus(employeeData);

        displaySummary(finalData);
    }
}
