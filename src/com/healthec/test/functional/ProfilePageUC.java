package com.healthec.test.functional;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.healthec.UI.*;
import com.healthec.UI.NoRecordsFound;
import com.healthec.UI.PhoneNumber;
import com.healthec.UI.Swipe;
import com.healthec.generic.Functions.Profile_Functions;
import com.healthec.generic.utils.*;
import com.healthec.generic.utils.Scroll;
import com.healthec.object.repo.HealthTrackerPageObjects;
import com.healthec.object.repo.LoginPageObjects;
import com.healthec.object.repo.ProfilePageObjects;
import com.healthec.project.Resources.Login_Recovery;
import com.healthec.project.Resources.PageRefresh;
import com.healthec.project.Resources.Profile_Recovery;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.healthec.test.functional.LoginPageUC.driver;

public class ProfilePageUC extends TestBaseClass {

    public static WebDriverWait wait;
    public static ProfilePageObjects pgs;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static String instance;
    public static LoginPageObjects lps;
    public static HealthTrackerPageObjects hps;

    @BeforeClass(alwaysRun = true)
    public void beforeProfilePageClass() {
        log.info("Checking for profile page");
        Profile_Recovery.checkForProfilePage(driver);
        driver= Login_Recovery.driver;
        pgs = new ProfilePageObjects(driver);
        lps = new LoginPageObjects(driver);
        hps = new HealthTrackerPageObjects(driver);
    }

