import java.awt.geom.Point2D;

public interface Movable extends Locateable{
    public void move();
    public void turnLeft();
    public void turnRight();
    public double getDirection();
}
