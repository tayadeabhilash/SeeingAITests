package com.seeingaitests;
import io.appium.java_client.*;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    static AppiumDriver driver;
    public static void main( String[] args ) throws MalformedURLException {
        runSuite();
    }
    public static void runSuite() {
        XmlSuite suite = new XmlSuite();
        suite.setName("Appium Test Suite");

        // Create a TestNG XML test
        XmlTest test = new XmlTest(suite);
        test.setName("Appium Test");

        // Add test classes to the test
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass(CatTest.class.getName())); // Make sure to use fully qualified class name
        test.setXmlClasses(classes);

        // Set output directory for test reports
        suite.setFileName("testng.xml"); // Set the file name here
        suite.setVerbose(1);

        // Generate TestNG XML file
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        // Run TestNG tests
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
