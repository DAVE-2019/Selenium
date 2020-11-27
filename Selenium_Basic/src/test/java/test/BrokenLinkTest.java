package test;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinkTest {

    //creating webdriver instance
    WebDriver driver;

    @BeforeTest
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver2.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void BrokenLink() throws MalformedURLException {

        HttpURLConnection huc =null;
        String url = "";
        int respCode =200;
        String homePage = "http://www.zlti.com";

        driver.get(homePage);

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){

            url = it.next().getAttribute("href");

            System.out.println(url);

            if(url == null){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
        }
        try{
            huc = (HttpURLConnection)(new URL(url).openConnection());
            huc.setRequestMethod("HEAD");
            huc.connect();
            respCode = huc.getResponseCode();

            if(respCode>=400){
                System.out.println(url+"is a broken link");
            }
            else {
                System.out.println(url+"is a valid link");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
