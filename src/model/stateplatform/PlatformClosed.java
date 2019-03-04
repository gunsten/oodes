package model.stateplatform;

public class PlatformClosed implements IStatePlatform {

    private static PlatformClosed obj = new PlatformClosed();

    private PlatformClosed(){

    }
    public static PlatformClosed getPlatformColsed(){
        return obj;
    }
    public int gas (){
        return 1;
    }



}
