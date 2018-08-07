package com.healthec.generic.Functions;

import com.healthec.UI.FieldValidation;
import com.healthec.UI.HideKeyBoard;
import com.healthec.UI.Swipe;
import com.healthec.generic.utils.ExcelUtility;
import com.healthec.generic.utils.TestBaseClass;
import com.healthec.object.repo.ProfilePageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.healthec.test.functional.LoginPageUC.driver;

public class Profile_Functions extends TestBaseClass{

    public static ProfilePageObjects pgs;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    public static void checkContactsPageEditable(RemoteWebDriver driver){
        boolean flag=false;
        pgs=new ProfilePageObjects(driver);
        Swipe.swipeVerticalDown(driver, 5);
        try{
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try{
            if(FieldValidation.elementValidation(driver,pgs.personal_cancel_btn,testClassName,testMethodName).isDisplayed()){
                log.info("Page is editable");
            }}
            catch(Exception e){

                System.out.println("Hii all");
                FieldValidation.elementValidation(driver,pgs.personal_editAndUpdate_btn,testClassName,testMethodName).click();
                }
        }catch(Exception e){
            log.info("Exception in finding add button:"+e.getMessage());
        }
        Swipe.swipeVerticalUp(driver, 5);
    }

    public static WebElement clickElementBasedOnPhysicianName(RemoteWebDriver driver,String name) {

        WebElement element = driver.findElement(By.xpath("//div[@class='Record_One']/div[@class='Record_Right_One']//span[contains(text(),'" + name + "')]//ancestor::div[@class='Record_Main']//img[@class='Edit_Record']"));
        System.out.println("element: " + element);
        return element;
    }

    public static void addPhysician(RemoteWebDriver driver, ProfilePageObjects pgs){
        log.info("Clearing data in phone number text field");
        FieldValidation.elementValidation(driver,pgs.phoneNumber_txt_field,testClassName,testMethodName).clear();
        log.info("Entering updated data in phone number text field");
        FieldValidation.elementValidation(driver,pgs.phoneNumber_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Physicians", 1, 6));
        log.info("hiding keyboard");
        HideKeyBoard.hideKeyBoard(driver);
        Swipe.swipeVerticalDown(driver, 3);
        FieldValidation.elementValidation(driver,pgs.physician_update_btn,testClassName,testMethodName).click();
    }

    public static void addPharmacy(RemoteWebDriver driver,ProfilePageObjects pgs){
        log.info("clearing pharmacy name text field");
        FieldValidation.elementValidation(driver,pgs.pharmacy_pharmacy_name_txt_field,testClassName,testMethodName).clear();
        log.info("Entering data in pharmacy name text field");
        FieldValidation.elementValidation(driver,pgs.pharmacy_pharmacy_name_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 0));
        log.info("clearing contact person text field");
        FieldValidation.elementValidation(driver,pgs.pharmacy_contact_person_text_field,testClassName,testMethodName).clear();
        log.info("Entering data in contact person text field");
        FieldValidation.elementValidation(driver,pgs.pharmacy_contact_person_text_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 1));
        log.info("clearing phone number text field");
        FieldValidation.elementValidation(driver,pgs.pharmacy_phone_number_txt_field,testClassName,testMethodName).clear();
        log.info("Entering data in phone number text field");
        FieldValidation.elementValidation(driver,pgs.pharmacy_phone_number_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, "ProfilePage-Pharmacy", 1, 2));
        log.info("Clicking on add button");
        FieldValidation.elementValidation(driver,pgs.add_pharmacy_btn,testClassName,testMethodName).click();
    }
}
