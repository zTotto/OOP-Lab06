package it.unibo.oop.lab.exception2;

public class NotEnoughFundsException extends IllegalArgumentException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5677976080346109282L;

	public String toString() {
		return "Not enough funds";
	}

	public String getMessage() {
		return this.toString();
	}
}
