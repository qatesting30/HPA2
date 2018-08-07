package com.healthec.test.functional;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestClass {

    public static RemoteWebDriver driver;

    @BeforeTest
    public static void beforeChecktest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("platVersion", "6.0.1");
        cap.setCapability("appPackage", "com.android.chrome");
        cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        cap.setCapability("deviceName", "Android");
        cap.setCapability("browserName", "Chrome");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }

    @Test
    public static void checkTest()
    {
        System.out.println("main");
        driver.get("http://192.168.6.24:9080/providerEConnect/mobile/patient/ContactUs.html");
        String ele = driver.findElement(By.xpath("//h1[contains(text(),'Contact Us')]")).getText();
        System.out.println("Text: "+ele);

    }
}
