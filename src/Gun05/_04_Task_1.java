package Gun05;

import Utility.BaseDriverChrome;
import Utility.BaseDriverParameter;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class _04_Task_1 extends BaseDriverParameter {
     /*
     * Daha önceki derslerde yaptğımı Search fonksiyonunu
     * mac,ipod ve samsung için Dataprovider ile yapınız.
     */
     @Test(dataProvider = "data")
     void SearchFunction(String searchText) {
         WebElement search = driver.findElement(By.name("search"));
         search.clear();
         search.sendKeys(searchText);
         search.sendKeys(Keys.ENTER);

         Tools.Wait(1);
         List<WebElement> captions = driver.findElements(By.xpath("//div[@class='caption']//h4"));
         if (captions.size()<1)
             Assert.fail();
         for (WebElement e : captions){
             System.out.println("searchText = " + searchText);
             System.out.println("e.getText() = " + e.getText());
             Assert.assertTrue(e.getText().toLowerCase().contains(searchText.toLowerCase()));}
     }

     @DataProvider
    public Object[] data(){
         Object[] data = {"iMac", "Samsung", "iPod"};
         return data;
     }
}
