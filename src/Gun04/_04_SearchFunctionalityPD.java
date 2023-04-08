package Gun04;

import Utility.BaseDriverChrome;
import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class _04_SearchFunctionalityPD extends BaseDriverParameter {
    /*
       Senaryo ;
       1- Siteyi açınız.
       2- mac kelimesini göndererek aratınız.
       3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
       4- aynı işlemi samsung için de yapınız
     */
    @Test
    @Parameters("search")
    void SearchFunction(String wordToSearch) throws AWTException {
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys(wordToSearch);
        search.sendKeys(Keys.ENTER);

        //with robot
        //Robot robot = new Robot();
        ////For macOS
        //robot.keyPress(KeyEvent.VK_META);
        //robot.keyPress(KeyEvent.VK_TAB);
        //robot.keyRelease(KeyEvent.VK_TAB);
        //Tools.Wait(1);
        //robot.keyRelease(KeyEvent.VK_META);

        //robot.keyPress(KeyEvent.VK_ENTER);
        //robot.keyRelease(KeyEvent.VK_ENTER);

        //1. Yöntem
        //List<WebElement> results = driver.findElements(By.xpath("//div[@class='caption']//h4//a"));
        //List<WebElement> macResults = driver.findElements(By.xpath("//div[@class='caption']//h4//a[contains(text(),Mac)]"));
        //Assert.assertEquals(results, macResults);

        //2. Yöntem
        List<WebElement> captions = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        for (WebElement e : captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(wordToSearch));
    }
}
