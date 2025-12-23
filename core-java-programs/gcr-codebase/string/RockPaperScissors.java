import java.util.Scanner;

public class RockPaperScissors {
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); // 0: Rock, 1: Paper, 2: Scissors
        if (choice == 0) return "Rock";
        if (choice == 1) return "Paper";
        return "Scissors";
    }

    public static String findWinner(String user, String computer) {
        if (user.equalsIgnoreCase(computer)) return "Draw";

        if ((user.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
            (user.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
            (user.equalsIgnoreCase("Scissors") && computer.equals("Paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    public static String[][] calculateStats(int userWins, int compWins, int totalGames) {
        String[][] stats = new String[2][3];
        
        double userAvg = (double) userWins / totalGames;
        double compAvg = (double) compWins / totalGames;
        
        stats[0][0] = "User";
        stats[0][1] = String.format("%.2f", userAvg);
        stats[0][2] = String.format("%.2f%%", userAvg * 100);

        stats[1][0] = "Computer";
        stats[1][1] = String.format("%.2f", compAvg);
        stats[1][2] = String.format("%.2f%%", compAvg * 100);

        return stats;
    }

    public static void displayResults(String[][] gameHistory, String[][] stats) {
        System.out.println("\n--- Game History ---");
        System.out.printf("%-10s | %-12s | %-12s | %-10s\n", "Game #", "User", "Computer", "Winner");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < gameHistory.length; i++) {
            System.out.printf("%-10s | %-12s | %-12s | %-10s\n", 
                (i + 1), gameHistory[i][0], gameHistory[i][1], gameHistory[i][2]);
        }

        System.out.println("\n--- Final Statistics ---");
        System.out.printf("%-12s | %-10s | %-10s\n", "Entity", "Average", "Win %");
        System.out.println("-------------------------------------------");
        for (String[] row : stats) {
            System.out.printf("%-12s | %-10s | %-10s\n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int totalGames = sc.nextInt();
        sc.nextLine(); 

        String[][] gameHistory = new String[totalGames][3];
        int userWins = 0, compWins = 0;

        for (int i = 0; i < totalGames; i++) {
            System.out.print("\nGame " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            String userChoice = sc.nextLine();
            String compChoice = getComputerChoice();
            String winner = findWinner(userChoice, compChoice);

            gameHistory[i][0] = userChoice;
            gameHistory[i][1] = compChoice;
            gameHistory[i][2] = winner;

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;
        }

        String[][] stats = calculateStats(userWins, compWins, totalGames);
        displayResults(gameHistory, stats);
        
        sc.close();
    }
}
