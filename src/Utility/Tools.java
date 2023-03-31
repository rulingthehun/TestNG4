package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Tools {
    public static void Wait(double saniye){
        try {
            Thread.sleep((long) (saniye*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void successMessageValidation(){
        WebElement msgLabel = BaseDriverChrome.driver.findElement(By.cssSelector("div[class*='success']"));
        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
    }
}
