import java.util.function.Predicate;

public class TemperatureAlertSystem {
    public static void main(String[] args){
        Predicate<Double> temperature = temp -> temp > 37.5;

        double currentTemp = 39.2;
        if(temperature.test(currentTemp)){
            System.out.println("Alert: High temperature detected: " + currentTemp + "°C");
        }
        else{
            System.out.println("Temperature is normal: " + currentTemp + "°C");
        }
    }
}
