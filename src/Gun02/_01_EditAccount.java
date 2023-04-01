package Gun02;

import Utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _01_EditAccount extends BaseDriverChrome {
    /*
          Senaryo
          1- Siteyi açınız.
          2- Edit Account sayfasına ulaşınız.
          3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
     */
    By editAccount = By.linkText("Edit Account");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By submitButton = By.cssSelector("input[type='submit']");

    @Test
    void editAccount(){
        editAccountTest("Burak2", "Gaznepoglu2");
        Tools.Wait(1.6);
        editAccountTest("Burak", "Gaznepoglu");
    }

    void editAccountTest(String name, String surName) {
        driver.findElement(editAccount).click();
        WebElement txtFirstName = driver.findElement(firstName);
        txtFirstName.clear();
        txtFirstName.sendKeys(name);
        WebElement txtLastName = driver.findElement(lastName);
        txtLastName.clear();
        txtLastName.sendKeys(surName);
        Tools.Wait(1.5);
        driver.findElement(submitButton).click();
        Tools.successMessageValidation();
    }
}
