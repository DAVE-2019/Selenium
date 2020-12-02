package test;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetAttribute {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver2.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void useOfGetAttribute(){
        driver.get("https://accounts.google.com/signup");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement firstnameBox = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstnameBox.sendKeys("Sayandev");

//
        WebElement lastnameBox = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastnameBox.sendKeys("Roy");
//
        WebElement emailBox = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        emailBox.sendKeys("sayandev.roy");
//
        WebElement passwordBox = driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input"));
        passwordBox.sendKeys("sayandev1234");
//
        WebElement confirmPasswordBox = driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input"));
        confirmPasswordBox.sendKeys("sayandev1234");

        WebElement signUpBtn = driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button"));
        String fnameValid = firstnameBox.getAttribute("value");
        String LnameValid = lastnameBox.getAttribute("value");
        String mailValid = emailBox.getAttribute("value");

        if((fnameValid.equalsIgnoreCase("Sayandev"))&&(LnameValid.equalsIgnoreCase("roy"))){
            signUpBtn.click();
        }

    }




    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
