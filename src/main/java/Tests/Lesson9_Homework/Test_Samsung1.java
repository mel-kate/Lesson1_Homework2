package main.java.Tests.Lesson9_Homework;

import main.java.Tests.Lesson9_Homework.po.FindElements;
import main.java.Tests.Lesson9_Homework.po.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test_Samsung1 extends Test_Setup {
    HomePage homepage;
    FindElements findelements;




    @BeforeMethod
    public void initialize() {
    homepage  = new HomePage(driver);
    findelements = new FindElements(driver);
    }

    @Test
    public void samsTest() {
        homepage.open();
        homepage.search("IPhone");
        List<String> check = findelements.getArray();
        int size = check.size();
        System.out.println(check.size() + " elements on the page");

        int iphonesCount = 0;
        for (int i = 0; i < check.size(); i++) {
            if (check.get(i).contains("iPhone")) iphonesCount++;
        }
        assertEquals(iphonesCount, check.size());
        System.out.println("Actual amount = " + size + " detected amount = " + iphonesCount);
    }

}
