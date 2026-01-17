package infrastructure;

import domain.Notification;

public interface NotificationFactory {

	Notification create(NotificationType type);

}
