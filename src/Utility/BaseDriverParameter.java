package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {

    public WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void startingProcess(String browser) {
        System.out.println("Starting process is started");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setAcceptInsecureCerts(true);
            //options.setHeadless(true);
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver");
            System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.edge.verboseLogging", "true");
            //EdgeDriverService service = EdgeDriverService.createDefaultService();
            EdgeOptions options = new EdgeOptions();
            //options.addArguments("headless");
            driver = new EdgeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Duration dr = Duration.ofSeconds(3);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

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

    @AfterClass
    public void stoppingProcess() {
        System.out.println("Stopping process is started");
        Tools.Wait(1.5);
        driver.quit();
    }
}
