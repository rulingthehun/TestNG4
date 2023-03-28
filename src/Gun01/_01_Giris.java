package Gun01;

import Utility.BaseDriverFirefox;
import org.testng.annotations.Test;

public class _01_Giris {
    //TstNG kurulum
    //   org.testng:testng:6.14.3

    //  http://opencart.abstracta.us/index.php?route=account/login
    @Test(priority = 1)
    void WebSiteOpen(){
        System.out.println("Web site opened.");
    }

    @Test(priority = 2)
    void LoginProcess(){
        System.out.println("Login process done!");
    }

    @Test(priority = 3)
    void DriverStop(){
        System.out.println("Driver stop!");
        //driverStop();
    }
}
