// package java8_features_practice.LambdaExpressions;

import java.util.*;
import java.util.function.Predicate;

public class NotificationFiltering {

    static class Alert {
        String type;
        String message;

        Alert(String type, String message) {
            this.type = type;
            this.message = message;
        }

        public String toString() {
            return "[" + type + "] " + message;
        }
    }

    public static void filterAlerts(List<Alert> alerts, Predicate<Alert> condition) {
        for (Alert a : alerts) {
            if (condition.test(a)) {
                System.out.println(a);
            }
        }
        System.out.println("--------------");
    }

    public static void main(String[] args) {

        List<Alert> alerts = new ArrayList<>();

        alerts.add(new Alert("Emergency", "Heart rate critical!"));
        alerts.add(new Alert("Appointment", "Doctor visit at 5 PM"));
        alerts.add(new Alert("Medicine", "Take BP tablet"));
        alerts.add(new Alert("HealthTip", "Drink more water"));
        alerts.add(new Alert("Emergency", "Oxygen level low!"));

        System.out.println("Emergency Alerts:");
        filterAlerts(alerts, a -> a.type.equals("Emergency"));

        System.out.println("Reminder Alerts:");
        filterAlerts(alerts,
                a -> a.type.equals("Appointment") || a.type.equals("Medicine"));

        System.out.println("All Alerts:");
        filterAlerts(alerts, a -> true);
    }
}
