package pages;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames1 {

    public WebDriver driver;
    public ElementsMethods elementsMethods;

    public Frames1(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesButton;

    public void clickFramesButton (){
        elementsMethods.clickJsElement(framesButton);
    }
}

