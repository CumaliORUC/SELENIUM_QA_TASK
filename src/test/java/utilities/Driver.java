package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Driver {

    private Driver(){
        // Singleton pattern ile bu class'dan obje olusturulabilmesini engellemek icin
        // Constructor'i gorunur yapip, kimsenin erisememesi icin private isaretliyoruz
    }

    public static WebDriver driver;
    public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");

        if (driver == null){
            switch (browser){
                case "safari" :
                    driver = new SafariDriver();
                    break;
                case "edge" :
                    driver = new EdgeDriver();
                    break;
                case "firefox" :
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
    @AfterClass
    public static void quitDriver(){
        driver.quit();
        driver=null;

    }
}