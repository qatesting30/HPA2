package com.healthec.project.spec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.healthec.generic.utils.PropertiesData;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;


public class CreateDriver {

    public static DesiredCapabilities cap;
    public static RemoteWebDriver driver;
    public static String commandline;
    public static String device_os_version;
    public static String device_udid;
    public static Process p;
    public static String device_id;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static String platform;
    public static String deviceType;


    @Parameters({"platform","deviceType"})
    public static RemoteWebDriver getDriver(String platform1,String deviceType1) {
        driver = null;
       /* platform = context1.getCurrentXmlTest().getParameter("platform");
        deviceType = context1.getCurrentXmlTest().getParameter("deviceType");*/
        // String env = PropertiesData.getDataFromProperties("config","env");
        platform=platform1;
        deviceType=deviceType1;
        System.out.println("platform: "+platform);
        System.out.println("device: "+deviceType);
        System.out.println("Env is: " + platform);
        if (platform.equalsIgnoreCase("AOS")) {
            getAndroidDeviceOsVersion(deviceType);
            driver = androidSetUp(platform,deviceType);
        } else if (platform.equalsIgnoreCase("IOS")) {
            getIosOsVersion();
            driver = iosSetUp(platform);
        } else {
            System.out.println("Invalid driver format");
            log.info("Invalid driver format");
        }

        return driver;
    }

    public static RemoteWebDriver androidSetUp(String env,String deviceType) {
        RemoteWebDriver driver = null;

        try {
           // String env = PropertiesData.getDataFromProperties("config", "env");
            String platformName = PropertiesData.getDataFromProperties("config" + env, "platformName");
            String platformVersion = PropertiesData.getDataFromProperties("config" + env, "platformVersion");
            String appPackage = PropertiesData.getDataFromProperties("config" + env, "appPackage");
            String appActivity = PropertiesData.getDataFromProperties("config" + env, "appActivity");
            String deviceName = PropertiesData.getDataFromProperties("config" + env, "deviceName");
            String appiumURL = PropertiesData.getDataFromProperties("config" + env, "appiumURL");
            String automationName = PropertiesData.getDataFromProperties("config" + env, "automationName");
            String skipUnlock = PropertiesData.getDataFromProperties("config" + env, "skipUnlock");
            String autoWebView = PropertiesData.getDataFromProperties("config" + env, "autoWebview");
            String nativeWebScreenshot = PropertiesData.getDataFromProperties("config" + env, "nativeWebScreenshot");
            String securityToken = PropertiesData.getDataFromProperties("config" + env, "securityToken");
            String appiumURL1 = PropertiesData.getDataFromProperties("config" + env, "appiumURL1");
            String user = PropertiesData.getDataFromProperties("config" + env, "user");
            String password = PropertiesData.getDataFromProperties("config" + env, "password");
            cap = new DesiredCapabilities();
            //System.out.println("Final android version: "+getAndroidDeviceOsVersion());
            cap.setCapability("platformName", platformName);
            cap.setCapability("platformVersion",getAndroidDeviceOsVersion(deviceType));
            cap.setCapability("appPackage", appPackage);
            cap.setCapability("appActivity", appActivity);
            cap.setCapability("deviceName", deviceName);
            //cap.setCapability("automationName",automationName);
            cap.setCapability("skipUnlock", skipUnlock);
            //cap.setCapability("autoWebView",autoWebView);
            cap.setCapability("nativeWebScreenshot", nativeWebScreenshot);
           // cap.setCapability("app");
           /* cap.setCapability("securityToken",securityToken);
            cap.setCapability("user",securityToken);
            cap.setCapability("password",securityToken);
*/
            driver = new AndroidDriver(new URL(appiumURL), cap);

        } catch (Exception e) {
            System.out.println("Exception in getting driver value: " + e.getMessage());
            log.info("Exception in getting driver value: " + e.getMessage());
        }
        return driver;
    }

