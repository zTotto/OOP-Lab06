package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1360963128096934064L;
	private final double battery;

	public NotEnoughBatteryException(final double battery) {
		super();
		this.battery = battery;
	}

	public String toString() {
		return "Can not move, " + this.battery + "% battery is not enough";
	}

	public String getMessage() {
		return this.toString();
	}
}
