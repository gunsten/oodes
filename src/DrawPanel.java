import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    Map<Car, BufferedImage> carImages;
    BufferedImage volvoImage, saabImage, scaniaImage;
    // To keep track of a singel cars position
    Map<Car, Point> carPoints;
    Point volvoPoint = new Point();

    List<Car> cars;

    // TODO: Make this genereal for all cars
    void moveit(Car car, int x, int y){
        carPoints.get(car).x = x;
        carPoints.get(car).y = y;
    }

    void addCar(Car car, int x, int y) {
        if (car instanceof Volvo240)
            carImages.put(car, volvoImage);
        else if (car instanceof Saab95)
            carImages.put(car, saabImage);
        else if (car instanceof Scania)
            carImages.put(car, scaniaImage);
        else
            throw new RuntimeException("No image associated to " + car.getClass().getName());
        cars.add(car);
        carPoints.put(car, new Point(x, y));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        cars = new ArrayList<>();
        carImages = new HashMap<>();
        carPoints = new HashMap<>();

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars) {
            g.drawImage(carImages.get(car), carPoints.get(car).x, carPoints.get(car).y, null);
        }
    }
}
