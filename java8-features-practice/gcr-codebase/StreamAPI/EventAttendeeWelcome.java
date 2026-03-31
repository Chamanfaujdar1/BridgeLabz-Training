import java.util.*;
import java.util.List;
public class EventAttendeeWelcome {
    public static void main(String[] args){
        List<String> attendees = List.of(
            "Rahul",
            "Amit",
            "Neha",
            "Priya",
            "Suresh"
        );

        System.out.println("Welcome Messages:");
        attendees.stream()
                 .forEach(name ->
                     System.out.println("Welcome to the event, " + name + "!")
                 );
    }
}
