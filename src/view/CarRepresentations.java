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
    private Map<Class<? extends Locateable>, Image> map;
    private static CarRepresentations carRepresentations;

    private CarRepresentations() {
        map = new HashMap<>();
    }

    public static CarRepresentations getCarRepresentations() {
        if (carRepresentations != null) {
            return carRepresentations;
        }
        else {
            carRepresentations = new CarRepresentations();
            BufferedImage volvoImage = null, saabImage = null, scaniaImage = null;

            try {
                //TODO Better way to reference resources
                volvoImage = ImageIO.read(CarRepresentations.class.getResourceAsStream("../Volvo240.jpg"));
                saabImage = ImageIO.read(CarRepresentations.class.getResourceAsStream("../Saab95.jpg"));
                scaniaImage = ImageIO.read(CarRepresentations.class.getResourceAsStream("../Scania.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            carRepresentations.addRepresentation(Volvo240.class, volvoImage);
            carRepresentations.addRepresentation(Saab95.class, saabImage);
            carRepresentations.addRepresentation(Scania.class, scaniaImage);
            return carRepresentations;
        }
    }

    public void addRepresentation(Class<? extends Locateable> locatable_class, Image image) {
        map.put(locatable_class, image);
    }
    public Image getRepresentation(Class<? extends Locateable> locatable_class) {
        return map.get(locatable_class);
    }
}
