/**
 * Any object with the ability to move
 */
public interface Movable extends Locateable{
    /**
     * Moves the object
     */
    public void move();

    /**
     * Turns the object counter-clockwise
     */
    public void turnLeft();

    /**
     * Turns the object clockwise
     */
    public void turnRight();

    /**
     * Changes direction of the object 180 degrees
     */
    public void uTurn();

    /**
     * Returns the direction of the object in radians
     * @return direction in radians
     */
    public double getDirection();
}
