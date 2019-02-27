package model;

import java.awt.*;

/**
 * A car of the model.Volvo240 model
 */
public class Saab95 extends PrivateCar{

    private boolean turboOn;

    /**
     * Creates a model.Saab95 object
     */
    public Saab95(){
        super(2, 125, Color.red, "model.Saab95");
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
     * @return the calculated speed factor of the model.Saab95
     */
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
