package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.WebTablesPage;
import sharedData.SharedData;
public class WebTableTest extends SharedData {

    ElementsMethods elementsMethods;

    @Test
    public void metodaTest () {

        elementsMethods = new ElementsMethods(getDriver());

        WebElement elementButtonMenu = (getDriver()).findElement(By.xpath("//h5[text()='Elements']"));
        elementsMethods.clickJsElement(elementButtonMenu);

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        WebTablesPage webTablePage = new WebTablesPage(getDriver());
        webTablePage.createProcess();
        webTablePage.editProcess();
        webTablePage.deleteProcess();

    }

}
