import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FlightUtil flightUtil = new FlightUtil();

        try {
            System.out.println("Enter flight details");
            String input = scanner.nextLine();

            String[] details = input.split(":");

            String flightNumber = details[0];
            String flightName = details[1];
            int passengerCount = Integer.parseInt(details[2]);
            double currentFuelLevel = Double.parseDouble(details[3]);

            flightUtil.validateFlightNumber(flightNumber);
            flightUtil.validateFlightName(flightName);
            flightUtil.validatePassengerCount(passengerCount, flightName);

            double fuelRequired =
                    flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);

            System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input");
        } finally {
            scanner.close();
        }
    }
}
