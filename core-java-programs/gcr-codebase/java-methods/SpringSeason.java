import java.util.Scanner;

public class SpringSeason {
    public static boolean seasonChecker(int month, int day){
        if(month >= 3 && month <= 6 && day >= 20 && day <= 20){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of month: ");
        int month = sc.nextInt();
        System.out.print("Enter the value of day: ");
        int day = sc.nextInt();

        boolean isSpringSeason = seasonChecker(month, day);
        System.out.println("is " + day + "th " + month + " a spring season: " + isSpringSeason);
    }
}
