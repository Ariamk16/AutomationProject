package tests;

import helpMethods.ElementsMethods;
import helpMethods.FramesMethods;
import org.testng.annotations.Test;
import pages.Frames1;
import pages.HomePage;
import sharedData.SharedData;

public class Frames extends SharedData {
    ElementsMethods elementsMethods;
    FramesMethods framesMethods;

    @Test
    public void metodaTest() {

        elementsMethods = new ElementsMethods(getDriver());
        framesMethods = new FramesMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

//        WebElement framesButton = driver.findElement(By.xpath("//span[text()='Frames']"));
//        elementsMethods.clickJsElement(framesButton);

        Frames1 frames = new Frames1(getDriver());
        frames.clickFramesButton();

        frames.switchFrames("frame1", "frame2");
    }
}