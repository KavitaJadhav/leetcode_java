package patterns.stream_processing;

import java.util.HashMap;
import java.util.Map;

public class NotificationSystem {
    Map<String, NotificationType> notificationTypes;

    public NotificationSystem() {
        notificationTypes = new HashMap<>();
        notificationTypes.put("Email", new EmailSender());
        notificationTypes.put("SMS", new SMSSender());
        notificationTypes.put("Push", new PushSender());
    }

    public void send_notification(String user, String message, String type) {
        if (!notificationTypes.containsKey(type)) {
            System.out.println("Unsupported notification type");
            throw new IllegalArgumentException("Unsupported notification type");
//            500 error
//            for prod systems log error and return meaningful response like 422 error
        }

        notificationTypes.get(type).send(user, message);
    }

    public static void main(String[] args) {
        NotificationSystem notificationSystem = new NotificationSystem();
        notificationSystem.send_notification("user1", "Hello", "SMS");
        notificationSystem.send_notification("user2", "12345", "Email");
        notificationSystem.send_notification("user3", "welcome", "Push");
        notificationSystem.send_notification("user1", "Hello", "Text");
    }

    public interface NotificationType {
        public void send(String user, String message);
    }

    public class EmailSender implements NotificationType {
        @Override
        public void send(String user, String message) {
            System.out.println("Email notification to " + user + " with " + message);
        }
    }

    public class SMSSender implements NotificationType {
        @Override
        public void send(String user, String message) {
            System.out.println("SMS notification to " + user + " with " + message);
        }
    }

    public class PushSender implements NotificationType {
        @Override
        public void send(String user, String message) {
            System.out.println("Push notification to " + user + " with " + message);
        }
    }
}