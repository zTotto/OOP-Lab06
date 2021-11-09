package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7286169411703220340L;

	public String toString() {
		return "Wrong User ID";
	}

	public String getMessage() {
		return this.toString();
	}
}
