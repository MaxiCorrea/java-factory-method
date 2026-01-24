package application.port;

import domain.Notification;

public interface NotificationFactory {

	Notification create(NotificationType type);

}
