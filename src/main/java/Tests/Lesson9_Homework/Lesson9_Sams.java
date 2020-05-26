package main.java.Tests.Lesson9_Homework;

import main.java.Tests.Lesson9_Homework.po.HomePage;
import main.java.Tests.Lesson9_Homework.po.MainFindElements;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Lesson9_Sams extends Test_Setup {
    HomePage homepage;
    MainFindElements mainfindelements;
    List<String> menuCheck;
    String[] exparraycheck;
    Logger logger = LogManager.getLogger(MainFindElements.class);





    @BeforeMethod
    public void initialize() {
        homepage  = new HomePage(driver);
        mainfindelements = new MainFindElements(driver);
    }

    @Test
    public void samsTest() {
        homepage.open();
        menuCheck = mainfindelements.getArray();
        exparraycheck = mainfindelements.massive();
        assertEquals(menuCheck.size(),exparraycheck.length);
        System.out.println("Size checked. actual size: " + menuCheck.size() + " size expected: " + exparraycheck.length);
        assertEquals(menuCheck.toString(),Arrays.asList(exparraycheck).toString());
        logger.info("Arrays checked");



    }



}
