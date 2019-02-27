import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTransport {
    @Test
    public void testLoad() {
        Volvo240 volvo = new Volvo240();
        Transport tp = new Transport(5);

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
        Transport tp2 = new Transport(2);
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

        Saab95 saab = new Saab95();

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
    public void testConstructor() {
        boolean except = false;
        try {
            new Transport(-1);
        } catch (IllegalArgumentException e) {
            except = true;
        }
        assertTrue(except);

        except = false;
        try {
            new Transport(0);
        } catch (IllegalArgumentException e) {
            except = true;
        }
        assertTrue(except);
    }

    @Test
    public void testEmpty() {
        Transport tp = new Transport(1);
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
        Transport tp = new Transport(1);
        tp.lowerPlatform();
        tp.loadCar(new Volvo240());
        boolean except = false;

        try {
            tp.loadCar(new Saab95());
        } catch (LoadException e) {
            if (e.getMessage().contains("full"))
                except = true;
        }

        assertTrue(except);
    }
}
