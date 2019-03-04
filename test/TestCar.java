import model.Car;
import model.CarFactory;
import model.Saab95;
import model.Volvo240;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCar {

    @Test
    public void testInit() {
        Car volvo = CarFactory.createVolvo240(new Point2D.Double(0,0), 0,1,1);
        Car saab = CarFactory.createSaab95(new Point2D.Double(0,0), 0,1,1);
        assertEquals(Color.black, volvo.getColor());
        assertEquals(Color.red, saab.getColor());
        assertEquals(4, volvo.getNrDoors());
        assertEquals(2, saab.getNrDoors());
        assertEquals(100, volvo.getEnginePower());
        assertEquals(125, saab.getEnginePower());
        assertEquals("Volvo240", volvo.modelName);
        assertEquals("Saab95", saab.modelName);
        assertEquals(0, volvo.getCurrentSpeed());
        assertEquals(0, saab.getCurrentSpeed());
        assertEquals(0, volvo.getDirection());
        assertEquals(0, saab.getDirection());
        assertEquals(new Point2D.Double(0,0), volvo.getPosition());
        assertEquals(new Point2D.Double(0,0), saab.getPosition());
    }

    @Test
    public void testSetters() {
        Car volvo = CarFactory.createVolvo240(new Point2D.Double(0,0), 0,1,1);
        volvo.setColor(Color.white);
        assertEquals(Color.white, volvo.getColor());
    }

    @Test
    public void testMoveStationary() {
        Car volvo = CarFactory.createVolvo240(new Point2D.Double(0,0), 0,1,1);

        //Zero speed
        Point2D.Double initial = volvo.getPosition();
        volvo.move();
        assertEquals(initial, volvo.getPosition());
    }

    @Test
    public void testMoveHorizontal() {
        Saab95 saab = CarFactory.createSaab95(new Point2D.Double(0,0), 0,1,1);

        Point2D.Double initial = saab.getPosition();
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(1);
        saab.setTurboOff();
        saab.gas(1);
        double speed = saab.getCurrentSpeed();
        saab.move();
        saab.move();
        saab.move();
        assertEquals(initial.x  + 3 * speed, saab.getPosition().x);
    }

    @Test
    public void testMove() {
        Volvo240 volvo = CarFactory.createVolvo240(new Point2D.Double(0,0), 0,1,1);

        Point2D.Double initial = volvo.getPosition();

        volvo.gas(1);
        double speed = volvo.getCurrentSpeed();

        volvo.turnLeft();volvo.turnLeft();volvo.turnRight();
        double dir = volvo.getDirection();

        volvo.move();

        assertEquals(initial.x + speed * Math.cos(dir), volvo.getPosition().x);
        assertEquals(initial.y + speed * Math.sin(dir), volvo.getPosition().y);

        //Test brake

        volvo.brake(1);volvo.brake(1);volvo.brake(1);

        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    public void testTurnRight() {
        Car saab = CarFactory.createSaab95(new Point2D.Double(0,0), 0,1,1);
        for(int i=0;i<100;i++) {
            saab.turnRight();
            assertTrue(saab.getDirection() >= 0 && saab.getDirection() <= 2*Math.PI);
        }
    }

    @Test
    public void testBrakeGasException() {
        boolean except1 = false;
        boolean except2 = false;
        try {
            (CarFactory.createSaab95(new Point2D.Double(0,0), 0,1,1)).gas(10534645);
        } catch (IllegalArgumentException e) {
            except1 = true;
        }
        try {
            (CarFactory.createVolvo240(new Point2D.Double(0,0), 0,1,1)).brake(-20);
        } catch (IllegalArgumentException e) {
            except2 = true;
        }
        assertTrue(except1);
        assertTrue(except2);
    }
}