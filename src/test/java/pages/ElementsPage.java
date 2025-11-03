
package pages;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {

    public WebDriver driver;
    public ElementsMethods elementsMethods;


    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.elementsMethods = new ElementsMethods(driver);}

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement elementsPage;

    public void clickWebTable (){
        elementsMethods.clickJsElement(elementsPage);
    }
}


