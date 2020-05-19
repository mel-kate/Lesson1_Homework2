package main.java.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class Lesson7_Rozetka_Waits {
    WebDriver driver;
    WebDriverWait wait;
    By cabinet = By.cssSelector("a.header-topline__user-link");
    By register = By.cssSelector("a.auth-modal__register-link");
    By login = By.cssSelector("input[formcontrolname=\"name\" ]");
    By contacts = By.cssSelector("input[formcontrolname=\"username\"]");
    By passw = By.cssSelector("input[formcontrolname=\"password\"]");
    By submitbutton = By.cssSelector("button[type=\"submit\"]");

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1300,1080");
        //options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    @Test
    public void testFirst() {
        driver.get("https://rozetka.com.ua/");
        WebElement searchEl = driver.findElement(cabinet);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        searchEl.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(register)));
        WebElement searchEl2 = driver.findElement(register);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl2));
        searchEl2.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(login)));
        WebElement searchEl3 = driver.findElement(login);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl3));
        searchEl3.click();
        searchEl3.sendKeys("Екатерина");

        WebElement searchEl5 = driver.findElement(contacts);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl5));
        String text = searchEl5.getText();
        String check = "";
        assertTrue(text.contains(check));
        System.out.println("checked contacts");

        WebElement searchEl6 = driver.findElement(passw);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl6));
        String text1 = searchEl6.getText();
        String check1 = "";
        assertTrue(text1.contains(check1));
        System.out.println("checked password");

        searchEl5.click();
        searchEl6.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitbutton)));
        WebElement searchEl4 = driver.findElement(submitbutton);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl4));
        searchEl4.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(contacts)));
        String cssvaluecontacts = searchEl5.getCssValue("border-color");
        ExpectedConditions.attributeToBe(contacts, "border-color", "rgb(248, 65, 71)");
        System.out.println(cssvaluecontacts);
        System.out.println("checked color");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
