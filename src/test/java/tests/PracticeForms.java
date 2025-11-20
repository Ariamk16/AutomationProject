package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.util.Arrays;
import java.util.List;

public class PracticeForms extends SharedData {

    ElementsMethods elementsMethods;

    @Test
    public void metodaTest() {

        JavascriptExecutor js = (JavascriptExecutor)(getDriver());;

        elementsMethods = new ElementsMethods(getDriver());

        WebElement formsButtonMenu = (getDriver()).findElement(By.xpath("//h5[text()='Forms']"));
        elementsMethods.clickJsElement(formsButtonMenu);

        WebElement practiceFormbutton = (getDriver()).findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethods.clickJsElement(practiceFormbutton);

        WebElement FirstNameElement = (getDriver()).findElement(By.id("firstName"));
        elementsMethods.fillElement(FirstNameElement, "Maria");

        WebElement LastNameElement = (getDriver()).findElement(By.id("lastName"));
        elementsMethods.fillElement(LastNameElement, "Aldea");

        WebElement EmailElement = (getDriver()).findElement(By.id("userEmail"));
        elementsMethods.fillElement(EmailElement, "maria.aldea08@gmail.com");

        WebElement mobileElement = (getDriver()).findElement(By.id("userNumber"));
        elementsMethods.fillElement(mobileElement, "0760786595");

        WebElement currentAddress = (getDriver()).findElement(By.id("currentAddress"));
        elementsMethods.fillElement(currentAddress, "Drumul Valea Cricovului");

        //type radio sunt notate checkboxurile
        //xpath pt lista de checkboxuri //input[@name='gender']

        List<WebElement> genderOptionsList = (getDriver()).findElements(By.xpath("//input[@name='gender']"));
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

        WebElement subjectElement = (getDriver()).findElement(By.id("subjectsInput"));
//        String subjectValue = "Accounting";
//        subjectElement.sendKeys(subjectValue);
//        subjectElement.sendKeys(Keys.ENTER);

        List<String> subjectsElements = Arrays.asList("Accounting", "Maths", "English");

        for (int index = 0; index < subjectsElements.size(); index++) {
            subjectElement.sendKeys(subjectsElements.get(index));
            subjectElement.sendKeys(Keys.ENTER);

        }


            List<String> hobbiesElements = Arrays.asList("Sports","Reading","Music");
            List<WebElement> hobbiesCheckList = (getDriver()).findElements(By.xpath("//input[@type='checkbox']"));
            for (int index=0;index<hobbiesElements.size();index++){
                js.executeScript("arguments[0].click();", hobbiesCheckList.get(index));
            }

            WebElement photoElementField = (getDriver()).findElement(By.id("uploadPicture"));
            photoElementField.sendKeys("C:\\Users\\maria\\IdeaProjects\\AutomationTesting\\src\\test\\resources\\new upload.txt");


        WebElement stateField = (getDriver()).findElement(By.xpath("//div[text()='Select State']"));
        elementsMethods.clickJsElement(stateField);

        WebElement stateElementInput = (getDriver()).findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        stateElementInput.sendKeys(stateValue);
        stateElementInput.sendKeys(Keys.ENTER);

        //date of birth interaction

        WebElement dateOfBirthInput = (getDriver()).findElement(By.id("dateOfBirthInput"));
        elementsMethods.clickJsElement(dateOfBirthInput);

        WebElement monthElement = (getDriver()).findElement(By.className("react-datepicker__month-select"));
        elementsMethods.selectDropDownElement(monthElement, "August");

        WebElement yearDropdown = (getDriver()).findElement(By.className("react-datepicker__year-select"));
        elementsMethods.selectDropDownElement(yearDropdown, "1994");

        String dayValue = "16";
        List<WebElement> daysList = (getDriver()).findElements(By.xpath("//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))]"));
        for (int index = 0; index < daysList.size(); index++){
            if (daysList.get(index).getText().equals(dayValue)){
                daysList.get(index).click();
                break;
            }
        }

        WebElement cityField = (getDriver()).findElement(By.xpath("//div[text()='Select City']"));
        elementsMethods.clickJsElement(cityField);

        WebElement cityElementInput = (getDriver()).findElement(By.id("react-select-4-input"));
        String cityValue = "Delhi";
        cityElementInput.sendKeys(cityValue);
        cityElementInput.sendKeys(Keys.ENTER);

        WebElement submitElement = (getDriver()).findElement(By.id("submit"));
        elementsMethods.clickJsElement(submitElement);

        WebElement messageElement = (getDriver()).findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(messageElement.getText(), "Thanks for submitting the form");

        List <WebElement> labelList = (getDriver()).findElements(By.xpath("//table[@class ='table table-dark table-striped table-bordered table-hover']//td[1]"));

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

        List <WebElement> valueList = (getDriver()).findElements(By.xpath("//table[@class ='table table-dark table-striped table-bordered table-hover']//td[2]"));

//        Assert.assertEquals(valueList.get(0).getText(), firstName + " " + lastName);
//        Assert.assertEquals(valueList.get(1).getText(), email);
//        Assert.assertEquals(valueList.get(2).getText(), genderValue);
//        Assert.assertEquals(valueList.get(3).getText(), mobile);

//Tema 1

//        Assert.assertEquals(valueList.get(4).getText(), "16 August,1994");
//        Assert.assertEquals(valueList.get(5).getText(), String.join(", ", subjectsElements));
//        Assert.assertEquals(valueList.get(6).getText(), String.join(", ", hobbiesElements));
//        Assert.assertEquals(valueList.get(7).getText(), "new upload.txt");
//        Assert.assertEquals(valueList.get(8).getText(), address);
//        Assert.assertEquals(valueList.get(9).getText(), stateValue + " " + cityValue);


    }
}
