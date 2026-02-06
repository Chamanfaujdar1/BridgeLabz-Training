public class SmartVehicleDashboard {

    interface VehicleDashboard {

        void displaySpeed(int speed);

        default void displayBatteryPercentage(int percentage) {
            System.out.println("Battery information not available");
        }
    }

    static class PetrolCar implements VehicleDashboard {

        public void displaySpeed(int speed) {
            System.out.println("Petrol Car Speed: " + speed + " km/h");
        }
    }

    static class ElectricCar implements VehicleDashboard {

        public void displaySpeed(int speed) {
            System.out.println("Electric Car Speed: " + speed + " km/h");
        }

        public void displayBatteryPercentage(int percentage) {
            System.out.println("Battery Level: " + percentage + "%");
        }
    }

    public static void main(String[] args) {

        VehicleDashboard petrolCar = new PetrolCar();
        VehicleDashboard electricCar = new ElectricCar();

        petrolCar.displaySpeed(80);
        petrolCar.displayBatteryPercentage(0);

        electricCar.displaySpeed(100);
        electricCar.displayBatteryPercentage(75);
    }
}
