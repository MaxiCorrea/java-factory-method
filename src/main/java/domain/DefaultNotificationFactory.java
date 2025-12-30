package domain;

import java.util.EnumMap;
import java.util.function.Supplier;

public class DefaultNotificationFactory implements NotificationFactory {

	private final EnumMap<NotificationType, Supplier<Notification>> creators;
	
	public DefaultNotificationFactory() {
		creators = new EnumMap<>(NotificationType.class);
		creators.put(NotificationType.EMAIL, EmailNotification::new);
		creators.put(NotificationType.PUSH, PushNotification::new);
	}
	
	@Override
	public Notification create(
			final NotificationType type) {
		Supplier<Notification> supplier = creators.get(type);
		if(supplier == null)
			throw new RuntimeException("Invalid Notification Type: " + type);
		return supplier.get();
	}

}
