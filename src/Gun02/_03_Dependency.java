package Gun02;

import org.testng.annotations.Test;

public class _03_Dependency {
    @Test
    void startCar(){
        System.out.println("startCar");
    }

    @Test(dependsOnMethods = {"startCar"})
    void driveCar(){
        System.out.println("driveCar");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"})
    void parkCar(){
        System.out.println("parkCar");
    }

    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)
    void stopCar(){
        System.out.println("stopCar");
    }
    // aynı seviyedeki testleri için priority verilebilir.
    // bağımlı testler, direkt metodundan çalıştırdığınızda bağımlı
    // olduğu metod zincirinde 2 üste kadar ototmatik çağırıp çalışabilir.
}
