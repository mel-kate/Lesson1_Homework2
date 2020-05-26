package main.java.Tests.Lesson9_Homework.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FindElements {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private List<WebElement> source;
    List<String> a;
    private String searchStr;
    private final By titles = By.cssSelector("a.goods-tile__heading");
    Logger logger = LogManager.getLogger(MainFindElements.class);


    public FindElements(WebDriver driver) {
        logger.trace("FindElements initialization");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        a = new ArrayList<>();
    }

    public List<String> getArray() {
        logger.info("Get elements on the page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(titles));
        source= driver.findElements(titles);
        for (int i = 0; i < source.size(); i++) {
            a.add(source.get(i).getText());
            System.out.println(source.get(i).getText());
        }
        return a;
    }


}
