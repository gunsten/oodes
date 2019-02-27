package model;

import java.awt.geom.Point2D;

/**
 * Anything that has a position
 */
public interface Locateable {
    /**
     * Returns the position of a Locatable object
     * @return
     */
    Point2D.Double getPosition();

    /**
     * Returns the distance between two Locatable objects
     * @param obj1
     * @param obj2
     * @return
     */
    static double distance (Locateable obj1, Locateable obj2) {
        double xdist = obj1.getPosition().x - obj2.getPosition().x;
        double ydist = obj1.getPosition().y - obj2.getPosition().y;
        return Math.sqrt(xdist*xdist + ydist*ydist);
    }
}
