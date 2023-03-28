package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverEdge {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void startingProcess() {

        System.out.println("Starting process is started");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver");
        System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.edge.verboseLogging", "true");
        EdgeDriverService service = EdgeDriverService.createDefaultService();
        EdgeOptions options = new EdgeOptions();
        //options.addArguments("headless");
        driver = new EdgeDriver(options);

        driver.manage().window().maximize(); //Tam ekran
        driver.manage().deleteAllCookies(); //Sitenin bilgisayarda yağtığı ayarları siler
        Duration dr = Duration.ofSeconds(2);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); //Sadece tüm sayfanın kodlarının
        // bilgisayara inme süresi ile ilgili
        //Bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler. : 30 sn süresincesayfanın
        // yüklenmesini bekle, yüklenmezse hata ver.
        // Eğer 2 sn yüklenirse 20 sn beklemez.
        driver.manage().timeouts().implicitlyWait(dr); //Bütün web elementlerin element bazında
        // elemente özel işlem yapılmadan önce hazır hale gelmesi için verilen mühlet (süre).
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterClass
    public void stoppingProcess() {
        System.out.println("Stopping process is started");
        Tools.Wait(1.5);
        driver.quit();
    }
}