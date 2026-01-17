package application;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import domain.Notification;
import infrastructure.NotificationFactory;
import infrastructure.NotificationType;

class SendNotificationUseCaseTest {

	@Mock
	private NotificationFactory factory;
	
	@Mock
	private Notification notification;
	
	private SendNotificationUseCase usecase;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		usecase = new SendNotificationUseCase(factory);
	}
	
	@Test
	void shouldCreateNotificationAndSendMessage() {
		// given
		NotificationType type = NotificationType.EMAIL;
		String message = "Hello Youtube";
		
		// when
		when(factory.create(type)).thenReturn(notification);
		usecase.execute(type, message);
		
		// then
		verify(factory).create(type);
		verify(notification).send(message);
		verifyNoMoreInteractions(factory, notification);
	}

}
