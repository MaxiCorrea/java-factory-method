package domain.policy;

import domain.model.AuthorizationResult;
import domain.model.Purchase;

public class VipAuthorizationPolicy implements AuthorizationPolicy {

	@Override
	public AuthorizationResult authorize(
			final Purchase purchase) {
		return AuthorizationResult.approved();
	}

}
