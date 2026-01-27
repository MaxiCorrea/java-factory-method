package domain.model;

public class AuthorizationResult {

	private final AuthorizationStatus status;
	
	public AuthorizationResult(
			final AuthorizationStatus status) {
		this.status = status;
	}
	
	public static AuthorizationResult approved() {
		return new AuthorizationResult(AuthorizationStatus.APPROVED);
	}
	
	public static AuthorizationResult approvedWithValidation() {
		return new AuthorizationResult(AuthorizationStatus.APPROVED_WITH_VALIDATION);
	}
	
	public static AuthorizationResult manualReviewRequired() {
		return new AuthorizationResult(AuthorizationStatus.MANUAL_REVIEW_REQUIRED);
	}
	
	public AuthorizationStatus getStatus() {
		return status;
	}
	
}
