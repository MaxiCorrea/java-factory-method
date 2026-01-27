package domain.model;

public class Client {

	private final boolean isVip;
	private final boolean highRisk;
	
	public Client(
			final boolean isVip,
			final boolean highRisk) {
		this.isVip = isVip;
		this.highRisk = highRisk;
	}
	
	public boolean isVip() {
		return isVip;
	}
	
	public boolean isHighRisk() {
		return highRisk;
	}
	
}
