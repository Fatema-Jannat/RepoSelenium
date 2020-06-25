package SeleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
/**
 *
 * @Fatema Jannat
 * @Selenium Homework 1 Question 1
 * @Date 06/25/2020
 */

public class Selenium_HW1_Q2 {
    /**
     * 1. Go to darksky.net
     * 2. Verify Feels-Like-temp value is in between Low-temp and High-temp
     *
     * "78˚" --> "78" --> 78
     * "4˚" --> "4" --> 4
     * "-4˚" --> "-4" --> 4
     *
     */

    @Test
    public void verifyTemp(){

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://darksky.net/forecast/40.7127,-74.0059/us12/en");
        String currentTemp = driver.findElement(By.cssSelector(".summary.swap")).getText();
        System.out.println("Current Temp:" + currentTemp);
        List<WebElement> tempsInTimeLine = driver.findElements(By.cssSelector(".temps span:last-child"));
        int temp = Integer.parseInt(currentTemp.substring(0, 2));
        int highestInTimeLine = temp;
        int lowestInTimeLine = temp;
        for (
                WebElement tempInTime : tempsInTimeLine) {
            String sLIneTemp = tempInTime.getText();
            int lineTemp = Integer.parseInt(sLIneTemp.substring(0, 2));
            if (lineTemp > highestInTimeLine) {
                highestInTimeLine = lineTemp;
            }
            if (lineTemp < lowestInTimeLine) {
                lowestInTimeLine = lineTemp;
            }

        }

        System.out.println("Highest Temp:" + Integer.toString(highestInTimeLine));
        System.out.println("Lowest Temp:" + Integer.toString(lowestInTimeLine));
    }
}