    @BeforeTest(alwaysRun = true,dependsOnGroups = {"login"})
    public static void beforeProfilePageTest() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = (WebDriverWait) new WebDriverWait(driver, 30);
    }
    //profile-tab

    @Test(enabled = true,groups = {"smoke","regression"})
    public static void profilePageTC_001() {
        log.info("navigating to profile page");
        PageRefresh.profilePageRefresh(driver);
        log.info("Validating whether profile sub menus displaying");
        FieldValidation.elementValidation(driver,pgs.profile_page,testClassName,testMethodName).isDisplayed();

    }

    @Test(enabled = true,groups = {"smoke"})
    public static void profilePageTC_002() {
        log.info("Validating profile submenus");
        FieldValidation.elementValidation(driver,pgs.profile_sub_menus,testClassName,testMethodName).isDisplayed();
    }

    //personal
    @Test(enabled = true,groups = {"smoke","regression"})
    public static void profilePageTC_003() {
        log.info("Validating contacts page");
        FieldValidation.elementValidation(driver,pgs.contacts_menu,testClassName,testMethodName).click();
        log.info("Validating personal contacts");
        FieldValidation.elementValidation(driver,pgs.personal_tab,testClassName,testMethodName).isDisplayed();
    }
    @Test(enabled = true,groups = {"smoke"})
    public static void profilePageTC_004() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating personal contacts total fields");
        Assert.assertTrue(pgs.personal_contacts_total_fields.isDisplayed());
    }

    @Test(enabled = true,groups = {"smoke","regression"})
    public static void profilePageTC_005() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("swiping down");
        Swipe.swipeVerticalDown(driver, 5);
        log.info("clicking on edit button");
        FieldValidation.elementValidation(driver,pgs.personal_editAndUpdate_btn,testClassName,testMethodName).click();
        log.info("Swiping up");
        Swipe.swipeVerticalUp(driver, 5);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_006() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        log.info("Clearing personal phone number field");
        FieldValidation.elementValidation(driver,pgs.personal_phone_number,testClassName,testMethodName).clear();
        log.info("Entering data in personal phone number field");
        FieldValidation.elementValidation(driver,pgs.personal_phone_number,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 1));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_007() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        log.info("email: " + pgs.personal_email.getAttribute("value"));
        log.info("Validating whther email data is already entered");
        Assert.assertTrue(pgs.personal_email.getAttribute("value").length() > 0);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_008() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        log.info("Clearing personal email field");
        FieldValidation.elementValidation(driver,pgs.personal_email,testClassName,testMethodName).clear();
        log.info("Entering data in personal email field");
        FieldValidation.elementValidation(driver,pgs.personal_email,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 2));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_009() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        log.info("Clearing personal address field");
        FieldValidation.elementValidation(driver,pgs.personal_address,testClassName,testMethodName).clear();
        log.info("Entering data in personal address field");
        FieldValidation.elementValidation(driver,pgs.personal_address,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 3));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_010() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        log.info("Clearing personal city field");
        FieldValidation.elementValidation(driver,pgs.personal_city,testClassName,testMethodName).clear();
        log.info("Entering data in personal city field");
        FieldValidation.elementValidation(driver,pgs.personal_city,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 4));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_011() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        log.info("Clearing personal zip code field");
        FieldValidation.elementValidation(driver,pgs.personal_zip_code,testClassName,testMethodName).clear();
        log.info("Entering data in zip code field");
        FieldValidation.elementValidation(driver,pgs.personal_zip_code,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 6));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_012() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        log.info("Clicking on personal state drop down");
        FieldValidation.elementValidation(driver,pgs.personal_state,testClassName,testMethodName).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_013() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            log.info("Scrolling for android");
            Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 5));
        } else if (instance.contains("IOSDriver")) {
            log.info("Selecting drop down option in ios");
            Select dropdown = new Select(driver.findElement(By.id("state")));
            dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 5));

        } else {
            log.info("Unable to find dropdown data");
        }
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_014() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        log.info("Clicking on personal cancel button");
        FieldValidation.elementValidation(driver,pgs.personal_cancel_btn,testClassName,testMethodName).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_015() {
        log.info("Validating whether app is in personal contacts page");
        Profile_Recovery.checkForSelectedPersonalTab(driver);
        log.info("Clicking on personal edit button");
        FieldValidation.elementValidation(driver,pgs.personal_editAndUpdate_btn,testClassName,testMethodName).click();
        log.info("Clicking on personal update button");
        FieldValidation.elementValidation(driver,pgs.personal_editAndUpdate_btn,testClassName,testMethodName).click();
        log.info("validating wheather added successfully pop is displaying");
        FieldValidation.elementValidation(driver,pgs.personal_added_successfully_popUp,testClassName,testMethodName);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_016() {
       try{
           log.info("Validating whether added successfully pop up displaying");
           FieldValidation.elementValidation(driver,pgs.personal_added_successfully_popUp,testClassName,testMethodName).isDisplayed();
           log.info("Pop is displaying");
       }catch(Exception e){
           log.info("Pop not displaying");
           profilePageTC_015();
       }
       log.info("Clicking on personal added ok button in pop up");
        FieldValidation.elementValidation(driver,pgs.personal_added_successfully_btn_ok,testClassName,testMethodName).click();
    }

    //Emergency
    @Test(enabled = true,groups = {"smoke","regression"})
    public static void profilePageTC_017() {
        log.info("Validating whether app is in contacts page");
        Profile_Recovery.checkForcontactsPage(driver);
        log.info("Clicking on emergency tab");
        FieldValidation.elementValidation(driver,pgs.emergency_tab,testClassName,testMethodName).click();
        log.info("validating emegergency total field contents");
        Assert.assertTrue(pgs.emergency_field_total_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_018() {
        log.info("Validating whether app is in emergency page");
        Profile_Recovery.checkForSelectedEmergencyTab(driver);
        log.info("Swiping down");
        Swipe.swipeVerticalDown(driver, 5);
        log.info("Clicking on edit button");
        FieldValidation.elementValidation(driver,pgs.emergency_editAndUpdate_btn,testClassName,testMethodName).click();
        log.info("Swiping up");
        Swipe.swipeVerticalUp(driver, 5);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_019() {
        log.info("Validating whether app is in emergency page");
        Profile_Recovery.checkForSelectedEmergencyTab(driver);
        log.info("Validating whether page is editable");
        Profile_Functions.checkContactsPageEditable(driver);
        log.info("Clearing on emergency first name field");
        FieldValidation.elementValidation(driver,pgs.emergency_firstname,testClassName,testMethodName).clear();
        log.info("Entering data on emergency first name");
        FieldValidation.elementValidation(driver,pgs.emergency_firstname,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 7));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clearing on emergency last name field");
        FieldValidation.elementValidation(driver,pgs.emergency_lastname,testClassName,testMethodName).clear();
        log.info("Entering data on emergency last name field");
        FieldValidation.elementValidation(driver,pgs.emergency_lastname,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 8));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clearing emergency phone number field");
        FieldValidation.elementValidation(driver,pgs.emergency_phone_number,testClassName,testMethodName).clear();
        log.info("Entering data on emergency phone number field");
        FieldValidation.elementValidation(driver,pgs.emergency_phone_number,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 9));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clearing emergency email field");
        FieldValidation.elementValidation(driver,pgs.emergency_email,testClassName,testMethodName).clear();
        log.info("Entering data on emergency email field");
        FieldValidation.elementValidation(driver,pgs.emergency_email,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 10));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clearing emergency street field");
        FieldValidation.elementValidation(driver,pgs.emergency_street,testClassName,testMethodName).clear();
        log.info("Entering data on emergency street field");
        FieldValidation.elementValidation(driver,pgs.emergency_street,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 11));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clearing emergency city field");
        FieldValidation.elementValidation(driver,pgs.emergency_city,testClassName,testMethodName).clear();
        log.info("Entering data on emergency city field");
        FieldValidation.elementValidation(driver,pgs.emergency_city,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 12));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clicking emergency state field");
        FieldValidation.elementValidation(driver,pgs.emergency_state,testClassName,testMethodName).click();
        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            log.info("Scrolling in android");
            Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 13));
        } else if (instance.contains("IOSDriver")) {
            log.info("Selecting drop down options in ios");
            Select dropdown = new Select(driver.findElement(By.id("state")));
            dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 13));

        } else {
            log.info("Unable to find dropdown data");
            log.info("Unable to find dropdown data");
        }
        log.info("Clearing emergency zip code");
        FieldValidation.elementValidation(driver,pgs.emergency_zip_code,testClassName,testMethodName).clear();
        log.info("Entering data in emergency code");
        FieldValidation.elementValidation(driver,pgs.emergency_zip_code,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Contacts", 2, 14));
        log.info("Hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clicking on emergency cancel button");
        FieldValidation.elementValidation(driver,pgs.emergency_cancel_btn,testClassName,testMethodName).click();
        log.info("Clicking on emergency edit button");
        FieldValidation.elementValidation(driver,pgs.emergency_editAndUpdate_btn,testClassName,testMethodName).click();
        log.info("Clicking on emergency update button");
        FieldValidation.elementValidation(driver,pgs.emergency_update_btn,testClassName,testMethodName).click();
    }
    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_020() {
        try{
            log.info("Clicking whether updated successfully pop up displaying");
            if(FieldValidation.elementValidation(driver,pgs.emergency_updated_sucessfully_popup_ok_btn,testClassName,testMethodName).isDisplayed()){
                log.info("Clicking on ok button in updated successfully pop up");
                FieldValidation.elementValidation(driver,pgs.emergency_updated_sucessfully_popup_ok_btn,testClassName,testMethodName).click();
            }
        }catch(Exception e) {
            profilePageTC_019();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            log.info("Clicking on ok button in updated successfully pop up");
            FieldValidation.elementValidation(driver, pgs.emergency_updated_sucessfully_popup_ok_btn, testClassName, testMethodName).click();
        }
    }

    //physicians
    @Test(enabled = true,groups = {"regression","smoke"})
    public static void profilePageTC_021()  {
        log.info("Checking for physician page");
        Profile_Recovery.checkForPhysiciansPage(driver);
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            log.info("Checking for any record available");
            if (NoRecordsFound.noRecordsFoundMsg(driver).isDisplayed()) {
                log.info("No Records Present");
            }
        } catch (Exception e) {
            log.info("Exception in finding element: "+e.getMessage());
        }
    }

    @Test(enabled = true,groups = {"smoke"})
    public static void profilePageTC_022() {
        log.info("Checking for physician page");
        Profile_Recovery.checkForPhysiciansPage(driver);
        log.info("Validating contents of physicians records");
        try {
            FieldValidation.elementValidation(driver, pgs.physicians_records_grid_contents, testClassName, testMethodName).click();
        } catch (Exception e) {
            log.info("Exception in finding element: "+e.getMessage());
        }
    }
    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_023() {
        log.info("Checking for physician page");
        Profile_Recovery.checkForPhysiciansPage(driver);
        log.info("Clicking on physicians add icon");
        FieldValidation.elementValidation(driver,pgs.add_physicians_icon,testClassName,testMethodName).click();
        log.info("Validating whether contents of physicians add page displaying or not ");
        Assert.assertTrue(pgs.physicians_page_contents.isDisplayed());
    }
    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_024() {
        try{
            log.info("Checking whether physician add page is displaying");
            if(FieldValidation.elementValidation(driver,pgs.add_physician_btn,testClassName,testMethodName).isDisplayed()){
                log.info("Physician add page displaying");
            }
        }
        catch(Exception e){
            log.info("Physician add page not displaying "+e.getMessage());
            profilePageTC_023();
        }
        log.info("Swiping vertically down");
        Swipe.swipeVerticalDown(driver, 3);
        log.info("Clicking on physicians type drop down");
        FieldValidation.elementValidation(driver,pgs.physician_type_dropdown,testClassName,testMethodName).click();
        log.info("Validating whether physicians type drop down is displaying or not");
        Assert.assertTrue(pgs.physician_type_dropdown_values.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_025() {
        log.info("Checking for instance type");
        instance = driver.getClass().getName();
        try{
            log.info("Checking whether Physician type drop down is displaying");
            if(FieldValidation.elementValidation(driver,pgs.physician_type_dropdown_values,testClassName,testMethodName).isDisplayed()){
               log.info("Physician type drop down is displaying");
            }
        }catch(Exception e){
            log.info("Physician type drop down is not displaying");
            profilePageTC_024();
        }
        if (instance.contains("AndroidDriver")) {
            log.info("Scrolling to get the value");
            Scroll.scrollToText(driver, "Specialist");
        } else if (instance.contains("IOSDriver")) {
            log.info("Clicking on physicians type drop down option");
            Select dropdown = new Select(pgs.physician_type_dropdown);
            dropdown.selectByVisibleText("Specialist");
        } else {
            log.info("Unable to find dropdown data");
        }
        log.info("Swiping down");
        Swipe.swipeVerticalDown(driver, 3);
        log.info("Validating whether speciality field displaying or not");
        FieldValidation.elementValidation(driver,pgs.select_speciality_field,testClassName,testMethodName).isDisplayed();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_026() {
        try{
            if(FieldValidation.elementValidation(driver,pgs.add_physician_btn,testClassName,testMethodName).isDisplayed()){
                log.info("add physician page is displaying");
            }
        }catch(Exception e){
            log.info("add physician page is not displaying");
            profilePageTC_023();
        }
        FieldValidation.elementValidation(driver,pgs.add_physician_btn,testClassName,testMethodName).click();
        log.info("Swiping up");
        Swipe.swipeVerticalUp(driver, 4);
        log.info("Validating whether add physicians warning meassages displaying or not");
        Assert.assertTrue(pgs.add_physicians_warning_msg.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_027() {
        try{
            if(FieldValidation.elementValidation(driver,pgs.add_physician_btn,testClassName,testMethodName).isDisplayed()){
                log.info("add physician page is displaying");
            }
        }catch(Exception e){
            log.info("add physician page is not displaying");
            profilePageTC_023();
        }
        log.info("Clearing lastname text field");
        FieldValidation.elementValidation(driver,pgs.lastname_txt_field,testClassName,testMethodName).clear();
        log.info("Entering data in lastname text field");
        FieldValidation.elementValidation(driver,pgs.lastname_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 0));
        log.info("hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clearing firstname text field");
        FieldValidation.elementValidation(driver,pgs.firstname_txt_field,testClassName,testMethodName).clear();
        log.info("Entering data in firstname text field");
        FieldValidation.elementValidation(driver,pgs.firstname_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 1));
        log.info("hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clearing phone number text field");
        FieldValidation.elementValidation(driver,pgs.phoneNumber_txt_field,testClassName,testMethodName).clear();
        log.info("Entering data in phone number text field");
        FieldValidation.elementValidation(driver,pgs.phoneNumber_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 2));
        log.info("hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clearing email text field");
        FieldValidation.elementValidation(driver,pgs.email_txt_field,testClassName,testMethodName).clear();
        log.info("Entering data in email text field");
        FieldValidation.elementValidation(driver,pgs.email_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 3));
        log.info("hiding keyboard");
        /*HideKeyBoard.hideKeyBoard(driver);
        log.info("Swiping up");
        Swipe.swipeVerticalUp(driver, 3);*/
        log.info("Getting instance type");
        instance = driver.getClass().getName();
        if (instance.contains("AndroidDriver")) {
            log.info("Clicking physician type dropdown");
            FieldValidation.elementValidation(driver,pgs.physician_type_dropdown,testClassName,testMethodName).click();
            log.info("scrolling to option");
            Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 4));
        } else if (instance.contains("IOSDriver")) {
            log.info("selecting physician dropdown option");
            Select dropdown = new Select(pgs.physician_type_dropdown);
            dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 4));

        } else {
            log.info("Unable to find dropdown data");
        }
        log.info("Validating whether data read from excel matching with given option");
        try {
            if (ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 4).equalsIgnoreCase("Specialist")) {
                log.info("Extracted physician type is specialist");
                log.info("Click on speciality field");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.select_speciality_field)).click();
                log.info("getting instance type");
                instance = driver.getClass().getName();
                if (instance.contains("AndroidDriver")) {
                    log.info("Scrolling till option");
                    Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 5));
                } else if (instance.contains("IOSDriver")) {
                    log.info("Selecting options");
                    Select dropdown = new Select(pgs.select_speciality_field);
                    dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 5));

                } else {
                    log.info("Unable to find dropdown data");
                }
            }
        } catch (Exception e) {
            log.info("Exception in getting data or the physican type is not specialist: " + e.getMessage());
        }
        log.info("swiping down");
        Swipe.swipeVerticalDown(driver,3);
        log.info("Clicking on add physician button");
        FieldValidation.elementValidation(driver,pgs.add_physician_btn,testClassName,testMethodName).click();
        log.info("Validating whther added sucessfully pop up displaying");
        FieldValidation.elementValidation(driver,pgs.physician_added_sucessfully_msg_pop_up,testClassName,testMethodName).isDisplayed();
        Assert.assertTrue(pgs.physician_added_sucessfully_msg_pop_up.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_028() {
        try{
            if(FieldValidation.elementValidation(driver,pgs.physician_added_sucessfully_msg_pop_up,testClassName,testMethodName).isDisplayed()){
                log.info("physician added successfully pop up is displaying");
            }
        }catch(Exception e){
            log.info("physician added successfully pop up is not displaying");
            profilePageTC_027();
        }
        log.info("Clicking on physician add more button");
        FieldValidation.elementValidation(driver,pgs.physician_addMore_btn,testClassName,testMethodName).click();
        log.info("Validating whether physician add page displaying");
        Assert.assertTrue(pgs.physician_add_page.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_029() {
        try{
            if(FieldValidation.elementValidation(driver,pgs.physician_added_sucessfully_msg_pop_up,testClassName,testMethodName).isDisplayed()){
                log.info("physician added successfully pop up is displaying");
            }
        }catch(Exception e){
            log.info("physician added successfully pop up is not displaying");
            profilePageTC_027();
        }
        FieldValidation.elementValidation(driver,pgs.physician_updatedSuccessfully_viewInfo_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.physician_results_page,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.physician_results_page.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_030() {
        log.info("Checking for physician page");
        Profile_Recovery.checkForPhysiciansPage(driver);
        FieldValidation.elementValidation(driver,pgs.physician_call_btn,testClassName,testMethodName).click();
        PhoneNumber.phoneNumberValidation(driver);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_031() {
        instance = driver.getClass().getName();
        if (instance.contains("IOSDriver")) {
            SwitchView.changeContext(driver,"NATIVE_APP");
              driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Cancel']")).isDisplayed();
            SwitchView.changeContext(driver,"WEBVIEW");
         }
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_032() {
        instance = driver.getClass().getName();
        if (instance.contains("IOSDriver")) {
            SwitchView.changeContext(driver,"NATIVE_APP");
              driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Call']")).isDisplayed();
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Cancel']")).click();
            SwitchView.changeContext(driver,"WEBVIEW");
        }
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_033() {
        boolean flag = false;
        log.info("Checking for physician page");
        Profile_Recovery.checkForPhysiciansPage(driver);
        String phy_name = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 1)+" "+ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 0);
        log.info("required physician_name: "+phy_name);
        List<WebElement>getPhysician =pgs.physician_recordspage_physician_name;
        for(WebElement pname : getPhysician) {
            System.out.println("pname>>: "+pname.getText());
            try{
                if (pname.getText().equalsIgnoreCase(phy_name)) {
                     flag=true;
                       break;
                }
            }catch(Exception e){
                    log.info("Exception in finding physician: "+e.getMessage());
            }
        }
        if(flag==true){
            log.info("physician found:" + phy_name);
            WebElement editBtn = Profile_Functions.clickElementBasedOnPhysicianName(driver, phy_name);
            editBtn.click();
        }
        if(flag==false){
            log.info("required physician not found, adding physician");
            FieldValidation.elementValidation(driver,pgs.add_physicians_icon,testClassName,testMethodName).click();
            profilePageTC_029();
            log.info("physician found:" + phy_name);
            WebElement editBtn = Profile_Functions.clickElementBasedOnPhysicianName(driver, phy_name);
            editBtn.click();
        }
        Profile_Functions.addPhysician(driver,pgs);
        FieldValidation.elementValidation(driver,pgs.physician_update_successfully_btn,testClassName,testMethodName).isDisplayed();
        FieldValidation.elementValidation(driver,pgs.physician_update_successfully_btn,testClassName,testMethodName).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_034() {
        boolean flag = false;
        try{
            log.info("Checking for updated sucessfully pop up in add physician page");
            if(FieldValidation.elementValidation(driver,pgs.physician_update_successfully_btn,testClassName,testMethodName).isDisplayed()){
                log.info("physician added successfully pop up is displaying");
            }
        }catch(Exception e){
            log.info("physician added successfully pop up is not displaying");
            Profile_Functions.addPhysician(driver,pgs);
        }
        FieldValidation.elementValidation(driver,pgs.physician_update_successfully_btn,testClassName,testMethodName).click();//physicians_page
        String phy_name = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 1)+" "+ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 0);
        try{
            if(FieldValidation.elementValidation(driver,pgs.physicians_page,testClassName,testMethodName).isDisplayed()){
                log.info("physicians record list page displaying");
            }
        }catch(Exception e){
            log.info("physicians record list page not displaying "+e.getMessage());
            Profile_Recovery.checkForPhysiciansPage(driver);
        }
        List<WebElement>getPhysician =pgs.physician_recordspage_physician_name;
        for(WebElement pname : getPhysician) {
            System.out.println("pname>>: "+pname.getText());
            try{
                if (pname.getText().equalsIgnoreCase(phy_name)) {
                    flag=true;
                    break;
                }
            }catch(Exception e){
                log.info("Exception in finding physician: "+e.getMessage());
            }
        }
        if(flag==true){
            log.info("physician found:" + phy_name);
            WebElement editBtn = Profile_Functions.clickElementBasedOnPhysicianName(driver, phy_name);
            editBtn.click();
        }
        if(flag==false) {
            log.info("required physician not found, adding physician");
            FieldValidation.elementValidation(driver, pgs.add_physicians_icon, testClassName, testMethodName).click();
            profilePageTC_029();
            log.info("physician found:" + phy_name);
            WebElement editBtn = Profile_Functions.clickElementBasedOnPhysicianName(driver, phy_name);
            editBtn.click();
        }
        log.info("fetching updated phone number from excel");
        String dataFromApp=FieldValidation.elementValidation(driver,pgs.phoneNumber_txt_field,testClassName,testMethodName).getAttribute("value");
        log.info("fetching phone number from application");
        String dataFromExcel = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 6);
        log.info("Checjking whether phone number field is having updated phone number");
        Assert.assertEquals(dataFromApp,dataFromExcel);
    }
    @Test(enabled = true,groups = {"regression","smoke"})
    public static void profilePageTC_035() {
        log.info("Checking for pharmacy page");
       Profile_Recovery.checkForPharmacyPage(driver);
       try {
           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           if (NoRecordsFound.noRecordsFoundMsg(driver).isDisplayed()) {
                log.info("No Records Present");
            }
        } catch (Exception e) {
            log.info("No Records found message is not displaying " + e.getMessage());
        }
    }
    @Test(enabled = true,groups = {"smoke"})
    public static void profilePageTC_036() {
        log.info("Checking for pharmacy page");
        Profile_Recovery.checkForPharmacyPage(driver);
        try {
            if(NoRecordsFound.RecordsAvailableMsg(driver).isDisplayed()) {
                Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
                 log.info("Records present in pharmacy page");
            }

        } catch (Exception e) {
            log.info("exception in finding records " + e.getMessage());
        }

    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_037() {
        log.info("Checking for pharmacy page");
        Profile_Recovery.checkForPharmacyPage(driver);
        FieldValidation.elementValidation(driver,pgs.pharmacy_add_icon,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.add_pharmacy_page_contents,testClassName,testMethodName).isDisplayed();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_038() {
        log.info("Swiping down");
        Swipe.swipeVerticalDown(driver,3);
        try{
            if(FieldValidation.elementValidation(driver,pgs.add_pharmacy_btn,testClassName,testMethodName).isDisplayed()){
               log.info("pharmacy add page is displaying");
            }
        }catch(Exception e){
            log.info("pharmacy add page is not displaying");
            profilePageTC_037();
        }
        log.info("Swiping down");
        Swipe.swipeVerticalDown(driver,3);
        FieldValidation.elementValidation(driver,pgs.add_pharmacy_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.pharmacy_provideAlldetains_warning_msg,testClassName,testMethodName).isDisplayed();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_039() {
        log.info("Swiping down");
        Swipe.swipeVerticalDown(driver,3);
        try{
            if(FieldValidation.elementValidation(driver,pgs.add_pharmacy_btn,testClassName,testMethodName).isDisplayed()){
                log.info("pharmacy add page is displaying");
            }
        }catch(Exception e){
            log.info("pharmacy add page is not displaying");
            profilePageTC_037();
        }
        Profile_Functions.addPharmacy(driver,pgs);
        FieldValidation.elementValidation(driver,pgs.pharmacy_add_successfully_msg_popUp,testClassName,testMethodName).isDisplayed();
        FieldValidation.elementValidation(driver,pgs.pharmacy_viewInfo_btn,testClassName,testMethodName).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_040() {
        try{
            if(FieldValidation.elementValidation(driver,pgs.pharmacy_add_successfully_msg_popUp,testClassName,testMethodName).isDisplayed()){
              log.info("pharmacy added successfully message pop up id displaying");
            }
        }catch(Exception e){
            log.info("pharmacy added successfully message pop up id displaying");
            Profile_Functions.addPharmacy(driver,pgs);
        }
        FieldValidation.elementValidation(driver,pgs.pharmacy_addMore_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.add_pharmacy_page_contents,testClassName,testMethodName).isDisplayed();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_041() {

        FieldValidation.elementValidation(driver,pgs.pharmacy_pharmacy_name_txt_field,testClassName,testMethodName).clear();
        FieldValidation.elementValidation(driver,pgs.pharmacy_pharmacy_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 0));
        FieldValidation.elementValidation(driver,pgs.pharmacy_contact_person_text_field,testClassName,testMethodName).clear();
        FieldValidation.elementValidation(driver,pgs.pharmacy_contact_person_text_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 1));
        FieldValidation.elementValidation(driver,pgs.pharmacy_phone_number_txt_field,testClassName,testMethodName).clear();
        FieldValidation.elementValidation(driver,pgs.pharmacy_phone_number_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 2));
        FieldValidation.elementValidation(driver,pgs.add_pharmacy_btn,testClassName,testMethodName).click();

        wait.until(ExpectedConditions.visibilityOf(pgs.pharmacy_add_successfully_msg_popUp)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.pharmacy_viewInfo_btn)).click();
        Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_042() {
        FieldValidation.elementValidation(driver,pgs.pharmacy_edit_record,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.pharmacy_update_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_updatedSuccessfully_popUp.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_043() {
        FieldValidation.elementValidation(driver,pgs.pharmacy_updatedSuccessfully_viewInfo_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_044() {
        FieldValidation.elementValidation(driver,pgs.pharmacy_delete_record,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_deleteConfirmation_popup.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_045() {
        FieldValidation.elementValidation(driver,pgs.pharmacy_deleteConfirmation_popup_No_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_046() {
        FieldValidation.elementValidation(driver,pgs.pharmacy_delete_record,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.pharmacy_deleteConfirmation_popup_Yes_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.pharmacy_deleteSuccessfull_ok_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.pharmacy_recordsPage_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression","smoke"})
    public static void profilePageTC_047() {
        FieldValidation.elementValidation(driver,pgs.menu_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.profile_tab,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.insurance_tab,testClassName,testMethodName).click();

        try {

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            if (NoRecordsFound.noRecordsFoundMsg(driver).isDisplayed()) {
                log.info("No Records Present");
            }
        } catch (Exception e) {
            log.info("Exception in finding element: " + e.getMessage());
        }
    }

    @Test(enabled = true,groups = {"smoke"})
    public static void profilePageTC_048() {

        try {
            Assert.assertTrue(NoRecordsFound.RecordsAvailableMsg(driver).isDisplayed());
            Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
            // log.info("checking pharmacy records");

        } catch (Exception e) {
            log.info("Exception in finding element: " + e.getMessage());
        }

    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_049() {
        FieldValidation.elementValidation(driver,pgs.insurarce_add_icon,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_add_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_050() {

        String selectedElement = pgs.selected_insuranceType_value.getAttribute("value");
        log.info("Selected value is: " + selectedElement);
        FieldValidation.elementValidation(driver,pgs.insurarce_insurance_type,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_insurance_type_contents.isDisplayed());
        Scroll.scrollToText(driver, selectedElement);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_051() {

        String selectedElement = pgs.selected_planType_value.getText();
        log.info("Selected value is: " + selectedElement);
        FieldValidation.elementValidation(driver,pgs.insurarce_plan_type,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_plan_type_contents.isDisplayed());
        Scroll.scrollToText(driver, selectedElement);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_052() {
        FieldValidation.elementValidation(driver,pgs.insurarce_addInsurance_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurarce_warning_msg.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_053() {
        FieldValidation.elementValidation(driver,pgs.insurarce_insurance_type,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 0));
        FieldValidation.elementValidation(driver,pgs.insurarce_plan_type,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 1));
        FieldValidation.elementValidation(driver,pgs.insurarce_plan_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 2));
        HideKeyBoard.hideKeyBoard(driver);
        FieldValidation.elementValidation(driver,pgs.insurarce_group_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 3));
        FieldValidation.elementValidation(driver,pgs.insurarce_addInsurance_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurarce_updatedSuccessfully_popUp.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_054() {
        FieldValidation.elementValidation(driver,pgs.insurarce_updatedSuccessfully_popUp_addMore,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_add_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_055() {
        FieldValidation.elementValidation(driver,pgs.insurarce_insurance_type,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 0));
        FieldValidation.elementValidation(driver,pgs.insurarce_plan_type,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 1));
        FieldValidation.elementValidation(driver,pgs.insurarce_plan_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 2));
        FieldValidation.elementValidation(driver,pgs.insurarce_group_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Insurance", 1, 3));
        HideKeyBoard.hideKeyBoard(driver);
        FieldValidation.elementValidation(driver,pgs.insurarce_addInsurance_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.insurarce_updatedSuccessfully_popUp_viewInfo,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_056() {
        FieldValidation.elementValidation(driver,pgs.insurance_editRecord,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.insurance_update_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_updated_sucessfully_popUp.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_057() {
        FieldValidation.elementValidation(driver,pgs.insurance_view_info_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_058() {
        FieldValidation.elementValidation(driver,pgs.insurance_delete_reocrd,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.insurance_deleteRecord_confirmation_popUp_Yes_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.insurance_deletedSucessfully_Ok_btn,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_059() {


        Assert.assertTrue(pgs.insurance_records_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression","smoke"})
    public static void profilePageTC_060() {
        FieldValidation.elementValidation(driver,pgs.menu_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.profile_tab,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.social_history_tab,testClassName,testMethodName).click();
        log.info("social_his: " + pgs.socialHistory_contents.size());
        Assert.assertTrue(pgs.socialHistory_contents.size() == 3);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_061() {

        FieldValidation.elementValidation(driver,pgs.socialHistory_edit_btn,testClassName,testMethodName).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_062() {

        FieldValidation.elementValidation(driver,pgs.socialHistory_drinkAlcohol_checkBox_No,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.socialHistory_smoke_checkBox_No,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.socialHistory_Exercise_checkBox_No,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.socialHistory_drinkAlcohol_checkBox_No.isSelected());
        Assert.assertTrue(pgs.socialHistory_smoke_checkBox_No.isSelected());
        Assert.assertTrue(pgs.socialHistory_Exercise_checkBox_No.isSelected());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_063() {

        FieldValidation.elementValidation(driver,pgs.socialHistory_drinkAlcohol_checkBox_Yes,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.socialHistory_smoke_checkBox_yes,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,pgs.socialHistory_Exercise_checkBox_Yes,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.socialHistory_drinkAlcohol_checkBox_Yes.isSelected());
        Assert.assertTrue(pgs.socialHistory_smoke_checkBox_yes.isSelected());
        Assert.assertTrue(pgs.socialHistory_Exercise_checkBox_Yes.isSelected());
    }


    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_064() {

        FieldValidation.elementValidation(driver,pgs.socialHistory_drinkPerWeek_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.elementValidation(driver,pgs.socialHistory_drinkNoOfyears_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.elementValidation(driver,pgs.socialHistory_smoke_packsPerWeek_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.elementValidation(driver,pgs.socialHistory_smokeNoOfyears_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.elementValidation(driver,pgs.socialHistory_ExercisedayPerWeek_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.elementValidation(driver,pgs.socialHistory_ExerciseType_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.elementValidation(driver,pgs.socialHistory_update_btn,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        Assert.assertTrue(pgs.socialHistory_updated_successfully_popUp.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_065() {

        FieldValidation.elementValidation(driver,pgs.socialHistory_updated_successfully_popUp_ok_btn,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        Assert.assertTrue(pgs.socialHistory_contents.size() == 3);
    }

    @Test(enabled = true,groups = {"regression","smoke"})
    public static void profilePageTC_066() {

        FieldValidation.elementValidation(driver,pgs.menu_btn,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.elementValidation(driver,pgs.profile_tab,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        FieldValidation.elementValidation(driver,pgs.access_sharing_tab,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-SocialHistory", 2, 0));
        try {

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            if (NoRecordsFound.noRecordsFoundMsg(driver).isDisplayed()) {
                log.info("No Records Present");
            }
        } catch (Exception e) {
            log.info("Exception in finding element: " + e.getMessage());
        }

    }

    @Test(enabled = true,groups = {"smoke"})
    public static void profilePageTC_067() {

        try {
            Assert.assertTrue(pgs.access_sharing_record_present_list.isDisplayed());
            Assert.assertTrue(pgs.access_sharing_recordsPage_contents.isDisplayed());
            // log.info("checking pharmacy records");

        } catch (Exception e) {
            log.info("Exception in finding element: " + e.getMessage());
        }

    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_068() {

        FieldValidation.elementValidation(driver,pgs.access_sharing_add_icon,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.access_sharing_add_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_069() {

        Assert.assertTrue(pgs.access_sharing_add_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_070() {

        FieldValidation.elementValidation(driver,pgs.access_sharing_search_txt_field_by_lastname,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0));


        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if (pgs.search_no_user_results_found.isDisplayed()) {
                log.info("User not present");

            }
        } catch (Exception e) {

            log.info(("Entered lastname of user available"));
            wait.until(ExpectedConditions.elementToBeClickable(pgs.search_autopopulate_user)).isDisplayed();
        }

        List<WebElement> fname = pgs.search_firstName;
        List<WebElement> email_id = pgs.search_email;

        try {

            for (WebElement ele : fname) {
                for (WebElement ele2 : email_id) {
                    if (ele.getText().equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1)) && ele2.getText().equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 2))) {
                        log.info("user found");
                        ele.click();
                        break;
                    }
                    log.info("user not found");
                    throw new AssertionError("User not present");
                }
            }

        } catch (Exception e) {

            log.info("Exception in getting user name: " + e.getMessage());
        }

        Assert.assertTrue(pgs.access_sharing_lastname_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0)));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_071() {

        Assert.assertTrue(pgs.access_sharing_firstbname_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1)));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_072() {

        Assert.assertTrue(pgs.access_sharing_Email_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 2)));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_073() {

        Assert.assertTrue(pgs.access_sharing_lastname_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0)));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_074() {

        Assert.assertTrue(pgs.access_sharing_firstbname_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1)));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_075() {

        Assert.assertTrue(pgs.access_sharing_Email_txt_field.getAttribute("value").equalsIgnoreCase(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 2)));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_076() {

        HideKeyBoard.hideKeyBoard(driver);

        FieldValidation.elementValidation(driver,pgs.access_sharing_relation_dropDown,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.access_sharing_relation_dropDown.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_077() {

        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 3));
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("RelationOption")));
            dropdown.selectByVisibleText(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 3));

        } else {
            log.info("Unable to find dropdown data");
        }

    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_078() throws InterruptedException {

        FieldValidation.elementValidation(driver,pgs.access_sharing_relation_dropDown,testClassName,testMethodName).click();
        Thread.sleep(3000);

        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, "Other");
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("RelationOption")));
            dropdown.selectByVisibleText("Other");

        } else {
            log.info("Unable to find dropdown data");
        }
        Assert.assertTrue(pgs.Access_sharing_relation_dropDown_other_txtField.isDisplayed());
        FieldValidation.elementValidation(driver,pgs.access_sharing_relation_dropDown,testClassName,testMethodName).click();
        Scroll.scrollToText(driver, ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 3));

    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_079() {

        FieldValidation.elementValidation(driver,pgs.Access_sharing_access_level_dropDown,testClassName,testMethodName).click();
        Assert.assertTrue(pgs.Access_sharing_access_level_dropDown_options.isDisplayed());
        //driver.getPageSource();
        // log.info("Page source: "+driver.getPageSource());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_080() throws InterruptedException {

        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, "View");
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("RelationOption")));
            dropdown.selectByVisibleText("View");

        } else {
            log.info("Unable to find dropdown data");
        }
        log.info("Extracted value from access sharing: " + pgs.Access_sharing_access_level_dropDown.getAttribute("value"));
        Assert.assertTrue(pgs.Access_sharing_access_level_dropDown.getAttribute("value").equalsIgnoreCase("V"));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_081() throws InterruptedException {

        FieldValidation.elementValidation(driver,pgs.Access_sharing_access_level_dropDown,testClassName,testMethodName).click();


        instance = driver.getClass().getName();

        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, "View & Modify");
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(driver.findElement(By.id("RelationOption")));
            dropdown.selectByVisibleText("View & Modify");

        } else {
            log.info("Unable to find dropdown data");
        }
        log.info("Extracted value from access sharing: " + pgs.Access_sharing_access_level_dropDown.getAttribute("value"));
        Assert.assertTrue(pgs.Access_sharing_access_level_dropDown.getAttribute("value").equalsIgnoreCase("E"));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_082() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_fromDate_datePicker_field)).click();
        Assert.assertTrue(pgs.access_sharing_fromDate_datePicker.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_083() throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_from_month_dropdown)).click();
        log.info("Total months: " + pgs.access_duration_from_month_select_month.size());
        String from_date_received = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 6);
        log.info(from_date_received);
        DateCheck from_dt = new DateCheck(from_date_received);
        String from_month = from_dt.getMonth();
        int from_year = from_dt.getYear();
        String from_day = Integer.toString(from_dt.getDay());
        log.info("Month :" + from_month + ", Year: " + from_year + ", Day: " + from_day);

        Scroll.scrollToText(driver, from_month);

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_from_year_dropdown)).click();
        //log.info("Total years: "+pgs.access_duration_from_month_select_year.size());
        Scroll.scrollToText(driver, from_year);


        //log.info("Totals dates: "+pgs.access_duration_from_select_days.size());
        for (WebElement days : pgs.access_duration_from_select_days) {
            if (days.getText().equals(from_day)) {
                //log.info(days.getText());
                days.click();
                break;
            } else {
                //log.info(days.getText());
                log.info("Not able to find dates in from date picker");
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_fromDate_datePicker_ok_btn)).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_084() throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_toDate_datePicker_field)).click();
        Assert.assertTrue(pgs.access_sharing_toDate_datePicker.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_085() throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_to_month_dropdown)).click();
        log.info("Total months: " + pgs.access_duration_to_month_select_month.size());
        String to_date_received = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 7);
        log.info(to_date_received);
        DateCheck to_dt = new DateCheck(to_date_received);
        String to_month = to_dt.getMonth();
        int to_year = to_dt.getYear();
        String to_day = Integer.toString(to_dt.getDay());
        log.info("Month :" + to_month + ", Year: " + to_year + ", Day: " + to_day);

        Scroll.scrollToText(driver, to_month);

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_to_year_dropdown)).click();
        //log.info("Total years: "+pgs.access_duration_to_month_select_year.size());
        Scroll.scrollToText(driver, to_year);


        //log.info("Totals dates: "+pgs.access_duration_to_select_days.size());
        for (WebElement days : pgs.access_duration_to_select_days) {
            if (days.getText().equals(to_day)) {
                //log.info(days.getText());
                days.click();
                break;
            } else {
                //log.info(days.getText());
                log.info("Not able to find dates in from date picker");
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_toDate_datePicker_ok_btn)).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_086() {

        Swipe.swipeVerticalDown(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_expand_btn)).click();
        Swipe.swipeVerticalDown(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_expand_btn)).click();
        Assert.assertTrue(pgs.access_duration_profile_feature_collapse_btn.isDisplayed());
        Assert.assertTrue(pgs.access_duration_healthTracker_feature_collapse_btn.isDisplayed());
        Swipe.swipeVerticalDown(driver, 3);
        Assert.assertTrue(pgs.access_duration_medicalCare_feature_collapse_btn.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_087() {

        Swipe.swipeVerticalUp(driver, 3);
        Assert.assertTrue(pgs.features_profile_submodules.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_088() {

        Assert.assertTrue(pgs.features_healthTracker_submodules.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_089() {

        Swipe.swipeVerticalDown(driver, 3);
        Assert.assertTrue(pgs.features_medicalCare_submodules.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_090() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_collapse_btn)).click();
        Swipe.swipeVerticalUp(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_collapse_btn)).click();
        Assert.assertTrue(pgs.access_duration_profile_feature_expand_btn.isDisplayed());
        Assert.assertTrue(pgs.access_duration_healthTracker_feature_expand_btn.isDisplayed());
        Swipe.swipeVerticalDown(driver, 3);
        Assert.assertTrue(pgs.access_duration_medicalCare_feature_expand_btn.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_091() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_profile)).click();
        Assert.assertTrue(pgs.features_profile_allSubModule_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_profile)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_healthTracker)).click();
        Assert.assertTrue(pgs.features_healthTracker_allSubModule_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_healthTracker)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_expand_btn)).click();
        Swipe.swipeVerticalDown(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_medicalCare)).click();
        Assert.assertTrue(pgs.features_medicalcare_allSubModule_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_medicalCare)).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_092() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_medicalCare_alergies)).click();
        Assert.assertTrue(pgs.features_allergies_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_conditions_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_proceduresAndSurgeries_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_immunizations_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_labTest_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_medicalCare_alergies)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_healthTracker_bloodPressure)).click();
        Assert.assertTrue(pgs.features_bloodPressure_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_Weight_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_bloodGlucose_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_cholesterol_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_pulseOx_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_calorie_burned_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_hours_of_sleep_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_temperature_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_healthTracker_bloodPressure)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_collapse_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_expand_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_profile_insurance)).click();
        Assert.assertTrue(pgs.features_insurance_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_contacts_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_physicians_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_pharmacy_checkbox.isDisplayed());
        Assert.assertTrue(pgs.features_socialHistory_checkbox.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.features_profile_insurance)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_collapse_btn)).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_093() {

        String checkboxes_profile = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 8);
        log.info("Data from excel: " + checkboxes_profile);
        if (checkboxes_profile.length() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_expand_btn)).click();
            List<String> checkbox_list_profile = new ArrayList<String>(Arrays.asList(checkboxes_profile.split(",")));
            log.info("List_value_profile: " + checkbox_list_profile);
            List<WebElement> profile_subMenues_list = pgs.profile_subMenus;
            log.info("profile size: " + profile_subMenues_list.size());


            for (String cb_profile : checkbox_list_profile) {
                log.info("check_value_profile: " + checkbox_list_profile);
                for (WebElement chk_profile : profile_subMenues_list) {
                    log.info("chk_value_profile: " + chk_profile);
                    if (chk_profile.getText().equalsIgnoreCase(cb_profile))
                        log.info("chk_text_Profile: " + chk_profile.getText()); //'"+eventName+"
                    chk_profile.findElement(By.xpath("//label[contains(text(),'" + cb_profile + "')]")).click();
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_profile_feature_collapse_btn)).click();
        }
        String checkboxes_healthTracker = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 9);
        log.info("Data from excel: " + checkboxes_healthTracker);
        if (checkboxes_healthTracker.length() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_expand_btn)).click();
            List<String> checkbox_list_healthTracker = new ArrayList<String>(Arrays.asList(checkboxes_healthTracker.split(",")));
            log.info("List_value_ht: " + checkbox_list_healthTracker);
            List<WebElement> healthTracker_subMenues_list = pgs.healthTracker_subMenus;
            log.info("healthTracker size: " + healthTracker_subMenues_list.size());

            for (String cb_healthTracker : checkbox_list_healthTracker) {
                log.info("check_value_ht: " + checkbox_list_healthTracker);
                for (WebElement chk_healthTracker : healthTracker_subMenues_list) {
                    log.info("chk_value_ht: " + chk_healthTracker.getText());
                    if (chk_healthTracker.getText().equalsIgnoreCase(cb_healthTracker))
                        log.info("chk_text_ht: " + chk_healthTracker.getText()); //'"+eventName+"
                    chk_healthTracker.findElement(By.xpath("//label[contains(text(),'" + cb_healthTracker + "')]")).click();
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_healthTracker_feature_collapse_btn)).click();
        }
        String checkboxes_medicalCare = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 10);
        log.info("Data from excel: " + checkboxes_medicalCare);
        if (checkboxes_medicalCare.length() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_expand_btn)).click();
            List<String> checkbox_list_medicalCare = new ArrayList<String>(Arrays.asList(checkboxes_medicalCare.split(",")));
            log.info("List_value_medicalCare: " + checkbox_list_medicalCare);
            List<WebElement> medicalCare_subMenues_list = pgs.medicalCare_subMenus;
            log.info("Medical Care size: " + medicalCare_subMenues_list.size());

            for (String cb_medicalCare : checkbox_list_medicalCare) {
                log.info("check value: " + checkbox_list_medicalCare);
                for (WebElement chk_medicalCare : medicalCare_subMenues_list) {
                    log.info("chk value: " + chk_medicalCare);
                    if (chk_medicalCare.getText().equalsIgnoreCase(cb_medicalCare))
                        log.info("chk text: " + chk_medicalCare.getText()); //'"+eventName+"
                    chk_medicalCare.findElement(By.xpath("//label[contains(text(),'" + cb_medicalCare + "')]")).click();
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_duration_medicalCare_feature_collapse_btn)).click();
        }
        String checkbox_Alerts = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 11);
        if (checkbox_Alerts.equalsIgnoreCase("Y")) {
            pgs.features_alerts_checkbox.click();
        }
        String checkbox_healthTopic = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 12);
        if (checkbox_healthTopic.equalsIgnoreCase("Y")) {
            pgs.features_healthTopic_checkbox.click();
        }
        String checkbox_myDocument = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 13);
        if (checkbox_myDocument.equalsIgnoreCase("Y")) {
            pgs.features_myDocument_checkbox.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(pgs.add_access_sharing_btn)).click();
        Assert.assertTrue(pgs.access_sharing_added_successfully_popUp.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_094() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_added_successfully_popUp_viewInfo)).click();
        Assert.assertTrue(pgs.access_sharing_recordsPage_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_095() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_recordspage_editBtn)).click();
        Swipe.swipeVerticalDown(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.add_access_sharing_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_added_successfully_popUp_addMore)).click();
        Assert.assertTrue(pgs.access_sharing_add_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_096() {

        Swipe.swipeVerticalDown(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.add_access_sharing_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_added_successfully_popUp_viewInfo)).click();
        String lastName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0);
        String firstName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1);
        String cname = lastName + "," + firstName;
        log.info("cname: " + cname);
        log.info("name present in records: " + pgs.access_sharing_recordspage_userName.getText());
        Assert.assertEquals(pgs.access_sharing_recordspage_userName.getText(), cname);

    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_097() {

        String lastName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0);
        String firstName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1);
        String cname = lastName + "," + firstName;
        log.info("cname: " + cname);
        log.info("name present in records: " + pgs.access_sharing_recordspage_userName.getText());
        Assert.assertEquals(pgs.access_sharing_recordspage_userName.getText(), cname);
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_098() {

        Assert.assertTrue(pgs.access_sharing_recordspage_userName.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_099() {

        Assert.assertTrue(pgs.access_sharing_recordspage_email.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_100() {

        Assert.assertTrue(pgs.access_sharing_recordspage_email.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_101() {

        Assert.assertTrue(pgs.access_sharing_recordspage_relationShip.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_102() {

        Assert.assertTrue(pgs.access_sharing_recordspage_relationShip.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_103() {

        if (ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 5).equals(" ")) {
            log.info("Other relationship is blank");
        } else {
            String other = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 5);
            Assert.assertEquals(pgs.access_sharing_recordspage_relationShip.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 5));
        }
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_104() {

        Assert.assertEquals(pgs.access_sharing_recordspage_expiryDate.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 7));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_105() {

        Assert.assertEquals(pgs.access_sharing_recordspage_expiryDate.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 7));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_106() {

        Assert.assertEquals(pgs.access_sharing_recordspage_createdDate.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 6));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_107() {

        Assert.assertEquals(pgs.access_sharing_recordspage_createdDate.getText(), ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 6));
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_108() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_recordspage_deleteBtn)).click();
        Assert.assertTrue(pgs.access_sharing_deleteConfirmation_popUp.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_109() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_deleteConfirmation_popUp_No_btn)).click();
        Assert.assertTrue(pgs.access_sharing_recordsPage_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_110() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_recordspage_deleteBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_deleteConfirmation_popUp_Yes_btn)).click();
        Assert.assertTrue(pgs.access_sharing_deletedSuccessfully_ok_btn.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_deletedSuccessfully_ok_btn)).click();
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_111() {

        String delete_record_last_name = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0);
        String delete_record_first_name = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1);
        String name = delete_record_last_name + "," + delete_record_first_name;
        log.info("deleted record user name: " + name);


        for (int i = 0; i < pgs.access_sharing_deletedRecord_Validation.size(); i++) {
            log.info("ele: " + pgs.access_sharing_deletedRecord_Validation.get(i).getText());
            Assert.assertNotEquals(pgs.access_sharing_deletedRecord_Validation.get(i).getText(), name);
        }
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_112() {

        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_editBtn)).click();
        Assert.assertTrue(pgs.access_sharing_add_page_contents.isDisplayed());
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_113() {

        Swipe.swipeVerticalDown(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_update_btn)).click();
        Assert.assertTrue(pgs.access_sharing_recordsPage_contents.isDisplayed());
        log.info("Hii");
    }

    @Test(enabled = true,groups = {"regression"})
    public static void profilePageTC_114() throws Exception {
        log.info("Getting user lastname from excel");
        String lastName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0);
        log.info("Getting user firstname from excel");
        String firstName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1);
        log.info("Appending firstname with lastname");
        String cname = lastName + "," + firstName;
        log.info("cname: " + cname);
        //log.info("name present in records: " + pgs.access_sharing_recordspage_userName.getText());
        log.info("Printing total access sharing user records");
        log.info("Records present in access sharing: " + pgs.access_sharing_recordspage_userName_list.size());
        log.info("Finding required user and clicking his/her edit button");
        for (WebElement wl : pgs.access_sharing_recordspage_userName_list) {

            try {
                if (wl.getText().equalsIgnoreCase(cname)) {
                    log.info(wl.getText());
                    //log.info("Hii");
                    driver.findElement(By.xpath("//b[text()='" + cname + "']/parent::*/following-sibling::*//div[@class='as-edit']")).click();
                }
            } catch (Exception e) {
                log.info("Exception in finding element: " + e.getMessage());
            }
        }
        log.info("Clicking on access level dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.Access_sharing_access_level_dropDown)).click();
        instance = driver.getClass().getName();
        log.info("Scrolling and selecting the access level value");
        if (instance.contains("AndroidDriver")) {
            Scroll.scrollToText(driver, "View");
        } else if (instance.contains("IOSDriver")) {
            Select dropdown = new Select(pgs.Access_sharing_access_level_dropDown);
            dropdown.selectByVisibleText("View");

        } else {
            log.info("Unable to find dropdown data");
            log.info("Unable to find  access level dropdown data");
        }
        log.info("Swiping vertiacally up");
        Swipe.swipeVerticalDown(driver, 3);
        log.info("Clicking on access sharing add button");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.add_access_sharing_btn)).click();
        log.info("Clicking on view info button in added successfully pop up");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_added_successfully_popUp_viewInfo)).click();
        log.info("Clicking on menu button");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.menu_btn)).click();
        log.info("Clicking on log out button");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.user_logOut_btn)).click();
        log.info("Clearing username text field");
        wait.until(ExpectedConditions.elementToBeClickable(lps.username_txt_field)).clear();
        log.info("Entering username data");
        wait.until(ExpectedConditions.elementToBeClickable(lps.username_txt_field)).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 14));
        log.info("Clearing password text field");
        wait.until(ExpectedConditions.elementToBeClickable(lps.password_txt_field)).clear();
        log.info("Entering password data");
        wait.until(ExpectedConditions.elementToBeClickable(lps.password_txt_field)).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 15));
        log.info("Hiding device keypad");
        HideKeyBoard.hideKeyBoard(driver);
        log.info("Clicking on login button");
        wait.until(ExpectedConditions.elementToBeClickable(lps.login_btn)).click();
        log.info("Validating dashboard page");
        if (wait.until(ExpectedConditions.visibilityOf(lps.login_In_Check)).isDisplayed()) {
            log.info("Sucessfully logged in");
            log.info("Dashboard displayed");
        } else {
            log.info("login Unsuccessful");

        }
        log.info("Retrieving shared user firstname");
        String shared_user_firstname = ExcelUtility.readTestdata(testdataSheet, "LoginPageUC", 1, 2);
        log.info("Retrieving shared user lastname");
        String shared_user_lastname = ExcelUtility.readTestdata(testdataSheet, "LoginPageUC", 1, 3);
        log.info("Appending shared user lastname with firstname");
        String shared_user_name = shared_user_lastname + " " + shared_user_firstname;
        log.info("shared user name: " + shared_user_name);
        log.info("Checking if multiple shared access sharing users present");
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if (pgs.manage_btn_drop_down.isDisplayed()) {
                pgs.manage_btn_drop_down.click();
            }
        } catch (Exception e) {
            log.info("Exception in getting element: " + e.getMessage());
            log.info("Exception in getting element: " + e.getMessage());
        }
        log.info("Printing total access sharing users");
        log.info("total access sharing users: " + pgs.access_sharing_users.size());
        log.info("Checking for the required shared access sharing user and cliking manage button for the user ");
        for (WebElement a : pgs.access_sharing_users) {
            log.info(a.getText());
            log.info(shared_user_name);
            if (a.getText().contains(shared_user_name)) {
                a.findElement(By.xpath("//li[@class='access_name' and contains(text(),'" + shared_user_name + "')]/following-sibling::*/input[@class='access_button']")).click();
            }
        }
        log.info("Clicking on shared profile tab");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.shared_profile_tab)).click();
        log.info("Retrieving profile total sub-menus from excel ");
        String checkboxes_profile = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 8);
        log.info("Checkboxes_profile: " + checkboxes_profile);
        log.info("Checking if profile submenus containing physicians");
        if (checkboxes_profile.contains("Physicians")) {
            log.info("Clicking on shared physicians tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.physicians_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver, 3);
            log.info("Validating if add physicians button displaying");
            Assert.assertFalse(pgs.add_physicians_icon.isDisplayed());
            log.info("Swiping Up");
            Swipe.swipeVerticalUp(driver, 3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Checking if profile submenus containing pharmacy");
        if (checkboxes_profile.contains("Pharmacy")) {
            log.info("Clicking on pharmacy tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.pharmacy_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver, 3);
            log.info("Validating if pharmacy add button displaying");
            Assert.assertFalse(pgs.pharmacy_add_icon.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver, 3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Checking if profile submenus containing Insurance");
        if (checkboxes_profile.contains("Insurance")) {
            log.info("Clicking on insurance tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.insurance_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver, 3);
            log.info("Validating if insurance add button displaying");
            Assert.assertFalse(pgs.insurarce_add_icon.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver, 3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Checking if profile submenus containing Social History");
        if (checkboxes_profile.contains("Social History")) {
            log.info("Clicking on social history tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.social_history_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver, 3);
            log.info("Validating if edit button is displaying");
            Assert.assertFalse(pgs.socialHistory_edit_btn.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver, 3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Clicking on back button");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        log.info("Clicking on shared health tracker tab");
        wait.until(ExpectedConditions.elementToBeClickable(pgs.shared_Health_Tracker_tab)).click();
        log.info("retrieving healthracker sub menus from excel");
        String checkboxes_health_tracker = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 9);
        log.info("Checking if health tracker submenus containing Weight");
        if (checkboxes_health_tracker.contains("Weight")) {
            log.info("Clicking on weight tab");
            wait.until(ExpectedConditions.elementToBeClickable(hps.weight_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver, 3);
            log.info("Validating if add weight button displaying");
            Assert.assertFalse(hps.add_weight_btn.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver, 3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
        log.info("Checking if health tracker submenus containing blood pressure");
        if (checkboxes_health_tracker.contains("Blood Pressure")) {
            log.info("Clicking on blood pressure tab");
            wait.until(ExpectedConditions.elementToBeClickable(hps.blood_pressure_tab)).click();
            log.info("Swiping down");
            Swipe.swipeVerticalDown(driver, 3);
            log.info("Validating if add blood pressure button displaying");
            Assert.assertFalse(hps.add_weight_btn.isDisplayed());
            log.info("Swiping up");
            Swipe.swipeVerticalUp(driver, 3);
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
        }
    }
        @Test(enabled = true,groups = {"regression"})
        public static void profilePageTC_115() throws Exception {
            log.info("Getting user lastname from excel");
            String lastName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 0);
            log.info("Getting user firstname from excel");
            String firstName = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 1);
            log.info("Appending firstname with lastname");
            String cname = lastName + "," + firstName;
            log.info("cname: " + cname);
            //log.info("name present in records: " + pgs.access_sharing_recordspage_userName.getText());
            log.info("Printing total access sharing user records");
            log.info("Records present in access sharing: " + pgs.access_sharing_recordspage_userName_list.size());
            log.info("Finding required user and clicking his/her edit button");
            for (WebElement wl : pgs.access_sharing_recordspage_userName_list) {

                try {
                    if (wl.getText().equalsIgnoreCase(cname)) {
                        log.info(wl.getText());
                        //log.info("Hii");
                        driver.findElement(By.xpath("//b[text()='" + cname + "']/parent::*/following-sibling::*//div[@class='as-edit']")).click();
                    }
                } catch (Exception e) {
                    log.info("Exception in finding element: " + e.getMessage());
                }
            }
            log.info("Clicking on access level dropdown");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.Access_sharing_access_level_dropDown)).click();
            instance = driver.getClass().getName();
            log.info("Scrolling and selecting the access level value");
            if (instance.contains("AndroidDriver")) {
                Scroll.scrollToText(driver, "View & Modify");
            } else if (instance.contains("IOSDriver")) {
                Select dropdown = new Select(pgs.Access_sharing_access_level_dropDown);
                dropdown.selectByVisibleText("View & Modify");

            } else {
                log.info("Unable to find dropdown data");
                log.info("Unable to find  access level dropdown data");
            }
            log.info("Swiping vertiacally up");
            Swipe.swipeVerticalDown(driver, 3);
            log.info("Clicking on access sharing add button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.add_access_sharing_btn)).click();
            log.info("Clicking on view info button in added successfully pop up");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.access_sharing_added_successfully_popUp_viewInfo)).click();
            log.info("Clicking on menu button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.menu_btn)).click();
            log.info("Clicking on log out button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.user_logOut_btn)).click();
            log.info("Clearing username text field");
            wait.until(ExpectedConditions.elementToBeClickable(lps.username_txt_field)).clear();
            log.info("Entering username data");
            wait.until(ExpectedConditions.elementToBeClickable(lps.username_txt_field)).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 14));
            log.info("Clearing password text field");
            wait.until(ExpectedConditions.elementToBeClickable(lps.password_txt_field)).clear();
            log.info("Entering password data");
            wait.until(ExpectedConditions.elementToBeClickable(lps.password_txt_field)).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 15));
            log.info("Hiding device keypad");
            HideKeyBoard.hideKeyBoard(driver);
            log.info("Clicking on login button");
            wait.until(ExpectedConditions.elementToBeClickable(lps.login_btn)).click();
            log.info("Validating dashboard page");
            if (wait.until(ExpectedConditions.visibilityOf(lps.login_In_Check)).isDisplayed()) {
                log.info("Sucessfully logged in");
                log.info("Dashboard displayed");
            } else {
                log.info("login Unsuccessful");

            }
            log.info("Retrieving shared user firstname");
            String shared_user_firstname = ExcelUtility.readTestdata(testdataSheet, "LoginPageUC", 1, 2);
            log.info("Retrieving shared user lastname");
            String shared_user_lastname = ExcelUtility.readTestdata(testdataSheet, "LoginPageUC", 1, 3);
            log.info("Appending shared user lastname with firstname");
            String shared_user_name = shared_user_lastname + " " + shared_user_firstname;
            log.info("shared user name: " + shared_user_name);
            log.info("Checking if multiple shared access sharing users present");
            try {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                if (pgs.manage_btn_drop_down.isDisplayed()) {
                    pgs.manage_btn_drop_down.click();
                }
            } catch (Exception e) {
                log.info("Exception in getting element: " + e.getMessage());
                log.info("Exception in getting element: " + e.getMessage());
            }
            log.info("Printing total access sharing users");
            log.info("total access sharing users: " + pgs.access_sharing_users.size());
            log.info("Checking for the required shared access sharing user and cliking manage button for the user ");
            for (WebElement a : pgs.access_sharing_users) {
                log.info(a.getText());
                log.info(shared_user_name);
                if (a.getText().contains(shared_user_name)) {
                    a.findElement(By.xpath("//li[@class='access_name' and contains(text(),'" + shared_user_name + "')]/following-sibling::*/input[@class='access_button']")).click();
                }
            }
            log.info("Clicking on shared profile tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.shared_profile_tab)).click();
            log.info("Retrieving profile total sub-menus from excel ");
            String checkboxes_profile = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 8);
            log.info("Checkboxes_profile: " + checkboxes_profile);
            log.info("Checking if profile submenus containing physicians");
            if (checkboxes_profile.contains("Physicians")) {
                log.info("Clicking on shared physicians tab");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.physicians_tab)).click();
                log.info("Swiping down");
                Swipe.swipeVerticalDown(driver, 3);
                log.info("Validating if add physicians button displaying");
                Assert.assertFalse(pgs.add_physicians_icon.isDisplayed());
                log.info("Swiping Up");
                Swipe.swipeVerticalUp(driver, 3);
                log.info("Clicking on back button");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
            }
            log.info("Checking if profile submenus containing pharmacy");
            if (checkboxes_profile.contains("Pharmacy")) {
                log.info("Clicking on pharmacy tab");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.pharmacy_tab)).click();
                log.info("Swiping down");
                Swipe.swipeVerticalDown(driver, 3);
                log.info("Validating if pharmacy add button displaying");
                Assert.assertFalse(pgs.pharmacy_add_icon.isDisplayed());
                log.info("Swiping up");
                Swipe.swipeVerticalUp(driver, 3);
                log.info("Clicking on back button");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
            }
            log.info("Checking if profile submenus containing Insurance");
            if (checkboxes_profile.contains("Insurance")) {
                log.info("Clicking on insurance tab");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.insurance_tab)).click();
                log.info("Swiping down");
                Swipe.swipeVerticalDown(driver, 3);
                log.info("Validating if insurance add button displaying");
                Assert.assertFalse(pgs.insurarce_add_icon.isDisplayed());
                log.info("Swiping up");
                Swipe.swipeVerticalUp(driver, 3);
                log.info("Clicking on back button");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
            }
            log.info("Checking if profile submenus containing Social History");
            if (checkboxes_profile.contains("Social History")) {
                log.info("Clicking on social history tab");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.social_history_tab)).click();
                log.info("Swiping down");
                Swipe.swipeVerticalDown(driver, 3);
                log.info("Validating if edit button is displaying");
                Assert.assertFalse(pgs.socialHistory_edit_btn.isDisplayed());
                log.info("Swiping up");
                Swipe.swipeVerticalUp(driver, 3);
                log.info("Clicking on back button");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
            }
            log.info("Clicking on back button");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
            log.info("Clicking on shared health tracker tab");
            wait.until(ExpectedConditions.elementToBeClickable(pgs.shared_Health_Tracker_tab)).click();
            log.info("retrieving healthracker sub menus from excel");
            String checkboxes_health_tracker = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 9);
            log.info("Checking if health tracker submenus containing Weight");
            if (checkboxes_health_tracker.contains("Weight")) {
                log.info("Clicking on weight tab");
                wait.until(ExpectedConditions.elementToBeClickable(hps.weight_tab)).click();
                log.info("Swiping down");
                Swipe.swipeVerticalDown(driver, 3);
                log.info("Validating if add weight button displaying");
                Assert.assertFalse(hps.add_weight_btn.isDisplayed());
                log.info("Swiping up");
                Swipe.swipeVerticalUp(driver, 3);
                log.info("Clicking on back button");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
            }
            log.info("Checking if health tracker submenus containing blood pressure");
            if (checkboxes_health_tracker.contains("Blood Pressure")) {
                log.info("Clicking on blood pressure tab");
                wait.until(ExpectedConditions.elementToBeClickable(hps.blood_pressure_tab)).click();
                log.info("Swiping down");
                Swipe.swipeVerticalDown(driver, 3);
                log.info("Validating if add blood pressure button displaying");
                Assert.assertFalse(hps.add_weight_btn.isDisplayed());
                log.info("Swiping up");
                Swipe.swipeVerticalUp(driver, 3);
                log.info("Clicking on back button");
                wait.until(ExpectedConditions.elementToBeClickable(pgs.back_btn)).click();
            }
        }


    }
























