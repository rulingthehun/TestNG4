package Gun06;

import Utility.BaseDriverChrome;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrderPOM extends BaseDriverChrome {
    //POM : Page Object Model
    /* POM (Page Object Model) avantajları
   1- Bütün sayfalada isimleri aynı olan elemanlar için 1 tanımlama yeterli oluyor.
      Böylece tanımlanan elemanlar tekrar kullanılabilir yani Reusable oluyor.
   2- Kodun içerisinden HTML kodları ayrıldığından kod okunabilirliği artıyor.
   3- Developer locatorlarda bir değişiklik yaptığı zaman, asıl kodla hiç bir şekilde
      uğraşmak zorunda kalmıyoruz, sadece gidip locator ı değiştiriyoruz.
    */
    @Test
    void addToCard(){
        _02_PlaceOrderElements elements = new _02_PlaceOrderElements();

        elements.search.sendKeys("ipod");
        elements.search.sendKeys(Keys.ENTER);
        elements.addToCart.click();
        elements.shoppingCart.click();
        elements.checkout.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.paymentAddress)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.shippingAddress)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.shippingMethod)).click();
        elements.agree.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.paymentMethod)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.buttonConfirm)).click();
        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.confirmTxt.getText(), "Your order has been placed!");

    }
}
