public class NormalFare implements FareCalculator {
    public double calculateFare(double km){
        return km*10;
    }
}