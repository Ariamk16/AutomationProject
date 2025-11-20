package tests;

import helpMethods.ElementsMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;


public class TabWindowTest extends SharedData {

    ElementsMethods elementsMethods;
    TabMethods tabMethods;

    @Test
    public void metodaTest() {
        JavascriptExecutor js = (JavascriptExecutor) (getDriver());


        elementsMethods = new ElementsMethods(getDriver());
        tabMethods = new TabMethods(getDriver());

//        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        js.executeScript("arguments[0].click();", alertMeniu);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

//        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
//        js.executeScript("arguments[0].click();", tabButton);

        WebElement tabButton1 = (getDriver()).findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethods.clickJsElement(tabButton1);

        WebElement tabButtonElement = (getDriver()).findElement(By.id("tabButton"));
        js.executeScript("arguments[0].click();", tabButtonElement);

        System.out.println("URL-ul paginii curente este: " + (getDriver()).getCurrentUrl());

//        List <String> tabsList = new ArrayList<>(driver.getWindowHandles()); //returneaza toate taburile pana cand testul ajunge la linia asta
//
//        driver.switchTo().window(tabsList.get(1));

        tabMethods.switchSpecificTab(1);

//        System.out.println("URL-ul paginii curente este: " + driver.getCurrentUrl());

//        driver.close();
        tabMethods.closeCurrentTab();

        tabMethods.switchSpecificTab(0);

        WebElement newWindow = (getDriver()).findElement(By.id("windowButton"));
        elementsMethods.clickJsElement(newWindow);

        tabMethods.switchSpecificTab(1);

        (getDriver()).quit();
    }
}
