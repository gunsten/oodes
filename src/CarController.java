import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Car volvo = new Volvo240();
        cc.cars.add(volvo);

        Car saab = new Saab95();
        saab.setPosition(new Point2D.Double(0,100d));
        cc.cars.add(saab);
        Car scania = new Scania();
        scania.setPosition(new Point2D.Double(0, 200d));
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Add "tokens" to drawPanel
        cc.frame.drawPanel.addCar(volvo, 0,0);
        cc.frame.drawPanel.addCar(saab, 0,100);
        cc.frame.drawPanel.addCar(scania, 0,200);

        // Start the timer
        cc.timer.start();
    }

    public void turbo(boolean on) {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                if (on)
                    ((Saab95) car).setTurboOn();
                else
                    ((Saab95) car).setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (Car car : cars) {
            if (car instanceof Truck) {
                ((Truck) car).raisePlatform();
            }
        }
    }

    public void lowerBed() {
        for (Car car : cars) {
            if (car instanceof Truck) {
                ((Truck) car).lowerPlatform();
            }
        }
    }

    public void startCars() {
        for (Car car : cars)
            car.startEngine();
    }

    public void stopCars() {
        for (Car car : cars)
            car.stopEngine();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());

                // Change car direction at edge of panel
                if(x < 0 || x + 100 > frame.drawPanel.getWidth()) {
                    car.uTurn();
                }

                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel

            }
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
}
