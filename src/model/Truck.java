package model;

import model.stateplatform.IStatePlatform;
import model.stateplatform.PlatformClosed;
import model.stateplatform.PlatformOpen;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Truck extends Car {

    private int platformangle;
    private IStatePlatform state;


    /**
     * Creates a truck object
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     */
    public Truck(int nrDoors, double enginePower, Color color, String modelName, Point2D.Double position, double direction, double width, double height) {
        super(nrDoors, enginePower, color, modelName, position, direction, width, height);
        platformangle = getPlatformClosedAngle();
        this.state = PlatformClosed.getPlatformColsed();

    }

    /**
     * @return sCars state
     */
    /*public IStatePlatform getState(){
        return state;
    }

    public void setState(){
        this.state=state;
    }*/

    public void raisePlatform() {
        if (getCurrentSpeed() != 0)
            throw new PlatformException("Cannot raise dumper when the car is moving");
        platformangle = Math.min(getPlatformMaxAngle(), platformangle + getPlatformAngleChange());
        setPlatformState();
    }
    private void setPlatformState(){
        if(platformangle==getPlatformClosedAngle()){
            state=PlatformClosed.getPlatformColsed();
        }else {
            state= PlatformOpen.getPlatformOpen();
        }
    }

    public void lowerPlatform() {
        platformangle = Math.max(getPlatformMinAngle(), platformangle - getPlatformAngleChange());
        setPlatformState();
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

        super.gas(amount*state.gas());
    }
}
