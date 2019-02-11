import java.awt.geom.Point2D;

public interface Locateable {
    public Point2D.Double getPosition();

    public static double distance (Locateable obj1, Locateable obj2) {
        double xdist = obj1.getPosition().x - obj2.getPosition().x;
        double ydist = obj1.getPosition().y - obj2.getPosition().y;
        return Math.sqrt(xdist*xdist + ydist*ydist);
    }
}
