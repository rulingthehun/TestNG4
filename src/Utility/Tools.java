package Utility;

public class Tools {
    public static void Wait(double saniye){
        try {
            Thread.sleep((long) (saniye*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
