public class BusDistanceRouteTracker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double totalDistance = 0.0;

        while(true){
            System.out.print("Enter distance covered (in km): ");
            double distance = sc.nextDouble();
            totalDistance += distance;

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nPassenger got off.");
        System.out.println("Total Distance Travelled: " + totalDistance + " km");
    }
}
