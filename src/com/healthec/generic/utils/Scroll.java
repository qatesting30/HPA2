package com.healthec.generic.utils;

import com.healthec.UI.SwitchView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileBy;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Scroll {

    public static String instance;
    public static RemoteWebDriver driver;


	public static void scrollToText(RemoteWebDriver driver,Object text)
    {

        instance =driver.getClass().getName();

        if(instance.contains("AndroidDriver")) {
            new Scroll().scrollToTextAndroid(driver, text);
        }
        else if(instance.contains("IOSDriver")){
            new Scroll().scrollToTextIos(driver, text);
        }
        else
        {
            System.out.println("Invalid driver  getting passed");
        }
    }


    public void scrollToTextAndroid(RemoteWebDriver driver,Object text) {
		SwitchView.changeContext(driver, "NATIVE_APP");
		System.out.println("text value is: "+text);


        /*driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().textMatches(\""+text +"\"))")).click();*/

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
    		+ "scrollIntoView(new UiSelector().text(\""+text+"\").instance(0))")).click();
	SwitchView.changeContext(driver, "WEBVIEW");
	}

    /*public static void scrollToTextIos(RemoteWebDriver driver,Object text)
    {
        SwitchView.changeContext(driver, "NATIVE_APP");
        System.out.println("text value is: "+text);
        driver.findElement(MobileBy.IosUIAutomation("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
                + "scrollIntoView(new UiSelector().textMatches(\"" +text + "\").instance(0))")).click();
        SwitchView.changeContext(driver, "WEBVIEW");
    }*/

    public void scrollToTextIos(RemoteWebDriver driver,Object text) {
        System.out.println("   tapItemByDescription(): " + text);

        // scroll to item
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "value == '" + text + "'");
        js.executeScript("mobile: scroll", scrollObject);

        // tap item
        /*WebElement el = ((IOSDriver) driver).findElementByIosNsPredicate("value = '" + text + "'");
        return tapElement((MobileElement) el);*/
    }

    public static void scrollDown(RemoteWebDriver driver,List<WebElement> text) {
        boolean isPresent= false;
        WebElement we = null;
        SwitchView.changeContext(driver, "NATIVE_APP");
        int i = 0;

        do{

            isPresent = text.size()>0;
            if(isPresent==true){
                we = driver.findElement(By.id("urid"));
                we.click();
                break;
            }
            else{
                scroll(driver);}
            i++;

        } while(i <= 4);
        SwitchView.changeContext(driver, "WEBVIEW");
    }

    private static void scroll(RemoteWebDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int ht=size.getHeight();
        int wd=size.getWidth();
        int width = (int) (wd*0.5);
        int startPoint = (int) (ht * 0.8);
        int endPoint = (int) (ht * 0.2);

        try{
            new TouchAction((PerformsTouchActions) driver).press(width, startPoint).waitAction(Duration.ofSeconds(5)).moveTo(width, endPoint).release().perform();
        }
	    catch(Exception e){
            System.out.println("Unable to scroll: "+e.getMessage());
            }


        }

}
