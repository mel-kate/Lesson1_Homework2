package main.java.Tests.Lesson9_Homework.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainFindElements {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private List<WebElement> source;
    WebElement searchEl3;
    List<String> a;
    private String searchStr;
    private final By titles = By.cssSelector("a.menu-categories__link");
    private final By button = By.cssSelector("button.menu-toggler");


    public MainFindElements(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        a = new ArrayList<>();
    }

    public List<String> getArray() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(button)));
        searchEl3 = driver.findElement(button);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl3));
        searchEl3.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(titles));
        source= driver.findElements(titles);
        for (int i = 0; i < source.size(); i++) {
            a.add(source.get(i).getText());
            System.out.println(source.get(i).getText());
        }
        return a;
    }

    public String[] massive() {
        String[] exparray = new String[]{"Ноутбуки и компьютеры",
                "Смартфоны, ТВ и электроника",
                "Бытовая техника",
                "Товары для дома",
                "Инструменты и автотовары",
                "Сантехника и ремонт",
                "Дача, сад и огород",
                "Спорт и увлечения",
                "Одежда, обувь и украшения",
                "Красота и здоровье",
                "Детские товары",
                "Канцтовары и книги",
                "Алкогольные напитки и продукты",
                "Товары для бизнеса",
                "Услуги и сервисы",
                "Лето ждет! Сейл до 50%",
                "Продовольственные наборы",
                "Ноутбуки и компьютеры",
                "Смартфоны, ТВ и электроника",
                "Бытовая техника",
                "Товары для дома",
                "Инструменты и автотовары",
                "Сантехника и ремонт",
                "Дача, сад и огород",
                "Спорт и увлечения",
                "Одежда, обувь и украшения",
                "Красота и здоровье",
                "Детские товары",
                "Канцтовары и книги",
                "Алкогольные напитки и продукты",
                "Товары для бизнеса",
                "Услуги и сервисы",
                "Лето ждет! Сейл до 50%",
                "Продовольственные наборы"};
                return exparray;
    }
}
