package pages;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import helpMethods.FramesMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public AlertsMethods alertsMethods;
    public FramesMethods framesMethods;
    public TabMethods tabMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        alertsMethods = new AlertsMethods(this.driver);
        framesMethods = new FramesMethods(this.driver);
        tabMethods = new TabMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }


}
