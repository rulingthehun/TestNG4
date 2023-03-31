package Gun02;

import Utility.BaseDriverEdge;
import Utility.BaseDriverSafari;
import Utility.Tools;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class _01_EditAccount extends BaseDriverSafari {
    /*
          Senaryo
          1- Siteyi açınız.
          2- Edit Account sayfasına ulaşınız.
          3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
     */
    By link = By.linkText("Newsletter");
    By yes = By.cssSelector("input[type='radio'][value='1']");
    By no = By.cssSelector("input[type='radio'][value='0']");
    By cnt = By.cssSelector("input[type='submit'][value='Continue']");

    @Test
    void editAccount() {
        driver.findElement(link).click();
        driver.findElement(yes).click();
        driver.findElement(cnt).click();
        Tools.successMessageValidation();
    }
}
