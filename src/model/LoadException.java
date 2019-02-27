package model;

/**
 * Exception thrown for several errors related to loading and unloading
 */
public class LoadException extends RuntimeException {
    public LoadException(String msg) {
        super(msg);
    }
}
