import controller.CarController;
import model.*;
import view.CarView;
import view.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        BufferedImage volvoImage = null, saabImage = null, scaniaImage = null;
        // Instance of this class
        //controller.ICarController cc = new controller.CarController();

        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("model.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(Main.class.getResourceAsStream("Volvo240.jpg"));
            saabImage = ImageIO.read(Main.class.getResourceAsStream("Saab95.jpg"));
            scaniaImage = ImageIO.read(Main.class.getResourceAsStream("Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        ArrayList<Car> cars = new ArrayList<>();
        HashMap<Car, BufferedImage> imgMap = new HashMap<>();

        Car volvo = new Volvo240();
        cars.add(volvo);
        imgMap.put(volvo, volvoImage);

        Car saab = new Saab95();
        saab.setPosition(new Point2D.Double(0,100d));
        cars.add(saab);
        imgMap.put(saab, saabImage);

        Car scania = new Scania();
        scania.setPosition(new Point2D.Double(0, 200d));
        cars.add(scania);
        imgMap.put(scania, scaniaImage);

        Model model = new Model(cars, CarView.X);

        DrawPanel drawPanel = new DrawPanel(model, imgMap, CarView.X, CarView.Y-240);

        CarController cc = new CarController(drawPanel, model);

        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc, drawPanel);


        // Start the timer
        cc.startSimulation();
    }
}
