package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD{

    private static WebDriver driver;
    public static WebDriver getDriver()
    {
        if (driver==null) { // her çağrıldığında yeni driver oluşturmaması için if kullanıldı.

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // firefox
           // WebDriverManager.firefoxdriver().setup();
           // driver=new FirefoxDriver();
        }

        return driver;
    }
    public static void quitDriver()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(driver!=null) { // driver varsa
            driver.quit();
            driver=null;
        }
    }
}