//	@Test(priority=9,enabled=true) //access-sharing
//	public static void profilePageTC_009() throws Exception
//	{
//
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.access_sharing_tab())).click();
//		try{
//			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//			if(pgss.No_record_message().isDisplayed())
//			{
//				log.info("Records are not present");
//			}
//
//		}catch(Exception e)
//		{
//			log.info("records are present");
//		}
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.add_access_sharing_add_icon())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_by_lastName())).sendKeys("miller");
//
//		try
//        {
//            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//            if(pgss.search_check_user_available().isDisplayed())
//            {
//                log.info("User11 not present");
//
//            }
//        }
//        catch(Exception e)
//        {
//            log.info(("Entered lastname of user available"));
//            wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_autopopulate_field())).isDisplayed();
//        }
//        List<WebElement> fname = driver.findElements(By.xpath("//ul[@class='flexdatalist-results']/li/span[@class='item item-firstName']"));
//		List<WebElement> email = driver.findElements(By.xpath("//ul[@class='flexdatalist-results']/li/span[@class='item item-email']"));
//		try{
//
//			for(WebElement ele :fname )
//			{
//				for(WebElement ele2 : email)
//				{
//					if(ele.getText().equalsIgnoreCase("john") && ele2.getText().equalsIgnoreCase("akash.mahato@healthec.com")){
//						log.info("user found");
//						ele.click();
//						break;
//					}
//					log.info("user not found");
//                    throw new AssertionError("User11 not present");
//				}
//			}
//
//			*//*for(WebElement ele :fname )
//		    {
//			if(ele.getText().equalsIgnoreCase("test1122")){
//				for(WebElement ele2 : email)
//				{
//					if(ele2.getText().equalsIgnoreCase("prasanna.kumar@healthec.com")){
//						log.info("element found");
//						ele.click();
//						break;
//					}
//				}
//
//			}
//		}*//*
//		}catch(Exception e)
//	  {
//			log.info("Exception in getting user name: "+e.getMessage());
//		}
//	//	WebElement wb = driver.findElement(By.xpath("//ul[@class='flexdatalist-results']"));
//		//Swipe.swipeVerticalUpWithDimensions(driver, 3000,wb );
//		//SwitchView.changeContext(driver, "NATIVE_APP");
//		/*WebElement el1 = driver.findElement(By.xpath("//*[@class='android.widget.ListView']"));
//		Swipe.swipeVerticalUpWithDimensions(driver, 3000,el1 );
//		*//*
//		*//*try{
//
//			Point p = pgss.search_user().getLocation();
//			int searc_user_x = p.getX();
//			int searc_user_y = p.getY();
//
//			int search_ht = wb.getSize().getHeight();
//			int search_wd = wb.getSize().getWidth();
//		//	log.info("X-axis: "+searc_user_x+","+"Y-axis: "+searc_user_y+"ht: "+search_ht+","+"wdth: "+search_wd);
//
//			Swipe.swipeVerticalUpWithDimensions(driver, 3000,wb );
//		}catch(Exception e)
//		{
//			log.info("Exception in swipe for user_search box: "+e.getMessage() );
//		}*//*
//		*//*String lname = wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_lastname_txt_field())).getAttribute("value");
//		log.info("lastname displaying: "+lname);
//		Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_lastname_txt_field())).getAttribute("value"), "test");
//		Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_firstname_txt_field())).getAttribute("value"), "test1122");
//		Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(pgss.search_user_email_txt_field())).getAttribute("value"), "prasanna.kumar@healthec.com");
//	    HideKeyBoard.hideKeyBoard(driver);*//*
//
//
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_relationship_dropdown())).click();
//		Scroll.scrollToText(driver, "Brother");
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_level_dropdown())).click();
//		Scroll.scrollToText(driver, "View & Modify");
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_dromDate_datePicker())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_from_month())).click();
//		log.info("Total months: "+pgss.user_access_duration_from_select_month().size());
//		String from_date_received = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 5);
//		log.info(from_date_received);
//		DateCheck from_dt = new DateCheck(from_date_received);
//		String from_month = from_dt.getMonth();
//		int from_year = from_dt.getYear();
//		String from_day = Integer.toString(from_dt.getDay());
//		log.info(from_month);
//		log.info(from_year);
//		log.info(from_day);
//
//		Scroll.scrollToText(driver,from_month);
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_from_year())).click();
//		log.info("Total years: "+pgss.user_access_duration_from_select_year().size());
//		Scroll.scrollToText(driver, from_year);
//
//
//		log.info("Totals dates: "+pgss.user_access_duration_from_select_dates().size());
//		for(WebElement days : pgss.user_access_duration_from_select_dates())
//		{
//			if(days.getText().equals(from_day))
//			{
//				//log.info(days.getText());
//				days.click();
//				break;
//			}
//			else{
//				//log.info(days.getText());
//				log.info("Not able to find dates in from date picker");
//			}
//		}
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_fromdate_Ok_btn())).click();
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_todate_datePicker())).click();
//
//		log.info("Clicked on to date datepicker");
//
//
//
//		//driver.findElement(By.xpath("//div[@id='dobDatePicker1']//select[@class='ui-datepicker-month']")).click();
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_todate_month_dropdown())).click();
//		log.info("Total months: "+pgss.user_access_duration_from_select_month().size());
//		String to_date_received = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 6);
//		DateCheck to_dt = new DateCheck(to_date_received);
//		String to_month = to_dt.getMonth();
//		int to_year = to_dt.getYear();
//		String to_day = Integer.toString(to_dt.getDay());
//		log.info(to_month);
//		log.info(from_year);
//		log.info(from_day);
//		Scroll.scrollToText(driver, to_month);
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_todate_year_dropdown())).click();
//		log.info("Total months: "+pgss.user_access_duration_from_select_year().size());
//		Scroll.scrollToText(driver, to_year);
//		log.info("Totals dates: "+pgss.user_access_duration_from_select_dates().size());
//		for(WebElement days : pgss.user_access_duration_from_select_dates())
//		{
//			if(days.getText().equals(to_day))
//			{
//				days.click();
//				break;
//			}
//			else{
//				log.info("Not able to find dates in to date picker");
//			}
//		}
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.user_access_duration_toDate_ok_btn())).click();
//		Swipe.swipeVerticalDown(driver, 5);
//		String checkboxes_profile = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 7);
//		log.info("Data from excel: "+checkboxes_profile);
//		if(checkboxes_profile.length()>0)
//		{
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.profile_expand_btn_open())).click();
//		List<String> checkbox_list_profile = new ArrayList<String>(Arrays.asList(checkboxes_profile.split(",")));
//		log.info("List value: "+checkbox_list_profile);
//		List<WebElement>profile_subMenues_list = pgss.profile_subMenus();
//		log.info("profile size: "+profile_subMenues_list.size());
//
//
//		for(String cb_profile : checkbox_list_profile){
//			log.info("check value: "+checkbox_list_profile);
//		 for (WebElement chk_profile : profile_subMenues_list){
//			 log.info("chk value: "+chk_profile);
//			if(chk_profile.getText().equalsIgnoreCase(cb_profile))
//				log.info("chk text: "+chk_profile.getText()); //'"+eventName+"
//			chk_profile.findElement(By.xpath("//label[contains(text(),'"+cb_profile+"')]")).click();
//			   break;
//			 }
//		 }
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.profile_expand_btn_close())).click();
//		}
//		String checkboxes_healthTracker = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 8);
//		log.info("Data from excel: "+checkboxes_healthTracker);
//		if(checkboxes_healthTracker.length()>0)
//		{
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.healthTracker_expand_btn_open())).click();
//		List<String> checkbox_list_healthTracker = new ArrayList<String>(Arrays.asList(checkboxes_healthTracker.split(",")));
//		log.info("List value: "+checkbox_list_healthTracker);
//		List<WebElement>healthTracker_subMenues_list = pgss.healthTracker_subMenus();
//		log.info("profile size: "+healthTracker_subMenues_list.size());
//
//		for(String cb_healthTracker : checkbox_list_healthTracker){
//			log.info("check value: "+checkbox_list_healthTracker);
//		 for (WebElement chk_healthTracker : healthTracker_subMenues_list){
//			 log.info("chk value: "+chk_healthTracker);
//			if(chk_healthTracker.getText().equalsIgnoreCase(cb_healthTracker))
//				log.info("chk text: "+chk_healthTracker.getText()); //'"+eventName+"
//			chk_healthTracker.findElement(By.xpath("//label[contains(text(),'"+cb_healthTracker+"')]")).click();
//			   break;
//			 }
//		 }
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.healthTracker_expand_btn_close())).click();
//		}
//		String checkboxes_medicalCare = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing", 1, 9);
//		log.info("Data from excel: "+checkboxes_medicalCare);
//		if(checkboxes_medicalCare.length()>0)
//		{
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.medicalCare_expand_btn_open())).click();
//		List<String> checkbox_list_medicalCare = new ArrayList<String>(Arrays.asList(checkboxes_medicalCare.split(",")));
//		log.info("List value: "+checkbox_list_medicalCare);
//		List<WebElement>medicalCare_subMenues_list = pgss.medicalCare_subMenus();
//		log.info("profile size: "+medicalCare_subMenues_list.size());
//
//		for(String cb_medicalCare : checkbox_list_medicalCare){
//			log.info("check value: "+checkbox_list_medicalCare);
//		 for (WebElement chk_medicalCare : medicalCare_subMenues_list){
//			 log.info("chk value: "+chk_medicalCare);
//			if(chk_medicalCare.getText().equalsIgnoreCase(cb_medicalCare))
//				log.info("chk text: "+chk_medicalCare.getText()); //'"+eventName+"
//			chk_medicalCare.findElement(By.xpath("//label[contains(text(),'"+cb_medicalCare+"')]")).click();
//			   break;
//			 }
//		 }
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.medicalCare_expand_btn_close())).click();
//		}
//		String checkbox_Alerts = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing",1,10);
//		if(checkbox_Alerts.equalsIgnoreCase("Y"))
//		{
//			pgss.alerts_checkBox().click();
//		}
//		String checkbox_healthTopic = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing",1,11);
//		if(checkbox_healthTopic.equalsIgnoreCase("Y"))
//		{
//			pgss.healthTopic_checkBox().click();
//		}
//		String checkbox_myDocument = ExcelUtility.readTestdata(testdataSheet, "ProfilePage-AccessSharing",1,12);
//		if(checkbox_myDocument.equalsIgnoreCase("Y"))
//		{
//			pgss.myDocument_checkBox().click();
//		}
//
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.add_access_sharing_btn())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(pgss.access_sharing_view_info_btn())).click();


		

	
	


