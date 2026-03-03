package org.example.pomp;

import org.example.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPom {


    public WebDriver driver;

    @FindBy(xpath="//*[text()='Forms']")
    WebElement forms;

    @FindBy(xpath="//*[text()='Practice Form']")
    WebElement practiceForms;

    @FindBy(xpath="//*[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath="//*[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath="//*[@id='userEmail']")
    WebElement email;
    @FindBy(xpath="//*[@id='userNumber']")
    WebElement userNumber;
    @FindBy(xpath="//*[@id='dateOfBirthInput']")
    WebElement bitrh;
    @FindBy(xpath="//*[@id='subjectsInput']")
    WebElement subjects;
    WebElement hobbies;
    @FindBy(xpath="//*[@id='state']")
    WebElement state;
    @FindBy(xpath="//*[@id='city']")
    WebElement city;
    @FindBy(xpath="//*[@id='submit']")
    WebElement submit;


    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.visibilityOf(submit));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", submit);


        submit.click();
    }

    public void set_hobbies(String hobby) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement hobbyLabel = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(), '" + hobby + "')]")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", hobbyLabel);


        hobbyLabel.click();
    }
    public void setState(String state_p) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("state")));


        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", state);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", state);


        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-3-input")));

        input.sendKeys(state_p);
        input.sendKeys(Keys.ENTER);
    }
    public void setCity(String city_p){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(city)).click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='"+city_p+"']")
        ));

        option.click();
    }

    public  void setNumber(String number){
    userNumber.clear();
    userNumber.sendKeys(number);

   }
    public  void setBitrh(String date){

        bitrh.sendKeys(Keys.CONTROL,"a");
        bitrh.sendKeys(date);
        bitrh.sendKeys(Keys.ENTER);

    }

    public  void setSubjects(String subject){

        subjects.sendKeys(subject);
        subjects.sendKeys(Keys.ENTER);

    }

    public FormPom(WebDriver driverPom){
        this.driver = driverPom;
        PageFactory.initElements(driver, this);
    }

    public void clickFroms(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", forms);
    }

    public void pause(int ms){
        try {

            Thread.sleep(ms);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public  void setGenter(String genderValue){
        WebElement genderElement = driver.findElement(By.xpath("//*[@id='genterWrapper']//label[text()='" + genderValue + "']"));
        genderElement.click();
    }

    public void clickPracticeForm(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", practiceForms);
    }

    public void setFirstName(String first_name){
        firstName.clear();
        firstName.sendKeys(first_name);
    }

    public void setLastName(String last_name){
        lastName.clear();
        lastName.sendKeys(last_name);
    }

    public void setUserEmail(String emailValue){
        email.clear();
        email.sendKeys(emailValue);
    }
    public String getTableDataByLabel(String labelParam) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        String xpath = "//td[text()='" + labelParam + "']/following-sibling::td";

        WebElement valueElement = driver.findElement(By.xpath(xpath));

        return valueElement.getText();
    }
}