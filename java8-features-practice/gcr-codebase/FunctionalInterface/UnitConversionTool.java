public class UnitConversionTool {
    interface UnitConverter{
        static double kmToMiles(double km){
            return km * 0.621371;
        }

        static double kgToPounds(double kg){
            return kg * 2.20462;
        }
    }

    public static void main(String[] args){
        double distanceKm = 120.0;
        double weightKg = 75.0;
        double distanceMiles = UnitConverter.kmToMiles(distanceKm);
        double weightPounds = UnitConverter.kgToPounds(weightKg);

        System.out.println(distanceKm + " kilometers is equal to " + distanceMiles + " miles.");
        System.out.println(weightKg + " kilograms is equal to " + weightPounds + " pounds.");

    }
}
