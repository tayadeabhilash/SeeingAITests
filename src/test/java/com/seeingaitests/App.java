package com.seeingaitests;

import com.seeingaitests.clothing.OuterwearTest;
import com.seeingaitests.clothing.FormalWearTest;
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
        XmlSuite suite = new XmlSuite();
        suite.setName("Outerwear Test Suite");

        XmlTest test = new XmlTest(suite);
        test.setName("Outerwear Test");

        // Add test classes to the test
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass(OuterwearTest.class.getName()));
        test.setXmlClasses(classes);

        // Set output directory for test reports
        suite.setFileName("testng.xml"); // Set the file name here
        suite.setVerbose(1);

        XmlSuite suite2 = new XmlSuite();
        suite2.setName("Formalwear Test Suite");

        XmlTest test2 = new XmlTest(suite2);
        test2.setName("Second Test");

        List<XmlClass> classes2 = new ArrayList<>();
        classes2.add(new XmlClass(FormalWearTest.class.getName()));
        test2.setXmlClasses(classes2);

        suite2.setFileName("testng2.xml");
        suite2.setVerbose(1);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        suites.add(suite2);

        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
