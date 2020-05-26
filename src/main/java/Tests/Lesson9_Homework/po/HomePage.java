package main.java.Tests.Lesson9_Homework.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    Logger logger = LogManager.getLogger(MainFindElements.class);
    String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    By logo = By.cssSelector("[class='header__logo']");
    By search = By.cssSelector("[name='search']");
   // By searchResult = By.xpath("//span[contains(text(), '" + searchStr1 + "')]");
    By popup = By.cssSelector(popupStrSelect);
    By popupClose = By.cssSelector(popupStrSelect + " [class='popup-close']");
    By checkbox = By.cssSelector("[class='catalog-heading']");



    public HomePage(WebDriver driver) {
        logger.trace("HomePage initialization");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 15);

    }

    public HomePage open() {
        logger.info("Site opened");
        driver.get("https://rozetka.com.ua/");
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    public HomePage search(String searchStr) {
        logger.info("Searched on home page by " + searchStr);
        this.searchStr = searchStr;
        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        if (driver.findElements(popup).size() > 0) {
            driver.findElement(popupClose).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        searchEl.click();
        searchEl.sendKeys(this.searchStr);
        searchEl.sendKeys(Keys.ENTER);
        logger.info("Searched page opened");
        return this;
    }

}
