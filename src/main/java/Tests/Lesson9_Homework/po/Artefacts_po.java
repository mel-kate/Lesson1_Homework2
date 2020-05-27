package main.java.Tests.Lesson9_Homework.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Artefacts_po {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By titles = By.cssSelector("a.goods-tile__heading");
    private List<WebElement> source;
    List<String> a;
    Logger logger = LogManager.getLogger(MainFindElements.class);



    public Artefacts_po(WebDriver driver) {
        logger.trace("Laptops site initialization");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 15);

    }

    public Artefacts_po open() {
        logger.info("Site opened");
        driver.get("https://rozetka.com.ua/notebooks/c80004/preset=workteaching/");
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    public void checklist(String operator) {

       By checkbox = By.id(operator);
        WebElement checkbox1;
        checkbox1 = driver.findElement(checkbox);
        logger.info("Wait for checkbox");
        wait.until(ExpectedConditions.elementToBeClickable(checkbox1));
        checkbox1.click();
        logger.info("Wait for checkbox click");
    }

    public List<String> getArray() {
        logger.info("Get elements on the page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(titles));
        source= driver.findElements(titles);
        for (int i = 0; i < source.size(); i++) {
            a.add(source.get(i).getText());
            //System.out.println(source.get(i).getText());
        }
        return a;
    }


}
