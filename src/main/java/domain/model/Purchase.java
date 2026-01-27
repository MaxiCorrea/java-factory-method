package domain.model;

public class Purchase {

	private final Client client;
	
	public Purchase(
			final Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
	
}
