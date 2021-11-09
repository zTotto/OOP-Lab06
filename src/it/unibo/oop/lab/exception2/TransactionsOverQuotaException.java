package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 380919217883973559L;

	public String toString() {
		return "No more transactions left";
	}

	public String getMessage() {
		return this.toString();
	}
}
