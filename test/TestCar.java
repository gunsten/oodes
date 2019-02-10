import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCar {

    @Test
    public void testInit() {
        Car volvo = new Volvo240();
        Car saab = new Saab95();
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
}