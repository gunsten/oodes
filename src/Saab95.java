import java.awt.*;

/**
 * A car of the Volvo240 model
 */
public class Saab95 extends PrivateCar{

    private boolean turboOn;

    /**
     * Creates a Saab95 object
     */
    public Saab95(){
        super(2, 125, Color.red, "Saab95");
	    turboOn = false;
    }

    /**
     * Activates the turbo
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Deactivates the turbo
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * @return the calculated speed factor of this specific car model
     */
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
