package pages;

import helpMethods.ElementsMethods;
import helpMethods.FramesMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames1 {

    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public FramesMethods framesMethods;

    public Frames1(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        framesMethods = new FramesMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesButton;

    public void clickFramesButton (){
        elementsMethods.clickJsElement(framesButton);
    }

    public void switchFrames (String frame1, String frame2){
        framesMethods.switchToSpecificFrame("frame1");

        framesMethods.switchToParent();

        framesMethods.switchToSpecificFrame("frame2");
    }
}

