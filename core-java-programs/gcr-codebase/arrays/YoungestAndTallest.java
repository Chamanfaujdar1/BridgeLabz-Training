import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        for(int i=0; i<names.length; i++){
            System.out.println("Enter the age of " + names[i] + ":");
            ages[i] = sc.nextInt();
            System.out.println("Enter the height of " + names[i] + " in cm:");
            heights[i] = sc.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;
        for(int i=1; i<names.length; i++){
            if(ages[i] < ages[youngestIndex]){
                youngestIndex = i;
            }
            if(heights[i] > heights[tallestIndex]){
                tallestIndex = i;
            }
        }

        System.out.println("-----RESULT-----");
        System.out.println("Youngest Person: " + names[youngestIndex] + ", Age: " + ages[youngestIndex]);
        System.out.println("Tallest Person: " + names[tallestIndex] + ", Height: " + heights[tallestIndex] + " cm");
    }
}
