package main.java.Tests.Lesson9_Homework;

import main.java.Tests.Lesson9_Homework.po.Artefacts_po;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
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

    @Test
    public void LaptopsTest() {
        artefacts_po.open();
        artefacts_po.checklist("Acer");
        artefacts_po.getArray();


    }

}
