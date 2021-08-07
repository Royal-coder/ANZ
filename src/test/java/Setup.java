import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Console;
import java.util.Iterator;
import java.util.Set;

public class Setup
{

    public static WebDriver driver;
    public static WebDriverWait wait1;
    public static String url = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/";
    public static void before()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver_V78.0.3904.105\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
        public static void after()
    {
            driver.quit();

    }
}
