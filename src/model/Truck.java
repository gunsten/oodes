package model;

import java.awt.*;

public abstract class Truck extends Car {

    private int platformangle;


    /**
     * Creates a truck object
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     */
    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        platformangle = getPlatformClosedAngle();
    }

    public void raisePlatform() {
        if (getCurrentSpeed() != 0)
            throw new PlatformException("Cannot raise dumper when the car is moving");
        platformangle = Math.min(getPlatformMaxAngle(), platformangle + getPlatformAngleChange());
    }

    public void lowerPlatform() {
        platformangle = Math.max(getPlatformMinAngle(), platformangle - getPlatformAngleChange());
    }

    public int getPlatformAngle() {
        return platformangle;
    }

    public abstract int getPlatformAngleChange();

    public abstract int getPlatformMaxAngle();

    public abstract int getPlatformMinAngle();

    public abstract int getPlatformClosedAngle();

    /**
     * Accelerates the car. Takes arguments in the range [0,1]
     * @param amount
     * @throws IllegalArgumentException if the argument is outside of the allowed range
     */
    public void gas(double amount) {
        if(platformangle != getPlatformClosedAngle())
            throw new PlatformException("Cannot increase speed if the dumper is not at its closed position");
        super.gas(amount);
    }
}
