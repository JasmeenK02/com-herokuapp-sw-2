package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 */

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “tomsmith” username
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.tagName("button")).click();
        //Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.tagName("h2")).getText();
      //  Assert.assertEquals("secure area text not correct", expectedText,actualText);
        Assert.assertEquals("secure area text not correct", expectedText,actualText);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter “tomsmith1” username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.tagName("button")).click();
        //Verify the error message “Your username is invalid!”
        String expectedMessage = "Your username is invalid!" + "×";
        String actualMessage = driver.findElement(By.xpath("//div[1]/div/div")).getText();
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        //Click on ‘LOGIN’ button
        driver.findElement(By.tagName("button")).click();
        //Verify the error message “Your username is invalid!”
        String expectedMessage = "Your username is invalid!" + "×";
        String actualMessage = driver.findElement(By.xpath("//div[1]/div/div")).getText();
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
