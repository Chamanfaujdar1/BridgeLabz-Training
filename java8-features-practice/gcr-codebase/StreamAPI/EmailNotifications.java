import java.util.List;

public class EmailNotifications {
    public static void main(String[] args){
        List<String> emails = List.of(
            "rahul@gmail.com",
            "amit@yahoo.com",
            "neha@hotmail.com",
            "priya@outlook.com"
        );

        emails.forEach(email -> sendEmailNotification(email));
    }

    private static void sendEmailNotification(String email) {
        System.out.println("Sending notification email to: " + email);
    }
}
