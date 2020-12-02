package test;

import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TabSwitch {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver2.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void TabSwitchTest(){

        driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        //driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button"));
        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul/li[8]/a/label")).click();






    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
