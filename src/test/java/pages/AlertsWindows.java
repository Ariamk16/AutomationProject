package pages;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindows {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    public AlertsMethods alertsMethods;

    public AlertsWindows(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(this.driver);
        alertsMethods = new AlertsMethods(this.driver);
        PageFactory.initElements(this.driver, this);}

        @FindBy(xpath = "//span[text()='Alerts']")
        public WebElement alert;

    @FindBy(id = "alertButton")
    public WebElement firstAlertButtonElement;

    @FindBy(id = "timerAlertButton")
    public WebElement secondAlert;

    @FindBy(id = "confirmButton")
    public WebElement thirdAlertElement;

    @FindBy(id = "promtButton")
    public WebElement fourthAlertElement;

        public void clickAlert (){
            elementsMethods.clickJsElement(alert);
        }

        public void dealAlertProcess (){
            WebElement firstAlertButtonElement = driver.findElement(By.id("alertButton"));
            elementsMethods.clickJsElement(firstAlertButtonElement);
            alertsMethods.acceptAlert();

            WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
            elementsMethods.clickJsElement(secondAlert);
            alertsMethods.acceptAlert();

            WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
            elementsMethods.clickJsElement(thirdAlertElement);

            boolean chooseAccept = true;  // pune false daca vrei Cancel
            alertsMethods.acceptAlert(chooseAccept);

            WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
            String actualText = textThirdAlert.getText();
            alertsMethods.verifyConfirmAlert(actualText, true);

            //Tema folosim un if pt cele doua cazuri de accept si cancel

            // Aici poți alege să accepți sau să dai cancel
//        boolean acceptAlert = false; // ↩️ Schimbă în true dacă vrei să testezi accept
//
//        if (acceptAlert) {
//            thirdAlert.accept();
//        } else {
//            thirdAlert.dismiss();
//        }
//
//        WebElement textConfirmationThird = driver.findElement(By.id("confirmResult"));
//        String actualText = textConfirmationThird.getText();
//
//        if (acceptAlert) {
//            String expectedText = "You selected Ok";
//            Assert.assertEquals(actualText, expectedText);
//        } else {
//            String expectedText = "You selected Cancel";
//            Assert.assertEquals(actualText, expectedText);

            WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
            elementsMethods.clickJsElement(fourthAlertElement);
            alertsMethods.fillAlert("Mery");


            //wait explicit

//        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(40));
//        waitExplicit.until(ExpectedConditions.alertIsPresent());

        }
    }
