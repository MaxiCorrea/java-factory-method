package application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.factory.AuthorizationPolicyFactory;
import domain.model.AuthorizationResult;
import domain.model.AuthorizationStatus;
import domain.model.Client;
import domain.model.Purchase;

class AuthorizationPurchaseUseCaseTest {

	private AuthorizationPolicyFactory factory;
	private AuthorizationPurchaseUseCase usecase;
	
	@BeforeEach
	void setup() {
		factory = new AuthorizationPolicyFactory();
		usecase = new AuthorizationPurchaseUseCase(factory);
	}
	
	@Test
	void shouldVipPurchaseApproved() {
		Client client = new Client(true, false);
		Purchase purchase = new Purchase(client);
		AuthorizationResult result = usecase.execute(purchase);
		assertEquals(AuthorizationStatus.APPROVED, result.getStatus());
	}

	@Test
	void shouldRiskPurchaseRequiresManualReview() {
		Client client = new Client(false, true);
		Purchase purchase = new Purchase(client);
		AuthorizationResult result = usecase.execute(purchase);
		assertEquals(AuthorizationStatus.MANUAL_REVIEW_REQUIRED, result.getStatus());
	}
	
	@Test
	void shouldStandarPurchaseIsApprovedWithValidation() {
		Client client = new Client(false, false);
		Purchase purchase = new Purchase(client);
		AuthorizationResult result = usecase.execute(purchase);
		assertEquals(AuthorizationStatus.APPROVED_WITH_VALIDATION, result.getStatus());
	}
	
	
}
