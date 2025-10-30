package helpMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsMethods {

    public WebDriver driver;

    public AlertsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void fillAlert(String text){
        waitForAlert();
        Alert fourthAlert = driver.switchTo().alert();
        fourthAlert.sendKeys(text);
        fourthAlert.accept();
    }

    public void waitForAlert(){
        WebDriverWait waitExplicit=new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitForAlert();
        Alert secondAlertElement = driver.switchTo().alert();
        secondAlertElement.accept();
    }

    public void dismissAlert(){
        waitForAlert();
        Alert secondAlertElement = driver.switchTo().alert();
        secondAlertElement.dismiss();
    }

    public void verifyConfirmAlert(String actualText, boolean chooseAccept){
        if (chooseAccept) {
            Assert.assertEquals(actualText, "You selected Ok");
            System.out.println("User selected OK");
        } else  {
            Assert.assertEquals(actualText, "You selected Cancel");
            System.out.println("User selected Cancel");
        }
    }

    public void acceptAlert(boolean chooseAccept){
        Alert thirdAlert = driver.switchTo().alert();
        if(chooseAccept) {
            thirdAlert.accept();
        } else {
            thirdAlert.dismiss();
        }
    }
}
