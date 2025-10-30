package pages;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertFrameWindowsMenu;

    public void clickAlertFrameWindow (){
        elementsMethods.clickJsElement(alertFrameWindowsMenu);
    }
}
