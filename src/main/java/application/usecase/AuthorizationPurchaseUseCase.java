package application.usecase;

import domain.factory.AuthorizationPolicyFactory;
import domain.model.AuthorizationResult;
import domain.model.Client;
import domain.model.Purchase;
import domain.policy.AuthorizationPolicy;

public class AuthorizationPurchaseUseCase {

	private final AuthorizationPolicyFactory factory;
	
	public AuthorizationPurchaseUseCase(
			final AuthorizationPolicyFactory factory) {
		this.factory = factory;
	}
	
	public AuthorizationResult execute(
			final Purchase purchase) {
		Client client = purchase.getClient();
		AuthorizationPolicy policy = factory.forClient(client);
		return policy.authorize(purchase);
	}
	
}
