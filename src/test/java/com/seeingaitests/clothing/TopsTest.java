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

public class TopsTest {

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
    public void testYellowShirt() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "yellow and white striped shirt";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }

    @Test(priority = 2)
    public void testBrownShirt() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "brown shirt";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 3)
    public void testGreyShirt() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "grey shirt";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 4)
    public void testGreyShirt2() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "grey shirt";
        String actualResult = SetUpUtil.getResults(wait, expectedResult);
        SetUpUtil.goBack(wait);
        SetUpUtil.swipeToNextImage(driver, wait);
        Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult.toLowerCase()));
    }
    @Test(priority = 5)
    public void testWhiteShirt() {
        SetUpUtil.sharePhoto(wait);
        String expectedResult = "white shirt";
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

        SetUpUtil.scrollDown(driver, wait);

        WebElement tops = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.photos:id/collection_title\" and @text=\"Tops\"]")));
        tops.click();

        WebElement photo1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.ViewGroup[@content-desc=\"Photo taken on May 5, 2024 6:54:00 PM\"])[1]")));
        photo1.click();
    }
}
