import java.util.*;

public class VoteEligibility {
    public static void main(String[] args) {
        int[] age = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ages of 10 individuals:");
        for(int i=0; i<age.length; i++){
            age[i] = sc.nextInt();
        }
        
        for(int i=0; i<age.length; i++){
            if(age[i] < 0){
                System.out.println("Invalid Age");
            }

            else if(age[i] >= 18){
                System.out.println("The student with the age " + age[i] + " can vote.");
            }
            else{
                System.out.println("The student with the age " + age[i] + " cannot vote.");
            }
        }
    }
}
