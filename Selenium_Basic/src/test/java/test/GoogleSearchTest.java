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

public class GoogleSearchTest {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver2.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void googlesearchTest(){
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.xpath("//input[@title='Search']"));
        element.sendKeys("Infosys");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement matchingResult= driver.findElement(By.xpath(".//div[@class='aajZCb']/ul"));

        List<WebElement> listResult= matchingResult.findElements(By.xpath("//li/div/div[@class='sbtc']"));
        System.out.println(listResult.size());
//if you want to print matching results
        for(WebElement results: listResult)
        {
            String value= results.getText();
            System.out.println(value);
        }






    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
