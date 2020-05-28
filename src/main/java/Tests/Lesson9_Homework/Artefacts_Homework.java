package main.java.Tests.Lesson9_Homework;

import main.java.Tests.Lesson9_Homework.po.Artefacts_po;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Artefacts_Homework extends Test_Setup{
    Artefacts_po artefacts_po;
    Logger logger = LogManager.getLogger(Artefacts_po.class);

    @BeforeMethod
    public void initialize() {
        artefacts_po  = new Artefacts_po(driver);
    }

    @Test(dataProvider = "producers")
    public void LaptopsTest(String producer) {
        artefacts_po.open();
        artefacts_po.checkUrl(producer);
        List<String> check = artefacts_po.getArray();
        int[] arrayCheck = artefacts_po.sizecheck(check,producer);
        int check1 = arrayCheck[0];
        int check2 = arrayCheck[1];
        if (check1!=check2) {
            logger.error("Check the amount of the elements on the page! Checklist = " + producer);
        }



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
