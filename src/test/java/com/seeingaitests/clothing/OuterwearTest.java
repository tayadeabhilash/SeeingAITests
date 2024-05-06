package com.seeingaitests.clothing;

import com.google.common.collect.ImmutableMap;
import com.seeingaitests.utils.SetUpUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OuterwearTest {

    private AppiumDriver driver;

    private WebDriverWait wait;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
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
    public void testVest() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "vest";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }

    @Test(priority = 2)
    public void testCoat() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "grey coat";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 3)
    public void testBrownJacket() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "brown jacket";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 4)
    public void testWhiteJacket() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "white jacket";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 5)
    public void testBlackJacket() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "black jacket";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }

    @AfterSuite
    public void tearDown() {
        ((AndroidDriver) driver).terminateApp("com.google.android.apps.photos");
        ((AndroidDriver) driver).terminateApp("com.microsoft.seeingai");
        // Quit the driver
        driver.quit();
    }

    private void selectPhoto(WebDriverWait wait) {
        WebElement photosApp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc=\"Photos\"]")));
        photosApp.click();
        System.out.println("In Photos App");

        WebElement outisde = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.photos:id/negative_button\"]")));
        outisde.click();

        WebElement outerwear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.photos:id/collection_title\" and @text=\"Outerwear\"]")));
        outerwear.click();

        WebElement photo1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Photo taken on May 5, 2024 6:54:04 PM\"]")));
        photo1.click();
    }
}
