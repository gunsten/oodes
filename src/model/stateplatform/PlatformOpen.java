package model.stateplatform;

public class PlatformOpen implements IStatePlatform {
    private static PlatformOpen obj = new PlatformOpen();

    private PlatformOpen(){

    }
    public static PlatformOpen getPlatformOpen(){
        return obj;
    }

    public int gas (){
        return 0;
    }
}
