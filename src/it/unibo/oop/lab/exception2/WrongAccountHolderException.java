package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException {

	private static final long serialVersionUID = 7190620326792084901L;
	private final int userID;

	
	WrongAccountHolderException(final int userID) {
		this.userID = userID;
	}
	
	 @Override
	public String toString() {
	    return "The " + this.userID + " is an unauthorized account";
	}

	@Override
	public String getMessage() {
		return this.toString();
	}

}
