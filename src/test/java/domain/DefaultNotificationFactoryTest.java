package domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultNotificationFactoryTest {

	private DefaultNotificationFactory factory;
	
	@BeforeEach
	void setup() {
		factory = new DefaultNotificationFactory();
	}
	
	@Test
	void shouldCreateEmailNotification() {
		Notification notification = factory.create(NotificationType.EMAIL);
		assertTrue(notification instanceof EmailNotification);
	}
	
	@Test
	void shouldCreatePushNotification() {
		Notification notification = factory.create(NotificationType.PUSH);
		assertTrue(notification instanceof PushNotification);
	}

}
