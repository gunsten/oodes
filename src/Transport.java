import java.awt.*;
import java.util.Stack;

public class Transport extends Truck implements Loadable<PrivateCar> {
    private Stack<PrivateCar> cars;
    private int max;
    public static final double LOADDISTANCE = 1;

    public Transport(int max) {
        super(2, 100, Color.red, "Transport");
        if(max <= 0)
            throw new IllegalArgumentException("Car capacity of Transport must be positive");
        this.max = max;
        cars = new Stack<>();
    }

    @Override
    public void loadCar(PrivateCar car) {
        if (getPlatformAngle() == getPlatformClosedAngle())
            throw new LoadException("Cannot load a car unto the transport when the ramp is up");
        if (cars.size() >= max)
            throw new LoadException("The transport is full");
        if (car.distance(this) > LOADDISTANCE)
            throw new LoadException("The car is too far away");
        car.load(this);
        cars.push((PrivateCar) car);
    }

    @Override
    public PrivateCar unloadCar() {
        if (getPlatformAngle() == getPlatformClosedAngle())
            throw new LoadException("Cannot unload a car unto the transport when the ramp is up");
        if (cars.empty())
            throw new LoadException("The transport is empty");
        PrivateCar car = cars.pop();
        car.unload();
        return car;
    }
    @Override
    public int getPlatformAngleChange() {
        return 90;
    }

    @Override
    public int getPlatformMaxAngle() {
        return 90;
    }

    @Override
    public int getPlatformMinAngle() {
        return 0;
    }

    @Override
    public int getPlatformClosedAngle() {
        return 90;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
