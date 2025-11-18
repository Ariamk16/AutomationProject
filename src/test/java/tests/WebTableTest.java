package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.WebTablesPage;
import sharedData.SharedData;

import java.util.List;

public class WebTableTest extends SharedData {

    ElementsMethods elementsMethods;

    @Test
    public void metodaTest () {

        elementsMethods = new ElementsMethods(driver);

        WebElement elementButtonMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMethods.clickJsElement(elementButtonMenu);

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickWebTable();

        WebTablesPage webTablePage = new WebTablesPage(driver);
        webTablePage.createProcess();
        webTablePage.editProcess();
        webTablePage.deleteProcess();

    }

    //practice forms acasa
}
