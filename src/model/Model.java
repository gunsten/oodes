package model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model implements IModel, ReadableModel<Car> {
    private static final double START_X = 0, START_W = 100, START_H = 60;
    private static final double INIT_DIR = 0;
    private final List<Car> cars;
    private final double width;
    private final int max_cars;
    private Model(List<Car> cars, int max_cars, double width) {
        this.cars = cars;
        this.width = width;
        this.max_cars = max_cars;
    }

    public static Model createDefaultModel(int max_cars, double width) {
        Model def_model = new Model(new ArrayList<Car>(), max_cars, width);
        def_model.addVolvo240();
        def_model.addSaab95();
        def_model.addScania();
        return def_model;
    }
    
    @Override
    public void update() {
        for (Car car : cars) {
            car.move();
            if(car.getPosition().x < 0 || car.getPosition().x > width - car.getWidth()) {
                car.uTurn();
            }
        }
    }

    @Override
    public void gas(int amount) {
        for (Car car : cars) {
            car.gas(amount/100d);
        }
    }

    @Override
    public void brake(int amount) {
        for (Car car : cars) {
            car.brake(amount/100d);
        }
    }

    @Override
    public void startCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    @Override
    public void stopCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    @Override
    public void liftBeds() {
        for (Car car : cars) {
            if (car instanceof Truck)
                ((Truck) car).raisePlatform();
        }
    }

    @Override
    public void lowerBeds() {
        for (Car car : cars) {
            if (car instanceof Truck)
                ((Truck) car).lowerPlatform();
        }
    }

    @Override
    public void turbosOn() {
        for (Car car : cars) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    @Override
    public void turbosOff() {
        for (Car car : cars) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    @Override
    public void addSaab95() {
        if (cars.size() < max_cars)
            cars.add(CarFactory.createSaab95(getInitPos(), getInitDirection(), getInitWidth(), getInitHeight()));
    }

    @Override
    public void addVolvo240() {
        if (cars.size() < max_cars)
            cars.add(CarFactory.createVolvo240(getInitPos(), getInitDirection(), getInitWidth(), getInitHeight()));
    }

    @Override
    public void addScania() {
        if (cars.size() < max_cars)
            cars.add(CarFactory.createScania(getInitPos(), getInitDirection(), getInitWidth(), getInitHeight()));
    }

    @Override
    public void addCar() {
        int rand = (new Random(System.currentTimeMillis())).nextInt(3);

        switch (rand) {
            case 0: addSaab95(); break;
            case 1: addVolvo240(); break;
            case 2: addScania(); break;
        }
    }

    @Override
    public void removeCar() {
        if (cars.size() != 0)
            cars.remove(cars.size()-1);
    }

    @Override
    public List<Car> get() {
        return cars;
    }

    private double getInitDirection() {
        return INIT_DIR;
    }

    private Point2D.Double getInitPos() {
        double y = 0;
        for(Car car : cars) {
            y += car.getHeight();
        }
        return new Point2D.Double(START_X, y);
    }

    private double getInitWidth() {
        return START_W;
    }

    private double getInitHeight() {
        return START_H;
    }
}
