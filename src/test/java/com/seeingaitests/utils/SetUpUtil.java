package com.seeingaitests.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class SetUpUtil {
    public static int totalTests = 5;
    public static int passCount = 0;

    public static AndroidDriver getDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "pixel-8");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("app", "C:/Users/Abhilash/Downloads/Seeing.apk");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.microsoft.seeingai");
        caps.setCapability("appActivity", "crc64a8457ff90b487ee0.SplashActivity");

        try {
            URL url = new URL("http://127.0.0.1:4723");
            return new AndroidDriver(url, caps);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getResults(WebDriverWait wait, String expectedResult) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.microsoft.seeingai:id/result_cell_text")));
        String actualResult = element.getText();
        System.out.println("Expected Result: " + expectedResult);
        System.out.println("Actual Result: " + actualResult);
        return actualResult;
    }

    public static void compareResults(AppiumDriver driver, String expectedResult) {
        WebElement element = driver.findElement(By.id("com.microsoft.seeingai:id/result_cell_text"));
        String actualResult = element.getText().toLowerCase();
        boolean pass = true;
        String[] expectedWords = expectedResult.toLowerCase().split(" ");
        for (String word : expectedWords) {
            if (!actualResult.contains(word)) {
                pass = false;
                break;
            }
        }
        if (pass) {
            passCount++;
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public static void skipButton(WebDriverWait wait) {
        WebElement skipButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.microsoft.seeingai:id/pagedSkipButton")));
        skipButton.click();
    }

    public static void acceptTerms(WebDriverWait wait) {
        WebElement termsCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.microsoft.seeingai:id/terms_check_box")));
        termsCheckBox.click();
    }

    public static void getStarted(WebDriverWait wait) {
        WebElement getStartedButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.microsoft.seeingai:id/terms_getstarted_button")));
        getStartedButton.click();
    }

    public static void handlePermissionDialog(WebDriverWait wait) {
        WebElement allowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
        allowButton.click();
    }

    public static void closeOverlay(WebDriverWait wait) {
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.microsoft.seeingai:id/close_icon_bottom_sheet")));
        closeButton.click();
    }

    public static void navigateToHome(AppiumDriver driver) {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));
        System.out.println("At Home");
    }

    public static void sharePhoto(WebDriverWait wait) {
        WebElement shareButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.google.android.apps.photos:id/share")));
        shareButton2.click();
        WebElement appToShare = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.photos:id/text\" and @text=\"SeeingAI\"]")));
        appToShare.click();
        System.out.println("Sharing Image to SeeingAI");
    }

    public static void goBack(WebDriverWait wait) {
        WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));
        backButton.click();
    }


    public static void swipeToNextImage(AppiumDriver driver, WebDriverWait wait) {
        WebElement sendScroll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.google.android.apps.photos:id/photo_container\"]")));

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", sendScroll,
                "left", 400, "top", 1325, "width", 200, "height", 200,
                "direction", "right",
                "percent", 1.0
        ));
        System.out.println("Swiped to next Image");
    }
}
