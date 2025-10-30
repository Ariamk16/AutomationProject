package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {
        //deschidem un browser
        driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //accesam un URL

        driver.get("https://demoqa.com/");
        //wait iplicit vegheaza asupra codului
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        js.executeScript("arguments[0].click();", alertMeniu);

        WebElement alertsButton = driver.findElement(By.xpath("//span[text()='Alerts']"));
        js.executeScript("arguments[0].click();", alertsButton);

        WebElement firstAlertButtonElement = driver.findElement(By.id("alertButton"));
        js.executeScript("arguments[0].click();", firstAlertButtonElement);

        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        js.executeScript("arguments[0].click();", thirdAlertElement);
        Alert thirdAlert = driver.switchTo().alert();
        thirdAlert.dismiss();

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
        js.executeScript("arguments[0].click();", fourthAlertElement);
        Alert fourthAlert = driver.switchTo().alert();
        fourthAlert.sendKeys("Mery");
        fourthAlert.accept();

        WebElement textConfirmationThird = driver.findElement(By.id("confirmResult"));
        String expectedText = "You selected Cancel";
        Assert.assertEquals(textConfirmationThird.getText(), expectedText);

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        js.executeScript("arguments[0].click();", secondAlert);

        //wait explicit

        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(40));
        waitExplicit.until(ExpectedConditions.alertIsPresent());

        Alert secondAlertElement = driver.switchTo().alert();
        System.out.println(secondAlertElement.getText());
        secondAlertElement.accept();
        }
    }