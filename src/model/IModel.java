package model;

public interface IModel {
    void update();
    void gas(int amount);
    void brake(int amount);
    void startCars();
    void stopCars();
    void liftBeds();
    void lowerBeds();
    void turbosOn();
    void turbosOff();
    void addSaab95();
    void addVolvo240();
    void addScania();
    void addCar();
    void removeCar();
}
