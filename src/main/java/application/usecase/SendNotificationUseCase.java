package application.usecase;

import application.port.NotificationFactory;
import application.port.NotificationType;
import domain.Notification;

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
