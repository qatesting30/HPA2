package com.healthec.project.Resources;

import com.healthec.UI.FieldValidation;
import com.healthec.generic.utils.TestBaseClass;
import com.healthec.object.repo.DashboardPageObjects;
import com.healthec.object.repo.ProfilePageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageRefresh extends TestBaseClass {

    public static RemoteWebDriver driver;
    public static DashboardPageObjects dps;
    public static ProfilePageObjects ps;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    public static void dashboardPageRefresh(RemoteWebDriver driver1) {
        Menu_recovery.checkForMenu(driver1);
        driver=Menu_recovery.driver;
        dps = new DashboardPageObjects(driver);
        log.info("Clicking on menu btn");
        FieldValidation.elementValidation(driver, dps.menu_btn, testClassName, testMethodName).click();
        log.info("Clicking on home tab");
        FieldValidation.elementValidation(driver, dps.home_tab, testClassName, testMethodName).click();

    }

    public static boolean profilePageRefresh(RemoteWebDriver driver1) {
       boolean flag= Menu_recovery.checkForMenu(driver1);
       if(flag==true) {
           driver = Menu_recovery.driver;
           dps = new DashboardPageObjects(driver);
           ps = new ProfilePageObjects(driver);
           log.info("Clicking on menu btn");
           FieldValidation.elementValidation(driver, dps.menu_btn, testClassName, testMethodName).click();
           log.info("Clicking on profile tab");
           FieldValidation.elementValidation(driver, ps.profile_tab, testClassName, testMethodName).click();
       }
       else{
           log.info("unable to refresh profile page");
       }
       return flag;
    }

    public static boolean contactPageRefresh(RemoteWebDriver driver){
        boolean flag =profilePageRefresh(driver);
        log.info("Clicking on contacts menu");
        try {
            if (flag == true) {
                FieldValidation.elementValidation(driver, ps.contacts_menu, testClassName, testMethodName).click();
            }
        }
        catch(Exception e){
            log.info("unable to refresh contact page");
        }
        return flag;
    }

    public static boolean physicianPageRefresh(RemoteWebDriver driver){
        boolean flag =profilePageRefresh(driver);
        log.info("Clicking on physician menu");
        try {
            if (flag == true) {
                FieldValidation.elementValidation(driver, ps.physicians_tab, testClassName, testMethodName).click();
            }
        }
        catch(Exception e){
            log.info("unable to refresh contact page");
        }
        return flag;
    }

    public static boolean pharmacyPageRefresh(RemoteWebDriver driver){
        boolean flag =profilePageRefresh(driver);
        log.info("Clicking on physician menu");
        try {
            if (flag == true) {
                FieldValidation.elementValidation(driver, ps.pharmacy_tab, testClassName, testMethodName).click();
            }
        }
        catch(Exception e){
            log.info("unable to refresh contact page");
        }
        return flag;
    }
}
