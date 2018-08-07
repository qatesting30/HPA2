package com.healthec.project.Resources;

import com.healthec.UI.FieldValidation;
import com.healthec.UI.HideKeyBoard;
import com.healthec.UI.SwitchView;
import com.healthec.generic.utils.ExcelUtility;
import com.healthec.generic.utils.TestBaseClass;
import com.healthec.object.repo.LoginPageObjects;
import com.healthec.project.spec.CreateDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.healthec.project.spec.CreateDriver.deviceType;
import static com.healthec.project.spec.CreateDriver.platform;

public class Login_Recovery extends TestBaseClass {

    public static LoginPageObjects lps ;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static boolean flag;
    public static WebDriverWait wait;
    public static RemoteWebDriver driver;



    public static boolean checkForUsernamePasswordAndLogin(RemoteWebDriver driver1)  {
        flag = false;
        driver=driver1;
        lps = new LoginPageObjects(driver);
        testClassName="LoginPageUC";

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            if (FieldValidation.elementValidation(driver, lps.username_txt_field, testClassName, testMethodName).isDisplayed() && FieldValidation.elementValidation(driver, lps.password_txt_field, testClassName, testMethodName).isDisplayed()) {
                if (FieldValidation.elementValidation(driver, lps.login_btn, testClassName, testMethodName).isDisplayed()) {
                    log.info("App is in login page");
                    flag = true;
                }
            }
        } catch (Exception e) {
            log.info("Login Page contents not displaying " + e.getMessage());
            log.info("Relaunching application: ");
            driver= CreateDriver.getDriver(platform,deviceType);
            lps = new LoginPageObjects(driver);
            try {
                SwitchView.changeContext(driver, "WEBVIEW");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                if (FieldValidation.elementValidation(driver, lps.username_txt_field, testClassName, testMethodName).isDisplayed() && FieldValidation.elementValidation(driver, lps.password_txt_field, testClassName, testMethodName).isDisplayed()) {
                    if (FieldValidation.elementValidation(driver, lps.login_btn, testClassName, testMethodName).isDisplayed()) {
                        log.info("App is in login page now");
                        flag = true;
                    }
                }
            } catch (Exception e1) {
                log.info("Unable to find login page contents:" + e1.getMessage());
                flag=false;
            }

        }
        return flag;
    }

    public static boolean checkForLoginFunctionality(RemoteWebDriver driver) {

        flag= false;
        lps = new LoginPageObjects(driver);
        wait= new WebDriverWait(driver,10);
        try{
            if(FieldValidation.elementValidation(driver,lps.login_In_Check,testClassName,testMethodName).isDisplayed()){
                log.info("App is logged in and dashboard is displayed");
                flag=true;
            }
        }catch(Exception e){
            log.info("Dashboard page not displaying: "+e.getMessage());
            log.info("Checking whether app is in login page ");
            flag = checkForUsernamePasswordAndLogin(driver);
            if(flag==true) {
                /*System.out.println("Inside ");
                System.out.println("Excel data: "+ExcelUtility.readTestdata(testdataSheet, testClassName, 1, 0));
                System.out.println("testdata: "+testdataSheet+","+"testclassname: "+testClassName);*/
                FieldValidation.elementValidation(driver, lps.username_txt_field, testClassName, testMethodName).clear();
                FieldValidation.elementValidation(driver, lps.username_txt_field, testClassName, testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "LoginPageUC", 1, 0));
                FieldValidation.elementValidation(driver, lps.password_txt_field, testClassName, testMethodName).clear();
                FieldValidation.elementValidation(driver, lps.password_txt_field, testClassName, testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "LoginPageUC", 1, 1));
                HideKeyBoard.hideKeyBoard(driver);
                FieldValidation.elementValidation(driver, lps.login_btn, testClassName, testMethodName).click();
                try {
                    if (FieldValidation.elementValidation(driver, lps.login_In_Check, testClassName, testMethodName).isDisplayed()) {
                        log.info("App is logged in and dashboard is displayed");
                        flag = true;
                    }
                } catch (Exception e1) {
                    log.info("Unable to find dashboard " + e1.getMessage());
                    flag = false;
                }
            }
        }

        return flag;
    }


}

