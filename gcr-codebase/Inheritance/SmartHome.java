class Device {
    String deviceId;
    boolean isOn;

    Device(String deviceId, boolean isOn) {
        this.deviceId = deviceId;
        this.isOn = isOn;
    }

    void displayStatus() {
        String status = isOn ? "ON" : "OFF";
        System.out.println("Device ID: " + deviceId + " | Status: " + status);
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String deviceId, boolean isOn, double temperatureSetting) {
        super(deviceId, isOn);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        System.out.println("------------------------------------");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Thermostat livingRoomTstat = new Thermostat("T-1001", true, 22.5);
        Thermostat bedroomTstat = new Thermostat("T-1002", false, 18.0);

        System.out.println("=== Smart Home Device Dashboard ===");
        livingRoomTstat.displayStatus();
        bedroomTstat.displayStatus();
    }
}
