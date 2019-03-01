package view;

import model.Locateable;
import model.ReadableModel;

import java.awt.*;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    ReadableModel<? extends Locateable> model;

    // Initializes the panel and reads the images
    public DrawPanel(ReadableModel<? extends Locateable> model, int x, int y) {
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
            Image img = CarRepresentations.getCarRepresentations().getRepresentation(car.getClass());
            g.drawImage(img, (int) car.getPosition().x, (int) car.getPosition().y, null);
        }
    }
}
