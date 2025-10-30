package helpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsMethods {

    public WebDriver driver;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element){
        waitVisibleElement(element);
        element.click();
    }

    public void fillElement(WebElement element, String text){
        element.sendKeys(text);
    }

    public void waitVisibleElement (WebElement element) {
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(40));
        waitExplicit.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickJsElement (WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}

//de facut clasele cu metode din elementsMethods = refactoring
//incercam sa urcam pe gitlab