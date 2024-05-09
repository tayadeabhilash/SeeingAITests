package com.seeingaitests;

import com.seeingaitests.clothing.*;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        runSuite();
    }

    public static void runSuite() {
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(createSuite("Outerwear Test", OuterwearTest.class.getName()));
        suites.add(createSuite("Formalwear Test", FormalWearTest.class.getName()));
        suites.add(createSuite("Bottoms Test", BottomsTest.class.getName()));
        suites.add(createSuite("Tops Test", TopsTest.class.getName()));
        suites.add(createSuite("Accessories Test", AccessoriesTest.class.getName()));

        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        testNG.run();
    }

    public static XmlSuite createSuite(String name, String className) {
        XmlSuite suite = new XmlSuite();
        suite.setName(name + " Suite");

        XmlTest test = new XmlTest(suite);
        test.setName(name);

        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass(className));
        test.setXmlClasses(classes);

        suite.setFileName("testng.xml");
        suite.setVerbose(1);

        return suite;
    }
}
