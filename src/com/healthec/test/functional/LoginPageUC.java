package com.healthec.test.functional;


import java.util.concurrent.TimeUnit;

import com.healthec.UI.BackButton;
import com.healthec.UI.FieldValidation;
import com.healthec.UI.HideKeyBoard;
import com.healthec.UI.SwitchView;
import com.healthec.generic.utils.*;
import com.healthec.object.repo.LoginPageObjects;
import com.healthec.project.Resources.Login_Recovery;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.healthec.project.spec.CreateDriver;


    public class LoginPageUC extends TestBaseClass{

        public static RemoteWebDriver driver;
        public static WebDriverWait wait;
        public static LoginPageObjects lps ;
        public static Logger log = Logger.getLogger("devpinoyLogger");
        public static String platform;
        public static String deviceType;

	
	@BeforeClass(alwaysRun=true)
	public static void beforeloginPageClass() throws InterruptedException {

        SwitchView.changeContext(driver, "WEBVIEW");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
        driver= Login_Recovery.driver;
        lps=Login_Recovery.lps; //
	}
	@Parameters({"platform","deviceType"})
	@BeforeTest(alwaysRun = true,groups = {"login"})
	public static void beforeloginPageTest(String platform,String deviceType)
	{
	    driver= CreateDriver.getDriver(platform,deviceType);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait=(WebDriverWait)new WebDriverWait(driver, 30);
        lps=new LoginPageObjects(driver);
	}
	//contact us link
    @Test(enabled=true,groups = {"smoke"} )
    public static void Loginpage_TC_001() throws Exception
	{
        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
	    log.info("Clicking on contact us link");
		FieldValidation.elementValidation(driver,lps.contact_us_link,testClassName,testMethodName).click();
		Thread.sleep(3000);
		BackButton.backButon(driver);
//        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
//         Activity act = new Activity("com.android.chrome","com.google.android.apps.chrome.IntentDispatcher"); //org.chromium.chrome.browser.ChromeTabbedActivity
//        ((AndroidDriver) driver).startActivity(act);
//        log.info( "current activity: "+((AndroidDriver) driver).currentActivity());
//        SwitchView.changeContext(driver, "WEBVIEW_chrome");
//        /*((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
//        Thread.sleep(2000);
//        ((AndroidDriver) driver).startActivity(act);
//        Thread.sleep(2000);
//        SwitchView.changeContext(driver, "WEBVIEW_chrome");*/
//        log.info("page source1: "+driver.getPageSource());
//        FieldValidation.elementValidation(driver,lps.contact_us_link_page_validation,testClassName,testMethodName);
//
//        /*SwitchView.changeContext(driver,"NATIVE_APP");
//        Thread.sleep(3000);
//        SwitchView.changeContext(driver,"WEBVIEW_chrome");
//        log.info("driver value: "+driver.getCurrentUrl());
//        log.info("window handle: "+driver.getWindowHandles());*/
//        FieldValidation.elementValidation(driver,lps.contact_us_link_page_validation,testClassName,testMethodName);
//       /* log.info("Validating contact us link page");
//        Thread.sleep(3000);
//        AndroidDriver driver1 = (AndroidDriver)driver;
//        log.info("current context: "+driver1.getContext());
//        log.info("current URL: "+driver1.getCurrentUrl());
//        Thread.sleep(3000);
//       *//* SwitchView.changeContext(driver,"NATIVE_APP");
//        //SwitchView.changeContext(driver,"WEBVIEW_chrome");
//        log.info("current context: "+driver1.getContext());
//        Thread.sleep(3000);*//*
//        log.info(((AndroidDriver) driver).currentActivity());
//        log.info(((AndroidDriver) driver).getCurrentPackage());
//        log.info("page source1: "+driver.getPageSource());
//
//       *//* Activity act = new Activity(((AndroidDriver) driver).getCurrentPackage(),((AndroidDriver) driver).currentActivity());
//        ((AndroidDriver) driver).startActivity(act);
//        Thread.sleep(3000);*//*
//        SwitchView.changeContext(driver,"WEBVIEW_chrome");
//
//        log.info("page source2: "+driver.getPageSource());
//        log.info("current URL: "+driver1.getCurrentUrl());
//        FieldValidation.elementValidation(driver,lps.contact_us_link_page_validation,testClassName,testMethodName);
//	    //Thread.sleep(3000);
//		//log.info("Waited for 3 seconds");

	}//privacy policy link
	@Test(enabled=true,groups={"smoke"})
	public static void Loginpage_TC_002() throws Exception
	{
        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
	    log.info("Clicking on privacy policy link");
        FieldValidation.elementValidation(driver,lps.privacy_policy_link,testClassName,testMethodName).click();
       // wait.until(ExpectedConditions.visibilityOf(lps.privacu_policy_link_page_validation)).isDisplayed();
		Thread.sleep(3000);
		log.info("Waited for 3 seconds");
        BackButton.backButon(driver);
		log.info("Clicked on device back button");
	}//terms of use link
	@Test(enabled=true,groups={"smoke"})
	public static void Loginpage_TC_003() throws Exception
	{
        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
        log.info("Clicking on terms of us link");
        FieldValidation.elementValidation(driver,lps.terms_of_use_link,testClassName,testMethodName).click();
       // wait.until(ExpectedConditions.visibilityOf(lps.terms_of_use_link_page_validation)).isDisplayed();
        Thread.sleep(3000);
		log.info("Waited for 3 seconds");
        BackButton.backButon(driver);
		log.info("Clicked on device back button");

    }
	//Sign up button
	@Test(enabled=true,groups={"smoke"})
	public static void Loginpage_TC_004() throws Exception
	{
        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
        log.info("Clicking on sign up link");
        FieldValidation.elementValidation(driver,lps.signUp_link,testClassName,testMethodName).click();
        Thread.sleep(2000);
		//BackButton.backButon(driver);
        log.info("Clicking on back button in sign up page");
		FieldValidation.elementValidation(driver,lps.signUp_bck_btn,testClassName,testMethodName).click();
	}
    @Test(enabled=true,groups={"smoke"})
    public static void Loginpage_TC_005() throws InterruptedException {

        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
        log.info("Clicking on forgot password link");
        FieldValidation.elementValidation(driver,lps.forgotPassword_link,testClassName,testMethodName).click();
        Thread.sleep(2000);
        //BackButton.backButon(driver);
        log.info("Clicking on back button in forgot password page");
        FieldValidation.elementValidation(driver,lps.forgotPassword_bck_btn,testClassName,testMethodName).click();
	}
    //Both username and password field are blank
	@Test(enabled=true,groups={"smoke"})
	public static void Loginpage_TC_006()
	{
        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
        log.info("Clicking on login button");
        FieldValidation.elementValidation(driver,lps.login_btn,testClassName,testMethodName).click();
        log.info("Validating username related error message");
		//log.info("text is: "+lps.login_error_msg.getAttribute("name"));
		//log.info("text is: "+lps.login_error_msg.getText());
		Assert.assertEquals(lps.login_error_msg.getText(), "User Name and Password are required");

	}
	//Username field is blank
	@Test(enabled=true,groups={"smoke"})
	public static void Loginpage_TC_007()
	{
        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
        log.info("Entering password value");
        FieldValidation.elementValidation(driver,lps.login_btn,testClassName,testMethodName).click();
        log.info("Validating password related error message");
        FieldValidation.elementValidation(driver,lps.password_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, testClassName, 1, 1));
        log.info("hidekeyboard");
        HideKeyBoard.hideKeyBoard(driver);
        /*  TouchActions act = new TouchActions(driver);
	    act.doubleClick(lp.login_Btn()).build().perform();*/
        log.info("Clicking on login button");
        FieldValidation.elementValidation(driver,lps.login_btn,testClassName,testMethodName).click();
		/*log.info("Clicked on login button");
		wait.until(ExpectedConditions.elementToBeClickable(lps.login_btn)).click();*/
		log.info("validating error message");
		Assert.assertEquals(lps.login_error_msg.getText(), "User Name Required");
	}
	//password field is blank
	@Test(enabled=true,groups={"smoke"})
	public static void Loginpage_TC_008()
	{
        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
        log.info("Entering username");
        FieldValidation.elementValidation(driver,lps.username_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, testClassName, 1, 0));
        log.info("Clearing passsword field ");
        FieldValidation.elementValidation(driver,lps.password_txt_field,testClassName,testMethodName).clear();
		log.info("Hidekeyboard");
		HideKeyBoard.hideKeyBoard(driver);
		log.info("Clicking on login button");
        FieldValidation.elementValidation(driver,lps.login_btn,testClassName,testMethodName).click();
        log.info("validating password error message");
		Assert.assertEquals(lps.password_error_msg.getText(), "Password Required");
	}
	//username/password is invalid
	@Test(enabled=true,groups={"smoke"})
	public static void Loginpage_TC_009()
	{
        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
        log.info("Clearing username field ");
        FieldValidation.elementValidation(driver,lps.username_txt_field,testClassName,testMethodName).clear();
        log.info("Entering invalid username ");
        FieldValidation.elementValidation(driver,lps.username_txt_field,testClassName,testMethodName).sendKeys("Invalid_username");
		log.info("Entering invalid password");
        FieldValidation.elementValidation(driver,lps.password_txt_field,testClassName,testMethodName).sendKeys("Invalid password");
        log.info("Hidekeyboard");
		HideKeyBoard.hideKeyBoard(driver);
		log.info("Clicking on login button");
        FieldValidation.elementValidation(driver,lps.login_btn,testClassName,testMethodName).click();
        log.info("Validating invalid credentials displayed");
		// wait.until(ExpectedConditions.invisibilityOf(lp.spinner()));
        wait.until(ExpectedConditions.visibilityOf(lps.invalid_credentials_popup));
        Assert.assertTrue(lps.invalid_credentials_popup.isDisplayed());
        log.info("Clicking on ok button of invalid credentials password");
		//assertEquals(lp.invalid_credentials_popup().getAttribute("name"), "Invalid User Name or Password. Try again");
        FieldValidation.elementValidation(driver,lps.invalid_credentials_popup_Ok,testClassName,testMethodName).click();
	}
	@Test(enabled=true,groups={"smoke"})
	public static void Loginpage_TC_010()
	{
        log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);
        log.info("Clicking on remember me checkbox");
        FieldValidation.elementValidation(driver,lps.rememnber_me_checkbox,testClassName,testMethodName).click();
        log.info("Validating if checkbox is selected");
        Assert.assertTrue(lps.rememnber_me_checkbox.isSelected());
	}

	//password is invalid
	@Test(enabled=true,groups = {"smoke","regression"})
	public static void Loginpage_TC_011()
	{
        /*log.info ("validating login page scenario");
        Login_Recovery.checkForUsernamePasswordAndLogin(driver);*/
        log.info("Clearing username text field");
        FieldValidation.elementValidation(driver,lps.username_txt_field,testClassName,testMethodName).clear();
        log.info("Entering username");
        FieldValidation.elementValidation(driver,lps.username_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, testClassName, 1, 0));
        log.info("Clearing password text field");
        FieldValidation.elementValidation(driver,lps.password_txt_field,testClassName,testMethodName).clear();
        log.info("Entering password");
        FieldValidation.elementValidation(driver,lps.password_txt_field,testClassName,testMethodName).sendKeys(ExcelUtility.readTestdata(testdataSheet, testClassName, 1, 1));
        log.info("Hidekeyboard");
		HideKeyBoard.hideKeyBoard(driver);
        log.info("Clicking on login button");
        FieldValidation.elementValidation(driver,lps.login_btn,testClassName,testMethodName).click();
        log.info("Validating if logged in");
        if(FieldValidation.elementValidation(driver,lps.login_In_Check,testClassName,testMethodName).isDisplayed()){
			log.info("Sucessfully logged in");
			log.info("Dashboard displayed");
		}
		else{
			log.info("login Unsuccessful");
//			throw new SkipException("Unable to login");

        }
	}
}
