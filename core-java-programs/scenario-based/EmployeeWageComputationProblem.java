public class EmployeeWageComputationProblem {
    // Class-level Constants (UC 2, 3, 5, 6)
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int EMP_RATE_PER_HOUR = 20;
    public static final int NUM_OF_WORKING_DAYS = 20;
    public static final int MAX_HRS_IN_MONTH = 100;

    public static void main(String[] args) {
        // UC 1: Start with a Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Variables for tracking monthly totals (UC 6)
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        // UC 6: Calculate wages till a condition of total working hours or days is reached
        while (totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
            totalWorkingDays++;
            int empHrs = 0;

            // UC 1 & 4: Use Random for attendance and Switch Case for logic
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            
            switch (empCheck) {
                case IS_FULL_TIME:
                    empHrs = 8; // UC 2: Full day hours
                    break;
                case IS_PART_TIME:
                    empHrs = 8; // UC 3: Part time hours
                    break;
                default:
                    empHrs = 0; // Absent
            }

            totalEmpHrs += empHrs;
            System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHrs);
        }

        // UC 2: Final calculation of Monthly Wage
        int totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
        System.out.println("Total Emp Wage: " + totalEmpWage);
    }
}