import java.awt.*;

public class Scania extends Car{

    public static final int DUMPERANGLECHANGE = 10, DUMPERMAXANGLE = 70, DUMPERMINANGLE = 0;

    private int dumperangle;

    public Scania() {
        super(2, 100, Color.yellow, "Scania");
        dumperangle = DUMPERMINANGLE;
    }
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public void raiseDumper() {
        if (getCurrentSpeed() != 0)
            throw new DumperException("Cannot raise dumper when the car is moving");
        dumperangle = Math.min(DUMPERMAXANGLE, dumperangle + DUMPERANGLECHANGE);
    }

    public void lowerDumper() {
        if (getCurrentSpeed() != 0)
            throw new DumperException("Cannot lower dumper when the car is moving");
        dumperangle = Math.max(DUMPERMINANGLE, dumperangle - DUMPERANGLECHANGE);
    }

    /**
     * Accelerates the car. Takes arguments in the range [0,1]
     * @param amount
     * @throws IllegalArgumentException if the argument is outside of the allowed range
     */
    public void gas(double amount) {
        if(dumperangle != DUMPERMINANGLE)
            throw new DumperException("Cannot increase speed if the dumper is not at its lowest position");
        super.gas(amount);
    }
}
