package main.java.Tests.utils;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    private final WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void getScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
    }
}
