import java.util.List;

public class IoTSensorReadings {

    public static void main(String[] args) {

        double threshold = 50.0;

        List<Double> sensorReadings = List.of(
            45.2,
            52.8,
            49.5,
            60.1,
            55.0,
            42.3,
            70.6
        );

        System.out.println("Sensor Readings Above Threshold (" + threshold + "):");

        sensorReadings.stream()
            .filter(reading -> reading > threshold)
            .forEach(reading ->
                System.out.println("High Reading Detected: " + reading)
            );
    }
}
