import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable{
    public static final int TURNINGDEGREES = 10;

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private Point2D.Double position;
    private double direction;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        position = new Point2D.Double(0,0);
        direction = 0;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected void setSpeed(double speed) {
        currentSpeed = speed;
    }

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    @Override
    public void move() {
        double newx = position.x + currentSpeed * Math.cos(direction);
        double newy = position.y + currentSpeed * Math.sin(direction);
    }

    @Override
    public void turnLeft() {
        direction -= Math.toRadians(TURNINGDEGREES);
        while(direction < 0) {
            direction += 2*Math.PI;
        }
    }

    @Override
    public void turnRight() {
        direction += Math.toRadians(TURNINGDEGREES);
        while(direction > 2*Math.PI) {
            direction -= 2*Math.PI;
        }
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
