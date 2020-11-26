package test;

import org.junit.After;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PopupTest {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver2.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void popUptest(){

        driver.get("http://popuptest.com/goodpopups.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement popup1=driver.findElement(By.linkText("Good PopUp #1"));
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        popup1.click();

        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window

// Now you are in the popup window, perform necessary actions here

        driver.switchTo().window(parentWindowHandler);  // switch back to parent window

        System.out.println(driver.getTitle());


    }






    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
