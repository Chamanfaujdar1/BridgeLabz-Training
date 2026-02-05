public class FlightUtil {

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (flightNumber == null || !flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (!(flightName.equalsIgnoreCase("SpiceJet")
                || flightName.equalsIgnoreCase("Vistara")
                || flightName.equalsIgnoreCase("IndiGo")
                || flightName.equalsIgnoreCase("Air Arabia"))) {

            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName)
            throws InvalidFlightException {

        int maxCapacity = getMaxPassengerCapacity(flightName);

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException(
                    "The passenger count " + passengerCount + " is invalid for " + flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
            throws InvalidFlightException {

        double maxFuelCapacity = getFuelCapacity(flightName);

        if (currentFuelLevel < 0 || currentFuelLevel > maxFuelCapacity) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }

        return maxFuelCapacity - currentFuelLevel;
    }

    private int getMaxPassengerCapacity(String flightName) {
        switch (flightName) {
            case "SpiceJet":
                return 396;
            case "Vistara":
                return 615;
            case "IndiGo":
                return 230;
            case "Air Arabia":
                return 130;
            default:
                return 0;
        }
    }

    private double getFuelCapacity(String flightName) {
        switch (flightName) {
            case "SpiceJet":
                return 200000;
            case "Vistara":
                return 300000;
            case "IndiGo":
                return 250000;
            case "Air Arabia":
                return 150000;
            default:
                return 0;
        }
    }
}
