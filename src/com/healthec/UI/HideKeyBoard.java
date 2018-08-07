package com.healthec.UI;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HideKeyBoard {
	
	public static String instance;
	public static Process p;
	public static boolean isKeyboardPresent;
	public static String outputText;
    public static Logger log = Logger.getLogger("devpinoyLogger");
	
	@SuppressWarnings("rawtypes")
	public static void hideKeyBoard(RemoteWebDriver driver){

		isKeyboardPresent=checkForVisisbleKeyboard();
		System.out.println("keyboard present: "+isKeyboardPresent);

	    SwitchView.changeContext(driver, "NATIVE_APP");
		instance = driver.getClass().getName();
		if(instance.contains("AndroidDriver")){
			AndroidDriver driver1= (AndroidDriver)driver;
			if(isKeyboardPresent==true) {
				driver1.hideKeyboard();
			}
			}
		else if(instance.contains("IOSDriver")){
			IOSDriver driver2= (IOSDriver)driver;
			if(isKeyboardPresent==true) {
				driver2.hideKeyboard();
			}
		}
		SwitchView.changeContext(driver, "WEBVIEW");
	}


	public static boolean checkForVisisbleKeyboard() {
		/*********To check keyboard open or not thorugh cmd in android*******/
		// adb shell dumpsys input_method | grep mInputShown
		/*********To check keyboard open or not thorugh cmd in android*******/
        try {
            p = Runtime.getRuntime().exec("adb shell dumpsys input_method | grep mInputShown");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            outputText = reader.readLine();
            System.out.println("output: "+outputText);

            while (outputText != null) {

                if(!outputText.trim().equals("")){
                    String keyboardProperties[]=outputText.split(" ");
                   // System.out.println(outputText.split(" "));
                    String keyValue[]=keyboardProperties[keyboardProperties.length-1].split("=");
                    //System.out.println(keyboardProperties[keyboardProperties.length-1].split("="));
                    String softkeyboardpresenseValue=keyValue[keyValue.length-1];
                    if(softkeyboardpresenseValue.equalsIgnoreCase("false")){
                        isKeyboardPresent=false;
                        break;
                    }else{
                        isKeyboardPresent=true;
                        break;
                    }
                }
            }
            reader.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

		return isKeyboardPresent;
	}
}
