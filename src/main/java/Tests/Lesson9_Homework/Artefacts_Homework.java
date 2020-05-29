package main.java.Tests.Lesson9_Homework;

import main.java.Tests.Lesson9_Homework.po.Laptops_check;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Artefacts_Homework extends Test_Setup{
    Laptops_check laptops_check;
    Logger logger = LogManager.getLogger(Laptops_check.class);

    @BeforeMethod
    public void initialize() {
        laptops_check = new Laptops_check(driver);
    }

    @Test(dataProvider = "producers")
    public void LaptopsTest(String producer) {
        laptops_check.open();
        laptops_check.checkUrl(producer);
        List<String> check = laptops_check.getArray();
        int[] arrayCheck = laptops_check.sizecheck(check,producer);
        int check1 = arrayCheck[0];
        int check2 = arrayCheck[1];
        if (check1!=check2) {
            logger.error("Check the amount of the elements on the page! Checklist = " + producer);
        }
        assertEquals(check1, check2);




    }

    @DataProvider(name = "producers")
    public Object[] getData() {
        return new Object[][] {
                {"Acer"},
                {"Apple"},
                {"Asus"},
                {"Dell"},
        };
    }

}
