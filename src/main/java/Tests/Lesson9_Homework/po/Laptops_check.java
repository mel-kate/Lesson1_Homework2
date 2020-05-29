package main.java.Tests.Lesson9_Homework.po;

import main.java.Tests.utils.Screenshot;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Laptops_check {
    private final WebDriver driver;
    private final WebDriverWait wait;
    Screenshot screenshot;
    private final By titles = By.cssSelector("span.goods-tile__title");
    private List<WebElement> source;
    List<String> a;
    Logger logger = LogManager.getLogger(MainFindElements.class);



    public Laptops_check(WebDriver driver) {
        logger.trace("Laptops site initialization");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 15);
        screenshot = new Screenshot(driver);
        a = new ArrayList<>();

    }

    public Laptops_check open() {
        logger.info("Site opened");
        driver.get("https://rozetka.com.ua/notebooks/c80004/preset=workteaching/");
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    public Laptops_check checkUrl(String name){
        logger.info("Checklist marked");
        driver.get("https://rozetka.com.ua/notebooks/c80004/preset=workteaching;producer="+ name.toLowerCase() + "/");
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }
    
    public int[] sizecheck(List<String> check,String name){
        int size = check.size();
        logger.info("The elements on the page are: " + check.size());
        int elementsCount = 0;
        for (int i = 0; i < check.size(); i++) {
            if (check.get(i).contains(name)) elementsCount++;
        }
        logger.info("The elements on the page are: " + elementsCount);
        int[] ret = new int[2];
        ret[0] = size;
        ret[1] = elementsCount;
        return ret;

    }

    /*public void checklist(String operator) {

       By checkbox = By.id(operator);
        WebElement checkbox1;
        checkbox1 = driver.findElement(checkbox);
        logger.info("Wait for checkbox");
        wait.until(ExpectedConditions.elementToBeClickable(checkbox1));
        checkbox1.click();
        logger.info("Wait for checkbox click");
    }*/

    public List<String> getArray() {
        logger.info("Get elements on the page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(titles));
        source = driver.findElements(titles);
        logger.info("Get elements on the page 2");
        for (WebElement webElement : source) {
            a.add(webElement.getText());
            //System.out.println(webElement.getText());
        }
        return a;
    }



}
