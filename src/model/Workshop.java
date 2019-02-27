package model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> implements Loadable<T>{
    private static final double LOADDISTANCE = 1;
    private Point2D.Double position;
    List<T> cars;

    public Workshop() {
        position = new Point2D.Double(0,0);
        cars = new ArrayList<>();
    }
    @Override
    public void loadCar(T car) {
        if (Locateable.distance(car, this) > LOADDISTANCE)
            throw new LoadException("The car is too far away");
        car.load(this);
        cars.add(car);
    }

    @Override
    public Point2D.Double getPosition() {
        return position;
    }

    @Override
    public T unloadCar() {
        if (cars.size() == 0)
            throw new LoadException("The workshop is empty");
        T car = cars.remove(cars.size()-1);
        car.unload();
        return car;
    }
}
