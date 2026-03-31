public class DigitalWatchSimulation {

    public static void main(String[] args) {

        System.out.println("Digital Watch Started\n");

        for (int hour = 0; hour < 24; hour++) {

            for (int minute = 0; minute < 60; minute++) {
                if (hour == 13 && minute == 0) {
                    System.out.println("\n Power Cut! Watch stopped at 13:00");
                    return;
                }

                System.out.printf("%02d:%02d\n", hour, minute);
            }
        }

        System.out.println(" Watch completed full 24 hours");
    }
}
