package tests;

import helpMethods.ElementsMethods;
import helpMethods.FramesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;
    ElementsMethods elementsMethods;
    FramesMethods framesMethods;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);

        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethods.clickJsElement(alertMeniu);

        WebElement framesButton = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementsMethods.clickJsElement(framesButton);

        framesMethods.switchToSpecificFrame("frame1");

        framesMethods.switchToParent();

        framesMethods.switchToSpecificFrame("frame2");
    }
}