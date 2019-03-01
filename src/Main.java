import controller.CarController;
import model.*;
import view.CarRepresentations;
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
        Model model = Model.createDefaultModel(10, CarView.X);

        DrawPanel drawPanel = new DrawPanel(model, CarView.X, CarView.Y-240);

        CarController cc = new CarController(drawPanel, model);

        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc, drawPanel);


        // Start the timer
        cc.startSimulation();
    }
}
