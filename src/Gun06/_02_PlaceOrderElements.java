package Gun06;

import Utility.BaseDriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _02_PlaceOrderElements extends BaseDriverChrome {
    // Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
    // bunun için aşağıdaki consructor eklendi ve için PageFactory ile
    // driver üzerinden bu (this) sayfadaki bütün elemanlar ilşkilendirildi.
    // Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
    // anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
    // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
    // gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.
    public _02_PlaceOrderElements() {
        PageFactory.initElements(BaseDriverChrome.driver, this);
    }

    @FindBy(name="search")
    public WebElement search;

    @FindBy(xpath="(//*[text()='Add to Cart'])[1]")
    public WebElement addToCart;

    @FindBy(linkText="Shopping Cart")
    public WebElement shoppingCart;

    @FindBy(linkText="Checkout")
    public WebElement checkout;

    @FindBy(id="button-payment-address")
    public WebElement paymentAddress;

    @FindBy(id="button-shipping-address")
    public WebElement shippingAddress;

    @FindBy(id="button-shipping-method")
    public WebElement shippingMethod;

    @FindBy(name="agree")
    public WebElement agree;

    @FindBy(id="button-payment-method")
    public WebElement paymentMethod;

    @FindBy(id="button-confirm")
    public WebElement buttonConfirm;

    @FindBy(css="[id='content']>h1")
    public WebElement confirmTxt;

}
