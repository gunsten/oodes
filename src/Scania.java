import java.awt.*;

public class Scania extends Truck{

    public static final int DUMPERMAXANGLE = 70, DUMPERMINANGLE = 0;



    public Scania() {
        super(2, 100, Color.yellow, "Scania");
    }
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    @Override
    public int getPlatformMaxAngle() {
        return DUMPERMAXANGLE;
    }

    @Override
    public int getPlatformMinAngle() {
        return DUMPERMINANGLE;
    }

    @Override
    public int getPlatformClosedAngle() {
        return DUMPERMINANGLE;
    }
}
