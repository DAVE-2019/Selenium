package test;

import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WithoutSendKeys {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void BrowserResize(){

        driver.get("http://google.com");

        JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
        myExecutor.executeScript("document.getElementsByName('q')[0].value='Infosys'");

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
