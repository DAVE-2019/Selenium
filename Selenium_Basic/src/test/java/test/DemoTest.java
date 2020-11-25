package test;


import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTest {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.ie.driver","E:\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();

    }

    @Test
    public void demo(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //open the web app
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
    }





    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
