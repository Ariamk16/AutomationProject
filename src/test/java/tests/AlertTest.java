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

        WebElement firstAlertButtonElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickJsElement(firstAlertButtonElement);
        alertsMethods.acceptAlert();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickJsElement(secondAlert);
        alertsMethods.acceptAlert();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.clickJsElement(thirdAlertElement);

        boolean chooseAccept = true;  // pune false daca vrei Cancel
        alertsMethods.acceptAlert(chooseAccept);

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();
        alertsMethods.verifyConfirmAlert(actualText, true);

        //Tema folosim un if pt cele doua cazuri de accept si cancel

        // Aici poți alege să accepți sau să dai cancel
//        boolean acceptAlert = false; // ↩️ Schimbă în true dacă vrei să testezi accept
//
//        if (acceptAlert) {
//            thirdAlert.accept();
//        } else {
//            thirdAlert.dismiss();
//        }
//
//        WebElement textConfirmationThird = driver.findElement(By.id("confirmResult"));
//        String actualText = textConfirmationThird.getText();
//
//        if (acceptAlert) {
//            String expectedText = "You selected Ok";
//            Assert.assertEquals(actualText, expectedText);
//        } else {
//            String expectedText = "You selected Cancel";
//            Assert.assertEquals(actualText, expectedText);

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethods.clickJsElement(fourthAlertElement);
        alertsMethods.fillAlert("Mery");


        //wait explicit

//        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(40));
//        waitExplicit.until(ExpectedConditions.alertIsPresent());


        }
    }