package it.unibo.oop.lab.exception2;

public class TransactionOverQuotaException extends IllegalStateException {

	private static final long serialVersionUID = -183608271225525162L;

	@Override
	public String toString() {
		return "The count of ATM transactions is over the maximum allowed";
	}

	@Override
	public String getMessage() {
		return this.toString();
	}

}
