import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Super class of cars
 */
public abstract class Car implements Movable{
    /**
     * Defines turning amount
     */
    public static final int TURNINGDEGREES = 10;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private Loadable container = null;
    /**
     * Car model name, set at object construction
     */
    public final String modelName; // The car model name

    private Point2D.Double position;
    private double direction;

    /**
     * Creates a car object
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        position = new Point2D.Double(0,0);
        direction = 0;
        stopEngine();
    }

    /**
     * @return Number of doors of the car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * @return Engine power of the car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * @return Current speed of the car
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * @return The color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sets the color of the car
     * @param clr Wanted car color
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the cars speed to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the cars speed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Override to customize car model speed increase/decrease formula
     * @return speed factor of the model
     */
    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(currentSpeed + amount * speedFactor(), enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(currentSpeed - amount * speedFactor(),0);
    }

    /**
     * Moves the car according to current speed
     */
    @Override
    public void move() {
        double newx = position.x + currentSpeed * Math.cos(direction);
        double newy = position.y + currentSpeed * Math.sin(direction);
        position = new Point2D.Double(newx, newy);
    }

    /**
     * Rotates the car counter-clockwise
     */
    @Override
    public void turnLeft() {
        direction -= Math.toRadians(TURNINGDEGREES);
        while(direction < 0) {
            direction += 2*Math.PI;
        }
    }

    /**
     * Rotates the car clockwise
     */
    @Override
    public void turnRight() {
        direction += Math.toRadians(TURNINGDEGREES);
        while(direction > 2*Math.PI) {
            direction -= 2*Math.PI;
        }
    }

    /**
     * Changes direction of the car 180 degrees
     */
    @Override
    public void uTurn() {
        direction += Math.toRadians(180);
        if(direction > 2*Math.PI) {
            direction -= 2*Math.PI;
        }
    }

    /**
     * Returns (a copy) of the cars position
     * @return car position
     */
    @Override
    public Point2D.Double getPosition() {
        if(container != null) {
            return container.getPosition();
        }
        else {
            return (Point2D.Double) position.clone();
        }
    }

    //TODO
    protected void setPosition(Point2D.Double position) {
        this.position = (Point2D.Double) position.clone();
    }

    //TODO
    protected void setDirection(double direction) {
        this.direction = direction;
    }

    /**
     * Returns the cars direction in rads
     * @return car direction
     */
    @Override
    public double getDirection(){
        if(container != null && container instanceof Movable)
            return ((Movable) container).getDirection();
        else
            return direction;
    }

    /**
     * Accelerates the car. Takes arguments in the range [0,1]
     * @param amount
     * @throws IllegalArgumentException if the argument is outside of the allowed range
     * @throws LoadException if the car is loaded, it can't gas
     */
    public void gas(double amount) throws IllegalArgumentException {
        if(amount < 0 || amount > 1)
            throw new IllegalArgumentException("gas amount must be in the range [0,1]");
        if(container != null)
            throw new LoadException("Cannot increase speed of loaded car");
        incrementSpeed(amount);
    }

    /**
     * Decelerates the car. Takes arguments in the range [0,1]
     * @param amount
     * @throws IllegalArgumentException if the argument is outside of the allowed range
     */
    public void brake(double amount) throws IllegalArgumentException {
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("brake amount must be in the range [0,1]");
        decrementSpeed(amount);
    }

    /**
     * Should be called when this car is loaded
     * @param transport
     */
    protected void load(Loadable transport) {
        if (isLoaded())
            throw new LoadException("The car is already loaded");
        this.container = transport;
        stopEngine();
    }

    /**
     * Should be called when this car is unloaded. Set direction and position in relation to container
     */
    protected void unload() {
        if (!isLoaded())
            throw new LoadException("The car is not loaded");
        direction = getDirection();
        this.position = new Point2D.Double(getPosition().x - Math.cos(direction),
                getPosition().y - Math.sin(direction) );
        container = null;
    }

    /**
     * @return True if the car is loaded
     */
    public boolean isLoaded() {
        return container != null;
    }
}
