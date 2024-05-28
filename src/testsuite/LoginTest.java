package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
/*
Create the package ‘testsuite’ and create the
following class inside the ‘testsuite’ package.
1. LoginTest
 */
public class LoginTest extends BaseTest {
    String baseUrl =  "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    //1. User Should Login Successfully With Valid Credentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("button")).click();
        String actualArea = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Secure Area", actualArea);
    }
//2. Verify The Username Error Message
    @Test
    public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("button")).click();
        String expectedMessage = "Your username is invalid!";
        String actualMessage = "Your username is invalid!";
        driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
//3. Verify The Password Error Message
    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.tagName("button")).click();
        String expectedMessage = "Your password is invalid!";
        String actualMessage = "Your password is invalid!";
        driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @After
    public void closeBrowser() {
    }
}
