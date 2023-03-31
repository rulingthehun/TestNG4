package Gun01;

import Utility.BaseDriverChrome;
import Utility.BaseDriverEdge;
import Utility.BaseDriverSafari;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Ornek extends BaseDriverChrome {
    @Test
    void LoginTest(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        System.out.println("Login test started");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("burakgaznepoglu_1999@hotmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("19Burak99.");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        Assert.assertEquals(driver.getTitle(), "My Account", "Login fail");

    }
}
