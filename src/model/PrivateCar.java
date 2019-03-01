package model;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Super class of cars concidered as private cars
 */
public abstract class PrivateCar extends Car {
    /**
     * Creates a small car object
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     */
    public PrivateCar(int nrDoors, double enginePower, Color color, String modelName, Point2D.Double position, double direction, double width, double height) {
        super(nrDoors, enginePower, color, modelName, position, direction, width, height);
    }
}
