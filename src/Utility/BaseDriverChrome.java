package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverChrome {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeClass(groups = "SmokeTest")
    public void startingProcess() {
        System.out.println("Starting process is started");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options=new ChromeOptions();
        //options.addArguments("headless");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize(); //Tam ekran
        driver.manage().deleteAllCookies(); //Sitenin bilgisayarda yağtığı ayarları siler
        Duration dr = Duration.ofSeconds(20);
        driver.manage().timeouts().pageLoadTimeout(dr); //Sadece tüm sayfanın kodlarının
        //// bilgisayara inme süresi ile ilgili
        ////Bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler. : 30 sn süresincesayfanın
        //// yüklenmesini bekle, yüklenmezse hata ver.
        //// Eğer 2 sn yüklenirse 20 sn beklemez.
        driver.manage().timeouts().implicitlyWait(dr); //Bütün web elementlerin element bazında
        // elemente özel işlem yapılmadan önce hazır hale gelmesi için verilen mühlet (süre).
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        LoginTest();
    }

    void LoginTest(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        System.out.println("Login test started");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("burakgaznepoglu_1999@hotmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("19Burak99.");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        Assert.assertEquals(driver.getTitle(), "My Account", "Login fail");

    }

    @AfterClass(enabled = true, groups = "SmokeTest")
    public void stoppingProcess() {
        System.out.println("Stopping process is started");
        Tools.Wait(1.5);
        driver.quit();
    }
}
