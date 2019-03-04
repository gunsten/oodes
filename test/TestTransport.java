import model.*;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTransport {
    @Test
    public void testLoad() {
        Volvo240 volvo = CarFactory.createVolvo240(new Point2D.Double(0,0),0,0,0);
        Transport tp = CarFactory.createTransport(new Point2D.Double(0,0),0,0,0,5);

        boolean except1 = false;

        try {
            tp.loadCar(volvo);
        } catch (LoadException e) {
            if (e.getMessage().contains("the ramp is up"))
                except1 = true;
        }

        assertTrue(except1);
        assertEquals(false, volvo.isLoaded());

        //boolean except2 = false;

        /*try {
            tp.loadCar(tp);
        } catch (model.LoadException e) {
            if (e.getMessage().contains("load smaller cars"))
                except2 = true;
        }*/

        //assertTrue(except2);
        //assertEquals(false, tp.isLoaded());

        tp.lowerPlatform();
        tp.loadCar(volvo);
        tp.raisePlatform();

        //Test that loaded car cannot be loaded again
        boolean except11 = false;
        Transport tp2 = CarFactory.createTransport(new Point2D.Double(0,0),0,0,0,5);
        tp2.lowerPlatform();
        try {
            tp2.loadCar(volvo);
        } catch(LoadException e) {
            if (e.getMessage().contains("already loaded"))
                except11 = true;
        }

        assertTrue(except11);

        tp.gas(1);
        for(int i=0;i<20;i++) {
            tp.turnRight();
            tp.move();
            assertEquals(tp.getDirection(), volvo.getDirection());
            assertEquals(tp.getPosition(), volvo.getPosition());
        }

        //Test that loaded car cannot gas
        boolean except21 = false;

        try {
            volvo.gas(1);
        } catch (LoadException e) {
            except21 = true;
        }
        assertTrue(except21);

        tp.stopEngine();

        boolean except3 = false;

        try {
            tp.unloadCar();
        } catch (LoadException e) {
            if (e.getMessage().contains("ramp is up"))
                except3 = true;
        }

        assertTrue(except3);

        tp.lowerPlatform();
        tp.unloadCar();

        assertTrue(Locateable.distance(tp, volvo) == 1d);
        assertEquals(false, volvo.isLoaded());

        //Test load range

        Saab95 saab = CarFactory.createSaab95(new Point2D.Double(0,0),0,0,0);

        boolean except4 = false;

        try {
            tp.loadCar(saab);
        } catch (LoadException e) {
            if (e.getMessage().contains("too far away"))
                except4 = true;
        }

        assertTrue(except4);
        assertEquals(false, saab.isLoaded());
    }

    @Test
    public void testFactoryMethod() {
        boolean except = false;
        try {
            CarFactory.createTransport(new Point2D.Double(0,0),0,0,0,-1);
        } catch (IllegalArgumentException e) {
            except = true;
        }
        assertTrue(except);

        except = false;
        try {
            CarFactory.createTransport(new Point2D.Double(0,0),0,0,0,0);
        } catch (IllegalArgumentException e) {
            except = true;
        }
        assertTrue(except);
    }

    @Test
    public void testEmpty() {
        Transport tp = CarFactory.createTransport(new Point2D.Double(0,0),0,0,0,1);
        tp.lowerPlatform();

        boolean except = false;

        try {
            tp.unloadCar();
        } catch (LoadException e) {
            if (e.getMessage().contains("empty"))
                except = true;
        }

        assertTrue(except);
    }

    @Test
    public void testFull() {
        Transport tp = CarFactory.createTransport(new Point2D.Double(0,0),0,0,0,1);
        tp.lowerPlatform();
        tp.loadCar(CarFactory.createVolvo240(new Point2D.Double(0,0),0,0,0));
        boolean except = false;

        try {
            tp.loadCar(CarFactory.createSaab95(new Point2D.Double(0,0),0,0,0));
        } catch (LoadException e) {
            if (e.getMessage().contains("full"))
                except = true;
        }

        assertTrue(except);
    }
}
