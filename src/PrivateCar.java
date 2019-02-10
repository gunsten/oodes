import java.awt.*;

public abstract class PrivateCar extends Car {
    /**
     * Creates a small car object
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     */
    public PrivateCar(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }
}
