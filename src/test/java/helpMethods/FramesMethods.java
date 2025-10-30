package helpMethods;

import org.openqa.selenium.WebDriver;

public class FramesMethods {

    public WebDriver driver;

    public FramesMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificFrame (String frame) {
        driver.switchTo().frame(frame);
    }

    public void switchToParent (){
        driver.switchTo().parentFrame();
    }
}
