package tests;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsWindows;
import pages.HomePage;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    AlertsMethods alertsMethods;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethods = new ElementsMethods(driver);
        alertsMethods = new AlertsMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertsWindows alertsWindows = new AlertsWindows(driver);
        alertsWindows.clickAlert();

        alertsWindows.dealAlertProcess();
    }
}