package test;


import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoTest {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void demo(){


        //open the web app
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

        List<WebElement> dropdown_list =  driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//*"));

    }





    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
