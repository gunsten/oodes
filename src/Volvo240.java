import java.awt.*;

/**
 * A car of the Volvo240 model
 */
public class Volvo240 extends Car{

    /**
     * The trim factor of the Volvo240, effecting the speed change of the car
     */
    public final static double trimFactor = 1.25;

    /**
     * Creates a Volvo240 object
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }

    /**
     * @return the calculated speed factor of this specific car model
     */
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
