package mock_practice;

import java.util.*;

// Main class
public class NotificationSystem {

    // ===== Model =====
    static class Notification {
        String userId;
        String message;
        String type; // EMAIL, SMS, PUSH

        public Notification(String userId, String message, String type) {
            this.userId = userId;
            this.message = message;
            this.type = type;
        }
    }

    // ===== Interface =====
    interface NotificationSender {
        void send(String userId, String message);
    }

    // ===== Implementations =====
    static class EmailSender implements NotificationSender {
        public void send(String userId, String message) {
            System.out.println("EMAIL to " + userId + ": " + message);
        }
    }

    static class SmsSender implements NotificationSender {
        public void send(String userId, String message) {
            System.out.println("SMS to " + userId + ": " + message);
        }
    }

    static class PushSender implements NotificationSender {
        public void send(String userId, String message) {
            System.out.println("PUSH to " + userId + ": " + message);
        }
    }

    // ===== Service =====
    static class NotificationService {

        private Map<String, NotificationSender> senderMap = new HashMap<>();

        public NotificationService() {
            senderMap.put("EMAIL", new EmailSender());
            senderMap.put("SMS", new SmsSender());
            senderMap.put("PUSH", new PushSender());
        }

        public void sendNotification(Notification notification) {
            NotificationSender sender = senderMap.get(notification.type);

            if (sender == null) {
                System.out.println("Unsupported notification type: " + notification.type);
                return;
            }

            sender.send(notification.userId, notification.message);
        }
    }

    // ===== Main method =====
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.sendNotification(new Notification("user1", "Welcome to HSBC!", "EMAIL"));
        service.sendNotification(new Notification("user2", "Your OTP is 1234", "SMS"));
        service.sendNotification(new Notification("user3", "New login detected", "PUSH"));
        service.sendNotification(new Notification("user4", "Test message", "WHATSAPP")); // unsupported
    }
}