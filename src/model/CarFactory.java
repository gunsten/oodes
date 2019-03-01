package model;

import java.awt.geom.Point2D;

public class CarFactory {
    public static Saab95 createSaab95(Point2D.Double position, double direction, double width, double height) {
        return new Saab95(position, direction, width, height);
    }

    public static Volvo240 createVolvo240(Point2D.Double position, double direction, double width, double height) {
        return new Volvo240(position, direction, width, height);
    }

    public static Scania createScania(Point2D.Double position, double direction, double width, double height) {
        return new Scania(position, direction, width, height);
    }

    public static Transport createTransport(Point2D.Double position, double direction, double width, double height, int max_capacity) {
        return new Transport(position, direction, width, height, max_capacity);
    }
}
