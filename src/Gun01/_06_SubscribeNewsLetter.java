package Gun01;

import Utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _06_SubscribeNewsLetter extends BaseDriverFirefox {
      /*
        Senaryo
        1- Siteyi açınız.
        2- Newsletter  Subscribe işlemine abone olunuz(YES)
        3- Newsletter  Subscribe işlemine abonelikten çıkın(NO)
        4- Newsletter  Subscribe durumunu kontrol ediniz YES ise NO, No ise YES yapınız.
      */

    By link = By.linkText("Newsletter");
    By yes = By.cssSelector("input[type='radio'][value='1']");
    By no = By.cssSelector("input[type='radio'][value='0']");
    By cnt = By.cssSelector("input[type='submit'][value='Continue']");
    @Test(priority = 1)
    void subscribeFunctionYes(){
        driver.findElement(link).click();
        driver.findElement(yes).click();
        driver.findElement(cnt).click();
        Tools.successMessageValidation();
    }

    @Test(priority = 2)
    void subscribeFunctionNo(){
        driver.findElement(link).click();
        driver.findElement(no).click();
        driver.findElement(cnt).click();
        Tools.successMessageValidation();
    }

    @Test(priority = 3)
    void subscribeFunctionForBoth(){
        driver.findElement(link).click();
        WebElement subscribeYes = driver.findElement(yes);
        WebElement subscribeNo = driver.findElement(no);
        if (subscribeYes.isSelected())
            subscribeNo.click();
        else
            subscribeYes.click();
        driver.findElement(cnt).click();
        Tools.successMessageValidation();
    }

}
