package org.example.testing;


import org.example.pomp.FormPom;
import org.example.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class form_test {

    public WebDriver driver;
    public static String Url="https://demoqa.com/";
    static  public  String FIRSTNAME = "Arina";
    static  public  String LASTNAME = "Pervaniuc";
    static  public  String Email = "pervuncukarina@gmail.com";
    static  public  String GENDER = "Female";
    static  public  String TELETHONE="1234567891";
    static  public  String DATE="29 Apr 2006";
    static  public  String SUBJECTS="Maths";
    static  public  String STATE="NCR";
    static  public  String CITY="Delhi";
    static public  String HOBBY ="Music";


    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {

        driver = Driver.getRemoteDriver();

        if (driver != null) {
            driver.manage().window().maximize();
        }
    }

    @Test
    public void formTest(){
        System.out.println("Старт тест");

        driver.get(Url);
        FormPom form = new FormPom(driver);
        form.clickFroms();
        form.pause(3000);
        form.clickPracticeForm();
        form.pause(2000);
        form.setFirstName(FIRSTNAME);
        form.setLastName(LASTNAME);
        form.setUserEmail(Email);
        form.setGenter(GENDER);
        form.setNumber(TELETHONE);
        form.setBitrh(DATE);
        form.setSubjects(SUBJECTS);
        form.setState(STATE);
        form.setCity(CITY);
        form.set_hobbies(HOBBY);
        form.clickSubmit();
        String actualName= form.getTableDataByLabel("Student Name");
        Assert.assertEquals(actualName,FIRSTNAME +" "+LASTNAME);
        String actualEmail = form.getTableDataByLabel("Student Email");
        Assert.assertEquals(actualEmail, Email);
        String actualGender = form.getTableDataByLabel("Gender");
        Assert.assertEquals(actualGender, GENDER);
        String actualPhone = form.getTableDataByLabel("Mobile");
        Assert.assertEquals(actualPhone, TELETHONE);
        String actualDate = form.getTableDataByLabel("Date of Birth");
        Assert.assertEquals(actualDate, "29 April,2006");
        String actualSubjects = form.getTableDataByLabel("Subjects");
        Assert.assertEquals(actualSubjects, SUBJECTS);
        String actualHobby = form.getTableDataByLabel("Hobbies");
        Assert.assertEquals(actualHobby, HOBBY);
        String actualStateCity = form.getTableDataByLabel("State and City");
        Assert.assertEquals(actualStateCity, STATE + " " + CITY);
        System.out.println("Все проверки пройдены успешно!");
        form.pause(3000);


        System.out.println("Конец тест");
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }
}