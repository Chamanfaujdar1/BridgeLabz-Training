import java.util.*;
public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int voteA = 0, voteB = 0, voteC = 0;

        while(true){
            System.out.print("Enter the age: ");
            int age = sc.nextInt();

            if(age == -1) break;

            if(age < 18){
                System.out.println("Not Eligible to vote");
                continue;
            }

            System.out.println("Eligible to vote.");
            System.out.println("Cast your vote:");
            System.out.println("1 - Candidate A");
            System.out.println("2 - Candidate B");
            System.out.println("3 - Candidate C");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    voteA++;
                    System.out.println("Vote recorded for Candidate A");
                    break;

                case 2:
                    voteB++;
                    System.out.println("Vote recorded for Candidate B");
                    break;

                case 3:
                    voteC++;
                    System.out.println("Vote recorded for Candidate C");
                    break;
            
                default:
                    System.out.println("Invalid vote.");
            }

        }

        System.out.println("Election Results: ");
        System.out.println("Candidate A Votes: " + voteA);
        System.out.println("Candidate B Votes: " + voteB);
        System.out.println("Candidate C Votes: " + voteC);
    }
    
}
