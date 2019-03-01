package view;

import model.Locateable;
import model.Saab95;
import model.Scania;
import model.Volvo240;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CarRepresentations {
    Map<Class<? extends Locateable>, Image> map;

    private CarRepresentations() {
        map = new HashMap<>();
    }

    public static CarRepresentations getDefaultCarRepresentations() {
        CarRepresentations cr = new CarRepresentations();
        BufferedImage volvoImage = null, saabImage = null, scaniaImage = null;
        // Instance of this class
        //controller.ICarController cc = new controller.CarController();

        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("model.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(CarRepresentations.class.getResourceAsStream("Volvo240.jpg"));
            saabImage = ImageIO.read(CarRepresentations.class.getResourceAsStream("Saab95.jpg"));
            scaniaImage = ImageIO.read(CarRepresentations.class.getResourceAsStream("Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        cr.addRepresentation(Volvo240.class, volvoImage);
        cr.addRepresentation(Saab95.class, saabImage);
        cr.addRepresentation(Scania.class, scaniaImage);
        return cr;
    }

    public void addRepresentation(Class<? extends Locateable> locatable_class, Image image) {
        map.put(locatable_class, image);
    }
    public Image getRepresentation(Class<? extends Locateable> locatable_class) {
        return map.get(locatable_class);
    }
}
