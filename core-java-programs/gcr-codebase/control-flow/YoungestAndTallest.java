import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();
        int amarHeight = sc.nextInt();
        int akbarHeight = sc.nextInt();
        int anthonyHeight = sc.nextInt();

        if(amarAge <= akbarAge && amarAge <= anthonyAge){
            System.out.println("Youngest: Amar");
        }
        else if(akbarAge <= amarAge && akbarAge <= anthonyAge){
            System.out.println("Youngest: Akbar");
        }
        else{
            System.out.println("Youngest: Anthony");
        }

        if(amarHeight >= akbarHeight && amarHeight >= anthonyHeight){
            System.out.println("Tallest: Amar");
        }
        else if(akbarHeight >= amarHeight && akbarHeight >= anthonyHeight){
            System.out.println("Tallest: Akbar");
        }
        else{
            System.out.println("Tallest: Anthony");
        }
    }
}
