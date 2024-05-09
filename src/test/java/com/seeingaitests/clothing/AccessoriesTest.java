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

public class AccessoriesTest {

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
    public void testOrangeHat() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "Orange Hat";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }

    @Test(priority = 2)
    public void testSocks() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "socks";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 3)
    public void testTies() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "ties";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 4)
    public void testScarf() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "red scarf";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 5)
    public void testHat() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "yellow hat";
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

        WebElement tops = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.photos:id/collection_title\" and @text=\"accessories\"]")));
        tops.click();

        WebElement photo1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.ViewGroup[@content-desc=\"Photo taken on May 8, 2024 2:04:22 PM\"])[1]")));
        photo1.click();
    }
}
