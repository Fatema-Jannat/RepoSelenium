package SeleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 *
 * @Fatema Jannat
 * @Selenium Homework 1 Question 1
 * @Date 06/25/2020
 */
public class Selenium_HW1_Q1 {
    /**
     * 1. Login to Facebook
     * 2. Fill below data in Sign Up form
     *      First name
     *      Last name
     *      Email-address
     *      Password(s)
     *      Click Sign Up button
     * 3. Verify Error msg : "Please choose a gender. You can change who can see this later."
     */


    @Test
    public void facebookSignup() {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        By emailLocator = By.name("email");
        By passLocator = By.id("pass");
        By fNameLocator = By.xpath("//input[@aria-label='First name']");
        By lNameLocator = By.name("lastname");
        By mobileLocator = By.xpath("//input[contains(@aria-label, 'Mobile number')]");
        By passwordLocator = By.xpath("//input[@autocomplete='new-password' or @aria-label='New password']");
        By signUpLocator = By.xpath("//button[text()='Sign Up' and @name='websubmit']");

        driver.findElement(emailLocator).sendKeys("test@email.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(passLocator).sendKeys("test1234");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(fNameLocator).sendKeys("FIRSTNAME");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.findElement(lNameLocator).sendKeys("LASTNAME");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.findElement(mobileLocator).sendKeys("1234567890");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.findElement(passwordLocator).sendKeys("test@1234");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement signUp = driver.findElement(signUpLocator);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        signUp.click();

        String pageErrorMsg = "Please choose a gender. You can change who can see this later.";

        String expectedPageErrorMsg = driver.findElement(By.xpath("//div[contains(text(), 'Please choose')]")).getText();

        Assert.assertEquals(pageErrorMsg, expectedPageErrorMsg);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.close();


    }
}
