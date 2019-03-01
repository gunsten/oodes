package model;

import java.awt.geom.Point2D;

public class CarFactory {
    public static Saab95 createSaab95(Point2D.Double position, double direction, double width, double height) {
        return new Saab95(position, direction, width, height);
    }

    public static Saab95 createSaab95(Model model) {
        return createSaab95(new Point2D.Double(model.getInitX(), model.getInitY()), model.getInitDirection(), model.getInitWidth(), model.getInitHeight());
    }

    public static Volvo240 createVolvo240(Point2D.Double position, double direction, double width, double height) {
        return new Volvo240(position, direction, width, height);
    }

    public static Volvo240 createVolvo240(Model model) {
        return createVolvo240(new Point2D.Double(model.getInitX(), model.getInitY()), model.getInitDirection(), model.getInitWidth(), model.getInitHeight());
    }

    public static Scania createScania(Point2D.Double position, double direction, double width, double height) {
        return new Scania(position, direction, width, height);
    }

    public static Scania createScania(Model model) {
        return createScania(new Point2D.Double(model.getInitX(), model.getInitY()), model.getInitDirection(), model.getInitWidth(), model.getInitHeight());
    }

    public static Transport createTransport(Point2D.Double position, double direction, double width, double height, int max_capacity) {
        return new Transport(position, direction, width, height, max_capacity);
    }

    public static Transport createTransport(Model model, int max_capacity) {
        return createTransport(new Point2D.Double(model.getInitX(), model.getInitY()), model.getInitDirection(), model.getInitWidth(), model.getInitHeight(), max_capacity);
    }
}
