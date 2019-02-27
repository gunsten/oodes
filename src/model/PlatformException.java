package model;

/**
 * Exception thrown when trying to drive a model.Truck with unclosed platform, or trying to open a platform of a running model.Truck
 */
public class PlatformException extends RuntimeException{
    public PlatformException(String msg) {
        super(msg);
    }
}
