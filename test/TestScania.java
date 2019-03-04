import model.CarFactory;
import model.PlatformException;
import model.Scania;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestScania {
    @Test
    public void testDumper() {
        Scania scania = CarFactory.createScania(new Point2D.Double(0,0), 0, 0,0);
        for (int i=0;i<20;i++) {
            scania.raisePlatform();
            assertTrue(scania.getPlatformAngle() <= scania.DUMPERMAXANGLE);
        }
        for (int i=0;i<20;i++) {
            scania.lowerPlatform();
            assertTrue(scania.getPlatformAngle() >= scania.DUMPERMINANGLE);
        }

        scania.gas(1);
        boolean except1 = false;
        try {
            scania.raisePlatform();
        } catch (PlatformException e) {
            except1 = true;
        }
        assertTrue(except1);

        scania.stopEngine();
        scania.raisePlatform();
        boolean except2 = false;
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());
    }
}