    public static RemoteWebDriver iosSetUp(String env) {
        RemoteWebDriver driver = null;
        try {
           // String env = PropertiesData.getDataFromProperties("config", "env");
            String platformName = PropertiesData.getDataFromProperties("config" + env, "platformName");
            String platformVersion = PropertiesData.getDataFromProperties("config" + env, "platformVersion");
            String deviceName = PropertiesData.getDataFromProperties("config" + env, "deviceName");
            String appiumURL = PropertiesData.getDataFromProperties("config" + env, "appiumURL");
            String bundleId = PropertiesData.getDataFromProperties("config" + env, "bundleId");
            String udid = PropertiesData.getDataFromProperties("config" + env, "udid");
            String automationName = PropertiesData.getDataFromProperties("config" + env, "automationName");

            List<String>get_device_details = getIosOsVersion();
            System.out.println("complete device details: "+get_device_details);

            String device_udid = get_device_details.get(0);
            String device_OS_version = get_device_details.get(1);
            System.out.println(device_udid+","+device_OS_version);

            cap = new DesiredCapabilities();
            cap.setCapability("platfromName", platformName);
            cap.setCapability("platformVersion", device_OS_version);
            cap.setCapability("bundleId", bundleId);
            cap.setCapability("udid", device_udid);
            cap.setCapability("deviceName", deviceName);
            cap.setCapability("automationName", automationName);
            driver = new IOSDriver(new URL(appiumURL), cap);
        } catch (Exception e) {
            System.out.println("Exception in getting driver value: " + e.getMessage());
            log.info("Exception in getting driver value: " + e.getMessage());
        }
        return driver;
    }

    public static String getAndroidDeviceOsVersion(String deviceType){

        /**************************Android command for windows system**********/
            // String cmd = "adb devices";
             //String os_version_cmd2 = "adb.exe -s \"" + device_id + "\" shell getprop ro.build.version.release";

        /**********************************************************************/

        ////String os_version_cmd = "adb shell getprop | grep build.version.release";


        String os_version_cmd1="adb -d shell getprop | grep build.version.release";
        String os_version_cmd2 = "adb -e shell getprop | grep build.version.release";
        try {

            if(deviceType.equalsIgnoreCase("R")){
                System.out.println("Selected device is a real device");
                p = Runtime.getRuntime().exec(os_version_cmd1);
                p.waitFor();
            }
            if(deviceType.equalsIgnoreCase("E")){
                System.out.println("Selected device is an emulator");
                p = Runtime.getRuntime().exec(os_version_cmd2);
                p.waitFor();
            }
            BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((commandline = err.readLine()) != null) {
                System.out.println(commandline);
            }
            err.close();
            //System.out.println("device id command: "+"adb shell getprop | grep build.version.release");

            List<String> deviceList = new ArrayList<>();
            BufferedReader input1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((commandline = input1.readLine()) != null) {
                //printing in the console
                System.out.println(commandline);
                if (commandline.startsWith("[ro.build.version.release]")) {
                    deviceList.add(commandline.split(" ")[1]);
                    //System.out.println(deviceList);
                    device_os_version=deviceList.toString().replace("[","").replace("]","");
                    System.out.println(device_os_version);
                }
            }
            input1.close();

        } catch (Exception e) {
            System.out.println("Exception in executing cmd commands: " + e.getMessage());
            log.info("Exception in executing cmd commands: " + e.getMessage());
        }
        return device_os_version;

    }

    public static List<String>getIosOsVersion () {

        device_os_version=null;

        try {
            String cmd = "instruments -s devices";
            String cmd1 ="idevice_id -l";
            Process p;
            //System.out.println("command is: "+cmd1);

            p = Runtime.getRuntime().exec(cmd1);
            p.waitFor();

            BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((commandline = err.readLine()) != null) {
                System.out.println(commandline);
            }
            err.close();


            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((commandline = input.readLine()) != null) {
                //printing in the console
                device_udid = commandline;
            }
            System.out.println("device udid: "+device_udid);
            input.close();

            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();

            BufferedReader err1 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((commandline = err1.readLine()) != null) {
                System.out.println(commandline);
            }
            err1.close();

            List<String> deviceList = new ArrayList<>();
                    BufferedReader input1= new BufferedReader(new InputStreamReader(p.getInputStream()));
                    while ((commandline = input1.readLine()) != null) {
                        if (commandline.endsWith("["+device_udid+"]")) {
                            deviceList.add(commandline.split(" ")[0]);
                            String device_connected_check = deviceList.toString().replace("[","").replace("]","");
                           // String device_connected_check = deviceList.toString();
                            System.out.println("name: "+device_connected_check);

                            if (!device_connected_check.equalsIgnoreCase("(null)")){
                                deviceList.remove(0);
                                deviceList.add(commandline.split(" ")[1]);
                                System.out.println("device_list: "+deviceList);
                                device_os_version=deviceList.toString().replace("[(","").replace(")]","");
                                System.out.println(device_os_version);
                            }
                            else{
                                System.out.println("Please connect real device");
                            }



                }
            }
            input1.close();



        }catch(Exception e){
            System.out.println("Exception in writting command in terminal: "+e.getMessage());
        }


        return Arrays.asList(device_udid,device_os_version) ;

    }

    public static void main(String[] args) {

       //getIosOsVersion();
        //iosSetUp("IOS");
        //getAndroidDeviceOsVersion("r");
    }
}
