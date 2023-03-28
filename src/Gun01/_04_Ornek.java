package Gun01;

import Utility.BaseDriverSafari;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _04_Ornek extends BaseDriverSafari {
    @Test
    void LoginTest(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        System.out.println("Login test started");
        //WebElement
    }
}
