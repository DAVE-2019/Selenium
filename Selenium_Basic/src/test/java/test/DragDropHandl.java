package test;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragDropHandl {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver2.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void dragAndDropTest(){

        driver.get("https://jqueryui.com/droppable/");
       driver.manage().window().maximize();
       WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
       driver.switchTo().frame(frame);
       WebElement src = driver.findElement(By.id("draggable"));
       WebElement dest=driver.findElement(By.id("droppable"));

       Actions act = new Actions(driver);
       act.dragAndDrop(src,dest).perform();

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
