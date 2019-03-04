import model.CarFactory;
import model.LoadException;
import model.Volvo240;
import model.Workshop;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestWorkshop {
    @Test
    public void testWorkshop() {
        Workshop<Volvo240> wsvolvo = new Workshop<>();

        Volvo240 v1 = CarFactory.createVolvo240(new Point2D.Double(0,0),0,0,0);
        Volvo240 v2 = CarFactory.createVolvo240(new Point2D.Double(0,0),0,0,0);

        wsvolvo.loadCar(v1);
        wsvolvo.loadCar(v2);

        //wsvolvo.loadCar(new model.Saab95());

        assertTrue(wsvolvo.unloadCar() instanceof Volvo240);
        assertTrue(wsvolvo.unloadCar() instanceof Volvo240);

        boolean except1 = false;
        try {
            wsvolvo.unloadCar();
        } catch (LoadException e) {
            except1 = true;
        }

        assertTrue(except1);

        v1.gas(1);v1.move();v1.move();v1.move();


        boolean except2 = false;
        try {
            wsvolvo.loadCar(v1);
        } catch (LoadException e) {
            except2 = true;
        }

        assertTrue(except2);
    }
}
