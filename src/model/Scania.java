package model;

import java.awt.*;

/**
 * model.Scania, a truck with a dumper
 */
public class Scania extends Truck{

    /**
     * Defines possible dumper angle states
     */
    public static final int DUMPERMAXANGLE = 70, DUMPERMINANGLE = 0, DUMPERANGLECHANGE = 10;

    /**
     * Creates a model.Scania object
     */
    public Scania() {
        super(2, 100, Color.yellow, "model.Scania");
    }

    /**
     * @return the speed factor of the model.Scania
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * @return the angle change at each raising and lowering of the dumper
     */
    @Override
    public int getPlatformAngleChange() {
        return DUMPERANGLECHANGE;
    }

    /**
     * @return the maximum angle of the dumper
     */
    @Override
    public int getPlatformMaxAngle() {
        return DUMPERMAXANGLE;
    }

    /**
     * @return the minimum angle of the dumper
     */
    @Override
    public int getPlatformMinAngle() {
        return DUMPERMINANGLE;
    }

    /**
     * @return the angle at which the dumper is concidered "closed", that is the state at which the truck is driveable
     */
    @Override
    public int getPlatformClosedAngle() {
        return DUMPERMINANGLE;
    }
}
