package main.java.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Lesson6_Rozetka {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1300,1080");
        //options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testFirst() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");
        Thread.sleep(3000);
        String number = driver.findElement(By.cssSelector("span.link-dashed")).getText();
        String numberclear = number.replaceAll("[(|)|-]","");
        String nospaces = numberclear.replace(" ", "");
        System.out.println("<" + nospaces + ">");
        driver.quit();
    }
}
