public class MaximumOfThree {
    public static int input(Scanner sc, String message){
        System.out.print(message);
        return sc.nextInt();
    }

    public static int maximumFinder(int a, int b, int c){
        int max = a;
        if(b > max){
            max = b;
        }
        if(c > max){
            max = c;
        }
        return max;
    }
    public static void main(String[] args){
        
        int num1 = input(sc, "Enter first number: ");
        int num2 = input(sc, "Enter second number: ");
        int num3 = input(sc, "Enter three number: ");

        int maximum = maximumFinder(num1, num2, num3);
        System.out.println("The maximum of three numbers is: " + maximum);


    }
}
