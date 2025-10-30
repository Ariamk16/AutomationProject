package pages;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindows {

    public WebDriver driver;
    ElementsMethods elementsMethods;

    public AlertsWindows(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        PageFactory.initElements(this.driver, this);}

        @FindBy(xpath = "//span[text()='Alerts']")
        public WebElement alert;

        public void clickAlert (){
            elementsMethods.clickJsElement(alert);
        }
    }
