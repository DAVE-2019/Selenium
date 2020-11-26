package test;

import org.junit.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BrowserWindowSize {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void BrowserResize(){

        driver.get("http://amazon.in");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Dimension dimension = new Dimension(800,750);
        driver.manage().window().setSize(dimension);

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
