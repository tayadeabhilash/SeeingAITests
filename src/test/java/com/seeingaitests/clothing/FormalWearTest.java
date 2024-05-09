package com.seeingaitests.clothing;

import com.seeingaitests.utils.SetUpUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class FormalWearTest {

    private AppiumDriver driver;

    private WebDriverWait wait;

    @BeforeSuite
    public void setUp() {
        driver = SetUpUtil.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        SetUpUtil.skipButton(wait);
        SetUpUtil.acceptTerms(wait);
        SetUpUtil.getStarted(wait);
        SetUpUtil.handlePermissionDialog(wait);
        SetUpUtil.closeOverlay(wait);
        SetUpUtil.navigateToHome(driver);
        selectPhoto(wait);
    }

    @Test(priority = 1)
    public void testBlackJacket() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "black jacket";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }

    @Test(priority = 2)
    public void testDress1() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "dress";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 3)
    public void testBlackSuit() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "black suit";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 4)
    public void testDress() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "dress";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 5)
    public void testGreyJacket() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "grey jacket";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }

    @AfterSuite
    public void tearDown() {
        ((AndroidDriver) driver).terminateApp("com.google.android.apps.photos");
        ((AndroidDriver) driver).terminateApp("com.microsoft.seeingai");
        driver.quit();
    }

    private void selectPhoto(WebDriverWait wait) {
        WebElement photosApp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc=\"Photos\"]")));
        photosApp.click();
        System.out.println("In Photos App");

        WebElement outside = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.photos:id/negative_button\"]")));
        outside.click();

        WebElement tops = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.photos:id/collection_title\" and @text=\"Formalwear\"]")));
        tops.click();

        WebElement photo1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.ViewGroup[@content-desc=\"Photo taken on May 5, 2024 6:54:03 PM\"])[1]")));
        photo1.click();
    }
}
