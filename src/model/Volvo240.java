package model;

import java.awt.*;

/**
 * A car of the model.Volvo240 model
 */
public class Volvo240 extends PrivateCar{

    /**
     * The trim factor of the model.Volvo240, effecting the speed change of the car
     */
    public final static double trimFactor = 1.25;

    /**
     * Creates a model.Volvo240 object
     */
    public Volvo240(){
        super(4, 100, Color.black, "model.Volvo240");
    }

    /**
     * @return the calculated speed factor of the model.Volvo240
     */
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
