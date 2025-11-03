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

import java.util.List;

public class WebTableTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest () {
        //deschidem un browser
        driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor)driver;


        //accesam un URL

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);

        WebElement elementButtonMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMethods.clickJsElement(elementButtonMenu);

//        WebElement webTablesbutton = driver.findElement(By.xpath("//span[text()='Web Tables']"));
//        elementsMethods.clickJsElement(webTablesbutton);
        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickWebTable();

        WebTablesPage webTablePage = new WebTablesPage(driver);
        webTablePage.createProcess();
        webTablePage.editProcess();
        webTablePage.deleteProcess();

//create process
//        //CTRL + F pt deschidere search consola si pt xpath relative //h5[text()='Elements']
//
//        //conditie ca dimensiunea tabelului e de 3 randuri
//        List<WebElement> continutTabel = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
////        System.out.println("Dimensiunea tabelului este: " + continutTabel.size());
//
//        Assert.assertEquals(continutTabel.size(), 3, "Marimes tabelului nu este 3.");
//
//        //declaram un element
//        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
//        elementsMethods.clickJsElement(addElement);
//
//        WebElement FirstNameElement = driver.findElement(By.id("firstName"));
//        String firstName = "Maria";
//        elementsMethods.fillElement(FirstNameElement, firstName);
//
//        WebElement LastNameElement = driver.findElement(By.id("lastName"));
//        String lastName = "Aldea";
//        elementsMethods.fillElement(LastNameElement, lastName);
//
//        WebElement EmailElement = driver.findElement(By.id("userEmail"));
//        String email = "maria.aldea08@gmail.com";
//        elementsMethods.fillElement(EmailElement, email);
//
//        WebElement AgeElement = driver.findElement(By.id("age"));
//        String age = "31";
//        elementsMethods.fillElement(AgeElement, age);
//
//        WebElement SalaryElement = driver.findElement(By.id("salary"));
//        String salary = "5000";
//        elementsMethods.fillElement(SalaryElement, salary);
//
//        WebElement DepartmentElement = driver.findElement(By.id("department"));
//        String department = "Direct Debit";
//        elementsMethods.fillElement(DepartmentElement, department);
//
//        WebElement submitButtonElement = driver.findElement(By.id("submit"));
//        elementsMethods.clickJsElement(submitButtonElement);


//        //validam noua dimensiune a tabelului
//        List<WebElement> continutTabelNou = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
////        System.out.println("Dimensiunea tabelului este: " + continutTabel.size());
//
//        Assert.assertEquals(continutTabelNou.size(), 4, "Marimes tabelului nu este 4.");
//
//        //validam valorile pe care le-am introdus
//        String continutRand = continutTabelNou.get(3).getText();
//        Assert.assertTrue(continutRand.contains(firstName), "Randul nu contine first name valid.");
//        Assert.assertTrue(continutRand.contains(lastName), "Randul nu contine last name valid.");
//        Assert.assertTrue(continutRand.contains(email), "Randul nu contine email valid.");
//        Assert.assertTrue(continutRand.contains(age), "Randul nu contine age valid.");
//        Assert.assertTrue(continutRand.contains(salary), "Randul nu contine salary valid.");
//        Assert.assertTrue(continutRand.contains(department), "Randul nu contine department valid.");


        //edit functionality

//        WebElement editButtonElement = driver.findElement(By.id("edit-record-4"));
//        elementsMethods.clickJsElement(editButtonElement);
//
//        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
//        String nume2 = "Richard";
//        editFirstNameElement.clear();
//        editFirstNameElement.sendKeys(nume2);
//
//        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
//        String nume3 = "Smith";
//        editLastNameElement.clear();
//        editLastNameElement.sendKeys(nume3);
//
//        WebElement editEmail = driver.findElement(By.id("userEmail"));
//        String email2 = "richard.sm@gmail.com";
//        editEmail.clear();
//        editEmail.sendKeys(email2);
//
//        WebElement editAge = driver.findElement(By.id("age"));
//        String age2 = "33";
//        editAge.clear();
//        editAge.sendKeys(age2);
//
//        WebElement submitButton2Element = driver.findElement(By.id("submit"));
//        submitButton2Element.click();


        //delete functionality

//        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
//        elementsMethods.clickJsElement(deleteElement);
//
//        List<WebElement> continutTabelNou2 = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
//        Assert.assertEquals(continutTabelNou2.size(), 3, "Marimes tabelului nu este 3.");
      //  driver.close();

    }
}
