package it.unibo.oop.lab.exception1;

/**
 * Represents an exception occurring when a robot finishes his battery
 * 
 */
public class NotEnoughBatteryExceptions extends IllegalStateException {
	
		private static final long serialVersionUID = 2803403893069325119L;
		private final double x;
	   
	    /**
	     * Construct new instance of the exception.
	     * 
	     * @param initX
	     *            level of battery that causes the exception
	     * 
	     */
	    public NotEnoughBatteryExceptions(final double initX) {
	        super();
	        this.x = initX;
	      
	    }

	    /**
	     * 
	     * @return the string representation of instances of this class
	     */
	    @Override
	    public String toString() {
	        return "Level of battery: " + this.x + " is not enough for the movement";
	    }

	    @Override
	    public String getMessage() {
	        return this.toString();
	    }

}
