package controller;

public interface ICarController {
    void gas(int amount);
    void brake(int amount);
    void startCars();
    void stopCars();
    void liftBeds();
    void lowerBeds();
    void turbos(boolean on);
    void startSimulation();
}
