package tests;

import helpMethods.ElementsMethods;
import helpMethods.FramesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Frames1;
import pages.HomePage;
import sharedData.SharedData;

public class Frames extends SharedData {
    ElementsMethods elementsMethods;
    FramesMethods framesMethods;

    @Test
    public void metodaTest() {

        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

//        WebElement framesButton = driver.findElement(By.xpath("//span[text()='Frames']"));
//        elementsMethods.clickJsElement(framesButton);

        Frames1 frames = new Frames1(driver);
        frames.clickFramesButton();

        frames.switchFrames("frame1", "frame2");
    }
}