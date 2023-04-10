package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

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

    public static void listContainsString(List<WebElement> list, String itemToFind){
        boolean itemFound = false;
        for (WebElement e : list)
            if (e.getText().equalsIgnoreCase(itemToFind)){
                itemFound = true;
                break;
            }
        if (!itemFound)
            Assert.fail("Item not found!");
    }

    public static int randomGenerator(int max){
        return (int) (Math.random() * max);
    }
    //random
}
