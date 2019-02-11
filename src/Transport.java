import java.awt.*;
import java.util.Stack;

/**
 * A transport for carrying private cars
 */
public class Transport extends Truck implements Loadable<PrivateCar> {
    private Stack<PrivateCar> cars;
    private int max;
    /**
     * Max distance at which a car can be loaded unto the transport
     */
    public static final double LOADDISTANCE = 1;

    /**
     * Creates a Transport object
     * @param max maximum carrying capacity, number of cars
     */
    public Transport(int max) {
        super(2, 100, Color.red, "Transport");
        if(max <= 0)
            throw new IllegalArgumentException("Car capacity of Transport must be positive");
        this.max = max;
        cars = new Stack<>();
    }

    /**
     * Loads a car unto the transport
     * @param car the car to be loaded
     */
    @Override
    public void loadCar(PrivateCar car) {
        if (getPlatformAngle() == getPlatformClosedAngle())
            throw new LoadException("Cannot load a car unto the transport when the ramp is up");
        if (cars.size() >= max)
            throw new LoadException("The transport is full");
        if (Locateable.distance(car, this) > LOADDISTANCE)
            throw new LoadException("The car is too far away");
        car.load(this);
        cars.push(car);
    }

    /**
     * Unloads the car that was last to be loaded
     * @return the car that was last to be loaded
     */
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

    /**
     * @return the angle change at each raising and lowering of the ramp. The ramp can only be opened or closed.
     */
    @Override
    public int getPlatformAngleChange() {
        return 90;
    }

    /**
     *
     * @return
     */
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
