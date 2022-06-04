package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    private String searchUrl="https://www.google.com/";
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
    }

    @BeforeMethod
    public void goHome() {
        driver.get(searchUrl);
        homePage=new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}


