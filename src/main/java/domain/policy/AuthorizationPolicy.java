package domain.policy;

import domain.model.AuthorizationResult;
import domain.model.Purchase;

public interface AuthorizationPolicy {

	AuthorizationResult authorize(Purchase purchase);
	
}
