package application;

import domain.Notification;
import infrastructure.NotificationFactory;
import infrastructure.NotificationType;

public class SendNotificationUseCase {

	private final NotificationFactory factory;
	
	public SendNotificationUseCase(
			final NotificationFactory factory) {
		this.factory = factory;
	}
	
	public void execute(
			final NotificationType type,
			final String message) {
		Notification notification = factory.create(type);
		notification.send(message);
	}
	
}
