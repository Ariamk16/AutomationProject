package tests;

import helpMethods.AlertsMethods;
import helpMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.AlertsWindows;
import pages.HomePage;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    ElementsMethods elementsMethods;
    AlertsMethods alertsMethods;

    @Test
    public void metodaTest() {

        elementsMethods = new ElementsMethods(getDriver());
        alertsMethods = new AlertsMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertsWindows alertsWindows = new AlertsWindows(getDriver());
        alertsWindows.clickAlert();

        alertsWindows.dealAlertProcess();
    }
}