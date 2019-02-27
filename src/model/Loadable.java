package model;

/**
 * Interface for all classes that can contain or carry cars
 * @param <T> Subclass of model.Car
 */
public interface Loadable <T extends Car> extends Locateable{
    /**
     * Loads a car
     * @param car
     */
    public void loadCar(T car);
    /**
     * Unloads a car
     * @return
     */
    public T unloadCar();
}
