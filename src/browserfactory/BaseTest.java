package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Create the package ‘browserfactory’ and
 * create the class with the name ‘BaseTest’ inside the ‘browserfactory’ package.
 * And write the browser setup code inside the class ‘Base Test’.
 */
public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseurl) {
        driver = new ChromeDriver(); //Launch the Chrome Browser
        driver.get(baseurl); // Open the Url into the Browser
        driver.manage().window().maximize(); // Maximize the Browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait to Driver
    }
}
