package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeForms {

    public WebDriver driver;

    @Test
    public void metodaTest() {
        //deschidem un browser
        driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //accesam un URL

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebElement formsButtonMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        js.executeScript("arguments[0].click();", formsButtonMenu);

        WebElement practiceFormbutton = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        js.executeScript("arguments[0].click();", practiceFormbutton);

        WebElement FirstNameElement = driver.findElement(By.id("firstName"));
        String firstName = "Maria";
        FirstNameElement.sendKeys(firstName);

        WebElement LastNameElement = driver.findElement(By.id("lastName"));
        String lastName = "Aldea";
        LastNameElement.sendKeys(lastName);

        WebElement EmailElement = driver.findElement(By.id("userEmail"));
        String email = "maria.aldea08@gmail.com";
        EmailElement.sendKeys(email);

        WebElement mobileElement = driver.findElement(By.id("userNumber"));
        String mobile = "0760786595";
        mobileElement.sendKeys(mobile);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        String address = "Drumul Valea Cricovului";
        currentAddress.sendKeys(address);

        //type radio sunt notate checkboxurile
        //xpath pt lista de checkboxuri //input[@name='gender']

        List<WebElement> genderOptionsList = driver.findElements(By.xpath("//input[@name='gender']"));
        String genderValue = "Female";

        switch (genderValue) {
            case "Male":
                js.executeScript("arguments[0].click();", genderOptionsList.get(0));
                break;
            case "Female":
                js.executeScript("arguments[0].click();", genderOptionsList.get(1));
                break;
            case "Other":
                js.executeScript("arguments[0].click();", genderOptionsList.get(2));
                break;

        }

        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
//        String subjectValue = "Accounting";
//        subjectElement.sendKeys(subjectValue);
//        subjectElement.sendKeys(Keys.ENTER);

        List<String> subjectsElements = Arrays.asList("Accounting", "Maths", "English");

        for (int index = 0; index < subjectsElements.size(); index++) {
            subjectElement.sendKeys(subjectsElements.get(index));
            subjectElement.sendKeys(Keys.ENTER);

        }


            List<String> hobbiesElements = Arrays.asList("Sports","Reading","Music");
            List<WebElement> hobbiesCheckList = driver.findElements(By.xpath("//input[@type='checkbox']"));
            for (int index=0;index<hobbiesElements.size();index++){
                js.executeScript("arguments[0].click();", hobbiesCheckList.get(index));
            }

            WebElement photoElementField = driver.findElement(By.id("uploadPicture"));
            photoElementField.sendKeys("C:\\Users\\maria\\IdeaProjects\\AutomationTesting\\src\\test\\resources\\new upload.txt");


        WebElement stateField = driver.findElement(By.xpath("//div[text()='Select State']"));
        js.executeScript("arguments[0].click();", stateField);

        WebElement stateElementInput = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        stateElementInput.sendKeys(stateValue);
        stateElementInput.sendKeys(Keys.ENTER);

        //date of birth interaction

        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        js.executeScript("arguments[0].click();", dateOfBirthInput);

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        Select selectMonth = new Select(monthElement);
        String monthValue = "August";
        selectMonth.selectByVisibleText(monthValue);

        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectYear = new Select(yearDropdown);
        String yearValue = "1994";
        selectYear.selectByVisibleText(yearValue);

        String dayValue = "16";
        List<WebElement> daysList = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))]"));
        for (int index = 0; index < daysList.size(); index++){
            if (daysList.get(index).getText().equals(dayValue)){
                daysList.get(index).click();
                break;
            }
        }

        WebElement cityField = driver.findElement(By.xpath("//div[text()='Select City']"));
        js.executeScript("arguments[0].click();", cityField);

        WebElement cityElementInput = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Delhi";
        cityElementInput.sendKeys(cityValue);
        cityElementInput.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitElement);

        WebElement messageElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(messageElement.getText(), "Thanks for submitting the form");

        List <WebElement> labelList = driver.findElements(By.xpath("//table[@class ='table table-dark table-striped table-bordered table-hover']//td[1]"));

        Assert.assertEquals(labelList.get(0).getText(), "Student Name");
        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
        Assert.assertEquals(labelList.get(2).getText(), "Gender");
        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
        Assert.assertEquals(labelList.get(7).getText(), "Picture");
        Assert.assertEquals(labelList.get(8).getText(), "Address");
        Assert.assertEquals(labelList.get(9).getText(), "State and City");

        List <WebElement> valueList = driver.findElements(By.xpath("//table[@class ='table table-dark table-striped table-bordered table-hover']//td[2]"));

        Assert.assertEquals(valueList.get(0).getText(), firstName + " " + lastName);
        Assert.assertEquals(valueList.get(1).getText(), email);
        Assert.assertEquals(valueList.get(2).getText(), genderValue);
        Assert.assertEquals(valueList.get(3).getText(), mobile);

//Tema 1

        Assert.assertEquals(valueList.get(4).getText(), "16 August,1994");
        Assert.assertEquals(valueList.get(5).getText(), String.join(", ", subjectsElements));
        Assert.assertEquals(valueList.get(6).getText(), String.join(", ", hobbiesElements));
        Assert.assertEquals(valueList.get(7).getText(), "new upload.txt");
        Assert.assertEquals(valueList.get(8).getText(), address);
        Assert.assertEquals(valueList.get(9).getText(), stateValue + " " + cityValue);


    }
}
