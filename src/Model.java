import java.util.List;

public class Model implements IModel, ReadableModel<Car> {
    private final List<Car> cars;
    private final double width;
    public Model(List<Car> cars, double width) {
        this.cars = cars;
        this.width = width;
    }
    @Override
    public void update() {
        for (Car car : cars) {
            car.move();
            if(car.getPosition().x < 0 || car.getPosition().x > width - 100) {
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
    public List<Car> get() {
        return (List<Car>) cars;
    }
}
