package com.healthec.project.Resources;

import com.healthec.UI.FieldValidation;
import com.healthec.generic.utils.TestBaseClass;
import com.healthec.object.repo.DashboardPageObjects;
import com.healthec.object.repo.LoginPageObjects;
import com.healthec.project.spec.CreateDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import static com.healthec.project.spec.CreateDriver.deviceType;
import static com.healthec.project.spec.CreateDriver.platform;

public class Menu_recovery extends TestBaseClass {

    public static RemoteWebDriver driver;
    public static LoginPageObjects lps;
    public static DashboardPageObjects dps;
    public static boolean flag;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    public static boolean checkForMenu(RemoteWebDriver driver1) {
        driver = driver1;
        dps = new DashboardPageObjects(driver);
        flag = false;
        try {
            if (FieldValidation.elementValidation(driver, dps.menu_btn, testClassName, testMethodName).isDisplayed()) {
                log.info("menu btn displaying");
                flag = true;
            }
        } catch (Exception e) {
            log.info("Unable to find menu btn: " + e.getMessage());
            log.info("Checking for login  ");
            flag = Login_Recovery.checkForLoginFunctionality(driver);
            driver=Login_Recovery.driver;
            dps=new DashboardPageObjects(driver);
            try {
                if (FieldValidation.elementValidation(driver, dps.menu_btn, testClassName, testMethodName).isDisplayed()) {
                    log.info("menu btn displaying");
                    flag = true;
                }
            } catch (Exception e1) {
                log.info("Unable to find menu btn: " + e1.getMessage());
                flag=false;
            }

        }
        return flag;
    }
}
