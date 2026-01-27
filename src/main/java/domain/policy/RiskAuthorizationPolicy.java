package domain.policy;

import domain.model.AuthorizationResult;
import domain.model.Purchase;

public class RiskAuthorizationPolicy implements AuthorizationPolicy {

	@Override
	public AuthorizationResult authorize(
			final Purchase purchase) {
		return AuthorizationResult.manualReviewRequired();
	}

}
