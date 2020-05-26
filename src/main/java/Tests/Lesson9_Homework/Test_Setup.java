package main.java.Tests.Lesson9_Homework;

import main.java.Tests.utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Test_Setup {
    WebDriver driver;
    Screenshot screenshot;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1300,1080");
        driver = new ChromeDriver();
        screenshot = new Screenshot(driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        screenshot.getScreenshot();
        driver.quit();
    }
}
