package methodref;

class NotificationService {
    static void sendEmail(String msg) {
        System.out.println("Email: " + msg);
    }

    void sendSMS(String msg) {
        System.out.println("SMS: " + msg);
    }
}

public class NotificationDemo {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Runnable email = () -> NotificationService.sendEmail("Hello");
        Runnable sms = () -> service.sendSMS("Hi");

        email.run();
        sms.run();
    }
}