package com.seeingaitests;

import com.abhilash.visiontesting.CVTestRunner;
import com.seeingaitests.clothing.*;

public class App {
    public static void main(String[] args) {
        CVTestRunner testRunner = new CVTestRunner();
        testRunner.addSuite("Outerwear Test", OuterwearTest.class.getName());
        testRunner.addSuite("Formalwear Test", FormalWearTest.class.getName());
        testRunner.addSuite("Bottoms Test", BottomsTest.class.getName());
        testRunner.addSuite("Tops Test", TopsTest.class.getName());
        testRunner.addSuite("Accessories Test", AccessoriesTest.class.getName());
        testRunner.runTests();
    }
}
