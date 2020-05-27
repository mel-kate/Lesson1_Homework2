package main.java.Tests.Lesson9_Homework.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Artefacts_po {
    private final WebDriver driver;
    private final WebDriverWait wait;
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
}
