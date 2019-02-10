import java.awt.geom.Point2D;

public interface Movable {
    public void move();
    public void turnLeft();
    public void turnRight();
    public Point2D.Double getPosition();
    public double getDirection();
}
