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

        boolean except2 = false;

        try {
            tp.loadCar(tp);
        } catch (LoadException e) {
            if (e.getMessage().contains("load smaller cars"))
                except2 = true;
        }

        assertTrue(except2);
        assertEquals(false, tp.isLoaded());

        tp.lowerPlatform();
        tp.loadCar(volvo);
        tp.raisePlatform();

        tp.gas(1);
        for(int i=0;i<20;i++) {
            tp.turnRight();
            tp.move();
            assertEquals(tp.getDirection(), volvo.getDirection());
            assertEquals(tp.getPosition(), volvo.getPosition());
        }

        tp.stopEngine();
        tp.lowerPlatform();
        tp.unloadCar();

        assertTrue(tp.distance(volvo) == 1d);
    }
}
