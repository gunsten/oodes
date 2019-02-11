/**
 * Exception thrown when trying to drive a Truck with unclosed platform, or trying to open a platform of a running Truck
 */
public class PlatformException extends RuntimeException{
    public PlatformException(String msg) {
        super(msg);
    }
}
