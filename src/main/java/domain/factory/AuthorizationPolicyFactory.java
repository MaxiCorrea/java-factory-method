package domain.factory;

import domain.model.Client;
import domain.policy.AuthorizationPolicy;
import domain.policy.RiskAuthorizationPolicy;
import domain.policy.StandardAuthorizationPolicy;
import domain.policy.VipAuthorizationPolicy;

public class AuthorizationPolicyFactory {

	public AuthorizationPolicy forClient(
			final Client client) {
		if(client.isVip()) 
			return new VipAuthorizationPolicy();
		if(client.isHighRisk()) 
			return new RiskAuthorizationPolicy();
		return new StandardAuthorizationPolicy();
	}
	
}
