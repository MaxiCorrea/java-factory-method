package domain.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import domain.model.Client;
import domain.policy.AuthorizationPolicy;
import domain.policy.RiskAuthorizationPolicy;
import domain.policy.StandardAuthorizationPolicy;
import domain.policy.VipAuthorizationPolicy;

class AuthorizationPolicyFactoryTest {

	@Test
	void shouldVipClientGetsVipPolicy() {
		Client client = new Client(true, false);
		AuthorizationPolicyFactory factory = new AuthorizationPolicyFactory();
		AuthorizationPolicy policy = factory.forClient(client);
		assertTrue(policy instanceof VipAuthorizationPolicy);
	}
	
	@Test
	void shouldHighRiskClientGetsRiskPolicy() {
		Client client = new Client(false, true);
		AuthorizationPolicyFactory factory = new AuthorizationPolicyFactory();
		AuthorizationPolicy policy = factory.forClient(client);
		assertTrue(policy instanceof RiskAuthorizationPolicy);
	}
	
	@Test
	void shouldStandarfClientGetsStardardPolicy() {
		Client client = new Client(false, false);
		AuthorizationPolicyFactory factory = new AuthorizationPolicyFactory();
		AuthorizationPolicy policy = factory.forClient(client);
		assertTrue(policy instanceof StandardAuthorizationPolicy);
	}

}
