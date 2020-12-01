package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestNGDataProvider {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Start test");
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver2.exe");
        driver = new ChromeDriver();
        String url = "https://www.google.com";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @DataProvider(name = "test-data")
    public static Object[][] dataProvFunc(){
        return new Object[][]{
                {"Infosys"},{"Mysore"}
        };
    }

    @Test(dataProvider ="test-data")
    public void search(String keyWord){
        WebElement txtBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        txtBox.sendKeys(keyWord);
        Reporter.log("Keyword entered is : " +keyWord);
        txtBox.sendKeys(Keys.ENTER);
        Reporter.log("Search results are displayed.");
    }

    @AfterMethod
    public void burnDown(){
        driver.quit();
    }



}
