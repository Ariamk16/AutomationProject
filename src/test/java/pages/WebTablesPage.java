package pages;

import helpMethods.ElementsMethods;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablesPage {

    public WebDriver driver;
    ElementsMethods elementsMethods;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        elementsMethods = new ElementsMethods(this.driver);
}

@FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
public List<WebElement> tableContentList;

    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;

    @FindBy(id = "firstName")
    public  WebElement FirstNameElement;

    @FindBy(id = "lastName")
    public WebElement LastNameElement;

    @FindBy(id = "userEmail")
    public WebElement EmailElement;

    @FindBy(id = "age")
    public WebElement AgeElement;

    @FindBy(id = "salary")
    public WebElement SalaryElement;

    @FindBy(id = "department")
    public WebElement DepartmentElement;

    @FindBy(id = "submit")
    public WebElement submitButtonElement;

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    public List<WebElement> continutTabelNou;

    @FindBy(id = "age")
    public WebElement editAge;

    @FindBy(id = "\"edit-record-4\"")
    public WebElement editButtonElement;

    @FindBy(id ="\"firstName\"")
    public WebElement editFirstNameElement;

    @FindBy(id = "\"lastName\"")
    public WebElement editLastNameElement;

    @FindBy(id = "userEmail")
    public WebElement editEmail;

    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    public WebElement continutTabelNou2;

    public void createProcess(){

    //CTRL + F pt deschidere search consola si pt xpath relative //h5[text()='Elements']

    //conditie ca dimensiunea tabelului e de 3 randuri
    List<WebElement> continutTabel = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
//        System.out.println("Dimensiunea tabelului este: " + continutTabel.size());

        Assert.assertEquals(continutTabel.size(), 3, "Marimes tabelului nu este 3.");

    //declaram un element
    WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementsMethods.clickJsElement(addElement);

    WebElement FirstNameElement = driver.findElement(By.id("firstName"));
    String firstName = "Maria";
        elementsMethods.fillElement(FirstNameElement, firstName);

    WebElement LastNameElement = driver.findElement(By.id("lastName"));
    String lastName = "Aldea";
        elementsMethods.fillElement(LastNameElement, lastName);

    WebElement EmailElement = driver.findElement(By.id("userEmail"));
    String email = "maria.aldea08@gmail.com";
        elementsMethods.fillElement(EmailElement, email);

    WebElement AgeElement = driver.findElement(By.id("age"));
    String age = "31";
        elementsMethods.fillElement(AgeElement, age);

    WebElement SalaryElement = driver.findElement(By.id("salary"));
    String salary = "5000";
        elementsMethods.fillElement(SalaryElement, salary);

    WebElement DepartmentElement = driver.findElement(By.id("department"));
    String department = "Direct Debit";
        elementsMethods.fillElement(DepartmentElement, department);

    WebElement submitButtonElement = driver.findElement(By.id("submit"));
        elementsMethods.clickJsElement(submitButtonElement);
        //validam noua dimensiune a tabelului
        List<WebElement> continutTabelNou = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
//        System.out.println("Dimensiunea tabelului este: " + continutTabel.size());

        Assert.assertEquals(continutTabelNou.size(), 4, "Marimes tabelului nu este 4.");

        //validam valorile pe care le-am introdus
        String continutRand = continutTabelNou.get(3).getText();
        Assert.assertTrue(continutRand.contains(firstName), "Randul nu contine first name valid.");
        Assert.assertTrue(continutRand.contains(lastName), "Randul nu contine last name valid.");
        Assert.assertTrue(continutRand.contains(email), "Randul nu contine email valid.");
        Assert.assertTrue(continutRand.contains(age), "Randul nu contine age valid.");
        Assert.assertTrue(continutRand.contains(salary), "Randul nu contine salary valid.");
        Assert.assertTrue(continutRand.contains(department), "Randul nu contine department valid.");
    }

    public void editProcess(){
        WebElement editButtonElement = driver.findElement(By.id("edit-record-4"));
        elementsMethods.clickJsElement(editButtonElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String nume2 = "Richard";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(nume2);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String nume3 = "Smith";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(nume3);

        WebElement editEmail = driver.findElement(By.id("userEmail"));
        String email2 = "richard.sm@gmail.com";
        editEmail.clear();
        editEmail.sendKeys(email2);

        WebElement editAge = driver.findElement(By.id("age"));
        String age2 = "33";
        editAge.clear();
        editAge.sendKeys(age2);

        WebElement submitButton2Element = driver.findElement(By.id("submit"));
        submitButton2Element.click();

    }

    public void deleteProcess(){

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementsMethods.clickJsElement(deleteElement);

        List<WebElement> continutTabelNou2 = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelNou2.size(), 3, "Marimes tabelului nu este 3.");
    }
}
