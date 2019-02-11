import java.awt.geom.Point2D;

public interface Loadable <T extends Car> extends Locateable{
    public void loadCar(T car);
    public Point2D.Double getPosition();
    public T unloadCar();
}
