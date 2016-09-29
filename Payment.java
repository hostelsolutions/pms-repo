package pms_package;

public class Payment {
	private String firstName;
	private String lastName;
	private String middleInitial;
	private enum issuer {
		MASTERCARD,
		VISA,
		DISCOVER,
		AMEX
	}
	
	public void changeName(String first, String middle, String last) {
		firstName = first;
		middleInitial = middle;
		lastName = last;
	}
}
