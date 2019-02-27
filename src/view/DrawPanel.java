package view;

import model.Car;
import model.Locateable;
import model.ReadableModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Images associated with each car modelled
    Map<Car, BufferedImage> carImages;

    ReadableModel<Car> model;

    // Initializes the panel and reads the images
    public DrawPanel(ReadableModel<Car> model, Map<Car, BufferedImage> carImages, int x, int y) {
        this.carImages = carImages;
        this.model = model;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Locateable car : model.get()) {
            g.drawImage(carImages.get(car), (int) car.getPosition().x, (int) car.getPosition().y, null);
        }
    }
}
