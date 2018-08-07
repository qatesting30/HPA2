package com.healthec.project.Resources;

import com.healthec.UI.FieldValidation;
import com.healthec.generic.utils.TestBaseClass;
import com.healthec.object.repo.ProfilePageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Profile_Recovery extends TestBaseClass {

    public static RemoteWebDriver driver;
    public static ProfilePageObjects ps ;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static boolean flag;

    public static boolean checkForProfilePage(RemoteWebDriver driver) {
        flag = false;
        ps = new ProfilePageObjects(driver);
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                if (FieldValidation.elementValidation(driver, ps.profile_page, testClassName, testMethodName).isDisplayed()) {
                    log.info("Profile page displaying");
                    flag = true;
                }
            }
            catch(Exception e) {
                log.info("refreshing for profile page");
                flag=PageRefresh.profilePageRefresh(driver);
            }
            if (FieldValidation.elementValidation(driver, ps.profile_page, testClassName, testMethodName).isDisplayed()) {
                log.info("Profile page displaying");
                flag = true;
            }
        } catch (Exception e) {
            log.info("Profile page not displaying: " + e.getMessage());
            log.info("Checking whether app is logged in");
            flag = Login_Recovery.checkForLoginFunctionality(driver);
            driver=Login_Recovery.driver;
            ps = new ProfilePageObjects(driver);
            if(flag==true) {
                PageRefresh.profilePageRefresh(driver);
                try{
                if (FieldValidation.elementValidation(driver, ps.profile_page, testClassName, testMethodName).isDisplayed()) {
                    log.info("Profile page displaying");
                    flag = true;
                } }catch(Exception e1) {
                    log.info("Unable to find profile page:"+e1.getMessage());
                    flag = false;
                }
            }
        }
        //System.out.println("flag2: "+flag);
        return flag;
    }

    public static boolean checkForcontactsPage(RemoteWebDriver driver){
        flag = false;
        ps = new ProfilePageObjects(driver);

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                if (FieldValidation.elementValidation(driver, ps.contacts_page, testClassName, testMethodName).isDisplayed()) {
                    log.info("App is in contacts page");
                    flag = true;
                }
            }
            catch(Exception e1){
                log.info("Didn't found contacts page, refreshing page");
                PageRefresh.contactPageRefresh(driver);
            }
            if (FieldValidation.elementValidation(driver, ps.contacts_page, testClassName, testMethodName).isDisplayed()) {
                log.info("App is in contacts page");
                flag = true;
            }
        } catch (Exception e) {
            log.info("Contacts page not displaying " + e.getMessage());
            log.info("Checking whether app is in profile page");
            flag = checkForProfilePage(driver);
            if(flag==true) {
                FieldValidation.elementValidation(driver, ps.contacts_menu, testClassName, testMethodName).click();
                try {
                    if (FieldValidation.elementValidation(driver, ps.contacts_page, testClassName, testMethodName).isDisplayed()) {
                        log.info("Now app is in contacts page");
                        flag = true;
                    }
                }catch(Exception e1) {
                    log.info("unable to find contacts page"+e1.getMessage());
                    flag = false;
                }
            }

        }
       return flag;
    }

    public static boolean checkForSelectedPersonalTab(RemoteWebDriver driver) {
          flag = false;
          ps = new ProfilePageObjects(driver);

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                if (FieldValidation.elementValidation(driver, ps.personal_tab_selected, testClassName, testMethodName).isDisplayed()) {
                    log.info("selected personal tab is displaying");
                    flag = true;
                }
            }
            catch(Exception e1){
                log.info("Didn't found selected personal tab, refreshing page");
                PageRefresh.contactPageRefresh(driver);
            }
            if (FieldValidation.elementValidation(driver, ps.personal_tab_selected, testClassName, testMethodName).isDisplayed()) {
                log.info("selected personal tab is displaying");
                flag = true;
            }
        } catch (Exception e) {
            log.info("Personal tab not displaying " + e.getMessage());
            log.info("Checking whether app is in contact page");
            flag = checkForcontactsPage(driver);
            if(flag==true) {
                FieldValidation.elementValidation(driver, ps.personal_tab, testClassName, testMethodName).click();
                try {
                    if (FieldValidation.elementValidation(driver, ps.personal_tab_selected, testClassName, testMethodName).isDisplayed()) {
                        log.info("Now selected personal tab is displaying");
                        flag = true;
                    }
                }catch(Exception e1) {
                    log.info("unable to find personal tab "+e1.getMessage());
                    flag = false;
                }
            }

        }
        return flag;
    }

    public static boolean checkForSelectedEmergencyTab(RemoteWebDriver driver) {
        flag = false;
        ps = new ProfilePageObjects(driver);

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                if (FieldValidation.elementValidation(driver, ps.emergency_tab_selected, testClassName, testMethodName).isDisplayed()) {
                    log.info("selected emergency tab is displaying");
                    flag = true;
                }
            }
            catch(Exception e1){
                log.info("Didn't found selected emergency tab, refreshing page");
                PageRefresh.contactPageRefresh(driver);
            }
            if (FieldValidation.elementValidation(driver, ps.emergency_tab_selected, testClassName, testMethodName).isDisplayed()) {
                log.info("selected personal tab is displaying");
                flag = true;
            }
        } catch (Exception e) {
            log.info("emergency tab not displaying " + e.getMessage());
            log.info("Checking whether app is in contact page");
            flag = checkForcontactsPage(driver);
            if(flag==true) {
                FieldValidation.elementValidation(driver, ps.emergency_tab, testClassName, testMethodName).click();
                try {
                    if (FieldValidation.elementValidation(driver, ps.emergency_tab_selected, testClassName, testMethodName).isDisplayed()) {
                        log.info("Now selected personal tab is displaying");
                        flag = true;
                    }
                }catch(Exception e1) {
                    log.info("unable to find personal tab: "+e1.getMessage());
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static boolean checkForPhysiciansPage(RemoteWebDriver driver) {
        flag = false;
        ps = new ProfilePageObjects(driver);
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                if (FieldValidation.elementValidation(driver, ps.physicians_page, testClassName, testMethodName).isDisplayed()) {
                    log.info("Physicians page is displaying");
                    flag = true;
                }
            }
            catch(Exception e1){
                log.info("Didn't found physicians page, refreshing page");
                PageRefresh.physicianPageRefresh(driver);
            }
            if (FieldValidation.elementValidation(driver, ps.physicians_page, testClassName, testMethodName).isDisplayed()) {
                log.info("Physicians page is displaying");
                flag = true;
            }
        } catch (Exception e) {
            log.info("Physicians page not displaying " + e.getMessage());
            log.info("Checking whether app is in profile page");
            flag = checkForProfilePage(driver);
            if(flag==true) {
                FieldValidation.elementValidation(driver, ps.physicians_tab, testClassName, testMethodName).click();
                try {
                    if (FieldValidation.elementValidation(driver, ps.physicians_page, testClassName, testMethodName).isDisplayed()) {
                        log.info("Now physicians page is displaying");
                        flag = true;
                    }
                }catch(Exception e1) {
                    log.info("unable to find physicians page "+e1.getMessage());
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static boolean checkForPharmacyPage(RemoteWebDriver driver) {
        flag = false;
        ps = new ProfilePageObjects(driver);
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                if (FieldValidation.elementValidation(driver, ps.pharmacy_page, testClassName, testMethodName).isDisplayed()) {
                    log.info("pharmacy page is displaying");
                    flag = true;
                }
            }
            catch(Exception e1){
                log.info("Didn't found pharmacy page, refreshing page");
                PageRefresh.pharmacyPageRefresh(driver);
            }
            if (FieldValidation.elementValidation(driver, ps.pharmacy_page, testClassName, testMethodName).isDisplayed()) {
                log.info("pharmacy page is displaying");
                flag = true;
            }
        } catch (Exception e) {
            log.info("pharmacy page not displaying " + e.getMessage());
            log.info("Checking whether app is in profile page");
            flag = checkForProfilePage(driver);
            if(flag==true) {
                FieldValidation.elementValidation(driver, ps.pharmacy_tab, testClassName, testMethodName).click();
                try {
                    if (FieldValidation.elementValidation(driver, ps.pharmacy_page, testClassName, testMethodName).isDisplayed()) {
                        log.info("Now pharmacy page is displaying");
                        flag = true;
                    }
                }catch(Exception e1) {
                    log.info("unable to find pharmacy page "+e1.getMessage());
                    flag = false;
                }
            }
        }
        return flag;
    }
}
