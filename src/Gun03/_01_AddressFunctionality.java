package Gun03;

import Utility.BaseDriverChrome;
import Utility.MyFunc;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _01_AddressFunctionality extends BaseDriverChrome {
    /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */
    @Test(priority = 1)
    void addAddress() {
        driver.findElement(By.linkText("Address Book")).click();
        driver.findElement(By.linkText("New Address")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Burak");
        driver.findElement(By.id("input-lastname")).sendKeys("Gaznepoglu");
        driver.findElement(By.id("input-company")).sendKeys("mersys.io");
        driver.findElement(By.id("input-address-1")).
                sendKeys("Dogu Akdeniz Universitesi Guney Kampus");
        driver.findElement(By.id("input-address-2")).sendKeys("Magusa, KKTC");
        driver.findElement(By.id("input-city")).sendKeys("Magusa");
        driver.findElement(By.id("input-postcode")).sendKeys("99450");
        //WebElement option = driver.findElement(By.cssSelector("select[name='country_id']>option"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.stalenessOf(option));
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("input-country")));
        new Select(driver.findElement(By.id("input-country"))).selectByValue("55");
        //selectByValue, selectByVisibleText implicitlyWait ile ortak çalışır
        //selectByIndex implicitlyWait ile ortak çalışmaz

        new Select(driver.findElement(By.id("input-zone"))).selectByValue("883");

        /*
        For inspection
               WebElement state = driver.findElement(By.id("input-zone"));
               Select stateSelect = new Select(state);
               System.out.println("stateSelect.getOptions().size() = " + stateSelect.getOptions().size());
               for (WebElement e : stateSelect.getOptions())
                   System.out.println("e = " + e.getText());
         */

        driver.findElement(By.name("default")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Tools.successMessageValidation();
    }

    @Test(dependsOnMethods = {"addAddress"})
    void addAddress2() {
        driver.findElement(By.linkText("Address Book")).click();
        driver.findElement(By.linkText("New Address")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Burak");
        driver.findElement(By.id("input-lastname")).sendKeys("Gaznepoglu");
        driver.findElement(By.id("input-company")).sendKeys("mersys.io");
        driver.findElement(By.id("input-address-1")).
                sendKeys("Dogu Akdeniz Universitesi Guney Kampus");
        driver.findElement(By.id("input-address-2")).sendKeys("Magusa, KKTC");
        driver.findElement(By.id("input-city")).sendKeys("Magusa");
        driver.findElement(By.id("input-postcode")).sendKeys("99450");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("country_id")));
        new Select(driver.findElement(By.name("country_id"))).selectByVisibleText("Cyprus");
        new Select(driver.findElement(By.id("input-zone"))).selectByValue("883");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Tools.successMessageValidation();
    }

    @Test(dependsOnMethods = {"addAddress2"})
    void editAddress() {
        driver.findElement(By.linkText("Address Book")).click();
        List<WebElement> editAll = driver.findElements(By.linkText("Edit"));
        editAll.get(editAll.size() - 1).click();
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("Burak Edited");
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys("Gaznepoglu Edited");
        WebElement company = driver.findElement(By.id("input-company"));
        company.clear();
        company.sendKeys("mersys.io Edited");
        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.clear();
        address1.sendKeys("Dogu Akdeniz Universitesi Guney Kampus Edited");
        WebElement address2 = driver.findElement(By.id("input-address-2"));
        address2.clear();
        address2.sendKeys("Magusa, KKTC Edited");
        WebElement city = driver.findElement(By.id("input-city"));
        city.clear();
        city.sendKeys("Magusa Edited");
        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.clear();
        postCode.sendKeys("99450 Edited");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("country_id")));
        new Select(driver.findElement(By.name("country_id"))).selectByValue("55");
        new Select(driver.findElement(By.id("input-zone"))).selectByValue("883");
        driver.findElement(By.name("default")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Tools.successMessageValidation();
    }

    @Test(priority = 4)
    void deleteAddress() {
        driver.findElement(By.linkText("Address Book")).click();
        List<WebElement> deleteAll = driver.findElements(By.linkText("Delete"));
        deleteAll.get(deleteAll.size() - 2).click();
        Tools.successMessageValidation();
        System.out.println("deleted");
        MyFunc.Wait(2);
    }

}
