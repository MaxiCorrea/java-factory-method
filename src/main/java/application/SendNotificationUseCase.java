package application;

import domain.Notification;
import domain.NotificationFactory;
import domain.NotificationType;

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
