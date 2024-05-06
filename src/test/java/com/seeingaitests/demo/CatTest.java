package com.seeingaitests.demo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CatTest {
    private AppiumDriver driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities  = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "realme X3 SuperZoom");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("udid", "4195068b");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("appPackage", "com.coloros.gallery3d");
        capabilities.setCapability("appActivity", "com.coloros.gallery3d.app.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testTextContainsCat() {
        WebElement confirm = driver.findElement(By.id("com.coloros.gallery3d:id/btn_confirm"));
        confirm.click();
        WebElement albums = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.coloros.gallery3d:id/normalLable\" and @text=\"Albums\"]"));
        albums.click();
        WebElement all = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.coloros.gallery3d:id/albumset_title\" and @text=\"All\"]"));
        all.click();
        WebElement moreOptions = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"More options,\"]"));
        moreOptions.click();
        WebElement edit = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.coloros.gallery3d:id/popup_list_window_item_title\"]"));
        edit.click();
        WebElement item = driver.findElement(By.xpath("//com.oplus.gallery.business_lib.ui.view.SlotView[@content-desc=\",Item 1,Photo,,May 3, 2024, 11:42\"]"));
        item.click();
        WebElement send = driver.findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.coloros.gallery3d:id/rl_content\"])[1]"));
        send.click();
        WebElement sendScroll = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.coloros.gallery3d:id/resolver_recycler_view\"]"));

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId",sendScroll,
                "left", 900, "top", 2025, "width", 200, "height", 200,
                "direction", "right",
                "percent", 11.0
        ));

        WebElement seeingAIShare = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.coloros.gallery3d:id/resolver_item_name\" and @text=\"SeeingAI\"]"));
        seeingAIShare.click();

        WebElement textView = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.microsoft.seeingai:id/result_cell_text']"));

        // Retrieve the text from the element
        String text = textView.getText();

        // Check if the text contains the word "cat"
        boolean containsCat = text.contains("cat");

        if (containsCat) {
            System.out.println("The text contains the word 'cat'");
        } else {
            System.out.println("The text does not contain the word 'cat'");
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
