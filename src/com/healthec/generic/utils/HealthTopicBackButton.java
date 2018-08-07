package com.healthec.generic.utils;

import com.healthec.UI.SwitchView;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class HealthTopicBackButton
{
    public static String instance;

    public static void backBtn(RemoteWebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        instance = driver.getClass().getName();
         SwitchView.changeContext(driver,"NATIVE_APP");
        if(instance.contains("AndroidDriver"))
        {
          driver.findElement(By.id("com.healthec.providereconnect.phrpro:id/bckbtn")).click();
        }
        else if(instance.contains("IOSDriver"))
        {
            driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Return to PHR Pro')]")).click();
        }
        else
        {
            System.out.println("Invalid driver value passed");
        }
        SwitchView.changeContext(driver,"WEBVIEW");
    }
}
