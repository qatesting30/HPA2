package com.healthec.project.Resources;

import com.healthec.UI.FieldValidation;
import com.healthec.generic.utils.TestBaseClass;
import com.healthec.object.repo.DashboardPageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import sun.rmi.runtime.Log;


import java.util.concurrent.TimeUnit;

public class Dashboard_Recovery extends TestBaseClass{

    public static RemoteWebDriver driver;
    public static DashboardPageObjects dps ;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static boolean flag;


    public static boolean checkForDashboardPage(RemoteWebDriver driver) {
        flag = false;
        dps = new DashboardPageObjects(driver);
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try{
                if (FieldValidation.elementValidation(driver, dps.calender_section, testClassName, testMethodName).isDisplayed()) {
                    log.info("App is in dashboard apge");
                    flag = true;
            }

            }catch(Exception e)
            {
                log.info("Didn't find dashboard page, refreshng the page");
                PageRefresh.dashboardPageRefresh(driver);
            }
            if (FieldValidation.elementValidation(driver, dps.calender_section, testClassName, testMethodName).isDisplayed()) {
                log.info("App is in dashboard apge");
                flag = true;
            }
        } catch (Exception e) {
            log.info("Unable to find dashboard: " + e.getMessage());
            log.info("Checking whether app is logged in  ");
            flag = Login_Recovery.checkForLoginFunctionality(driver);
            driver = Login_Recovery.driver;
            dps=new DashboardPageObjects(driver);//
            if(flag==true){
                if (FieldValidation.elementValidation(driver, dps.calender_section, testClassName, testMethodName).isDisplayed()) {
                    log.info("App is in dashboard ");
                    flag = true;
                }
                else
                    log.info("Unable to find dashboard ");
                    flag=false;
            }
        }
        return flag;
    }
}
