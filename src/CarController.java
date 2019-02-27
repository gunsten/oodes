import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    Component updateableView;
    IModel model;

    public CarController(Component updateableView, IModel model) {
        this.updateableView = updateableView;
        this.model = model;
    }
    //methods:


    public void turbo(boolean on) {
        if (on) {
            model.turbosOn();
        } else {
            model.turbosOff();
        }
    }

    public void liftBed() {
        model.liftBeds();
    }

    public void lowerBed() {
        model.lowerBeds();
    }

    public void startCars() {
        model.startCars();
    }

    public void stopCars() {
        model.stopCars();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();
            updateableView.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        model.gas(amount);
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        model.brake(amount);
    }
}
