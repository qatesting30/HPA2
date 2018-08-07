package com.healthec.test.functional;

import java.util.concurrent.TimeUnit;
import com.healthec.UI.BackButton;
import com.healthec.UI.FieldValidation;
import com.healthec.UI.Swipe;
import com.healthec.UI.SwitchView;
import com.healthec.generic.utils.*;
import com.healthec.object.repo.DashboardPageObjects;
import com.healthec.project.Resources.Dashboard_Recovery;
import com.healthec.project.Resources.Login_Recovery;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.healthec.test.functional.LoginPageUC.driver;


public class DashboardPageUC extends TestBaseClass {

	public static WebDriverWait wait;
	public static DashboardPageObjects dps;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeClass(alwaysRun = true)
	public static void beforeDashboardPageClass()
	{
        //log.info("driver value1: "+driver);
		Dashboard_Recovery.checkForDashboardPage(driver);
		driver = Login_Recovery.driver;
        dps = new DashboardPageObjects(driver);
        SwitchView.changeContext(driver, "WEBVIEW");
	}


    @BeforeTest(alwaysRun = true,dependsOnGroups = {"login"})
	public static void beforedDashboardPageTest()
	{
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait=(WebDriverWait)new WebDriverWait(driver, 30);
	}
	//mood validation
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_001() throws Exception
	{
        log.info("Clicking on moods button");
		FieldValidation.elementValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 1st mood button");
		FieldValidation.elementValidation(driver,dps.mood1,testClassName,testMethodName).click();
		//Assert.assert

	}
		 
    @Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_002() throws Exception
	{
        log.info("Clicking on moods button");
        FieldValidation.elementValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 2nd mood button");
        FieldValidation.elementValidation(driver,dps.mood2,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_003() throws Exception
	{
        log.info("Clicking on moods button");
        FieldValidation.elementValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 3rd mood button");
        FieldValidation.elementValidation(driver,dps.mood3,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_004() throws Exception
	{
        log.info("Clicking on moods button");
        FieldValidation.elementValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 4th mood button");
        FieldValidation.elementValidation(driver,dps.mood4,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_005() throws Exception
	{
        log.info("Clicking on moods button");
        FieldValidation.elementValidation(driver,dps.moods,testClassName,testMethodName).click();
        log.info("Clicking on 5th mood button");
        FieldValidation.elementValidation(driver,dps.mood5,testClassName,testMethodName).click();

	}
	//dasboard box validation
	  //calorie-box validation
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_006()
	{
        log.info("Clicking on calorie box button");
        FieldValidation.elementValidation(driver,dps.calorie_box,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.elementValidation(driver,dps.back_btn,testClassName,testMethodName).click();
        log.info("Clicking on bmi box button");
        FieldValidation.elementValidation(driver,dps.bmi_box,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.elementValidation(driver,dps.back_btn,testClassName,testMethodName).click();
        log.info("Clicking on bp box button");
        FieldValidation.elementValidation(driver,dps.bp_box,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.elementValidation(driver,dps.back_btn,testClassName,testMethodName).click();
	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_007()
	{
        log.info("Validating week range");
		String start_date =null;
		String end_date =null;
		try {
            for (int i = 0; i < dps.displaying_week_list.size(); i++) {
                start_date = dps.displaying_week_list.get(0).getText();
                end_date = dps.displaying_week_list.get(dps.displaying_week_list.size() - 1).getText();
            }
            log.info("Week range displaying is: " + (start_date.trim()) + " and " + end_date.trim());
        }catch(Exception e)
        {
            ExcelUtility.writeStatus(testCaseSheet, testClassName, testMethodName, "Actual_Output", "Element not present ");
        }
	
	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_008()
	{
		try{
            log.info("Checking records present");
            wait.until(ExpectedConditions.visibilityOf(dps.no_record_text));

		}catch(Exception e)
		{
            log.info("Alerts are present");
		    log.info("alert(s) displaying");
		}
	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_009()
	{
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on home tab button");
        FieldValidation.elementValidation(driver,dps.home_tab,testClassName,testMethodName).click();
	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_010()
	{
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on profile tab");
        FieldValidation.elementValidation(driver,dps.profile_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.elementValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_011()
	{
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on health tracker tab");
        FieldValidation.elementValidation(driver,dps.healthTracker_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.elementValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups ={"smoke"})
	public static void dashBoardPageTC_012()
	{
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on medical care tab");
        FieldValidation.elementValidation(driver,dps.medicalCare_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.elementValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_013()
	{
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on alerts tab");
        FieldValidation.elementValidation(driver,dps.alerts_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.elementValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_014()
	{
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on health topic tab");
        FieldValidation.elementValidation(driver,dps.healthTopic_tab,testClassName,testMethodName).click();
        SwitchView.changeContext(driver,"NATIVE_APP");
		try{
            wait.until(ExpectedConditions.invisibilityOf(dps.healthTopic_spinner));
        }catch(Exception e){
            log.info("Exception in getting spinner: "+e.getMessage());
            ExcelUtility.writeStatus(testCaseSheet, testClassName, testMethodName, "Actual_Output", "Element not present ");
        }
        SwitchView.changeContext(driver,"WEBVIEW");
		//wait.until(ExpectedConditions.visibilityOf(dps.healthTopic_page)).isDisplayed();
        HealthTopicBackButton.backBtn(driver);

	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_015()
	{
	    /*log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();*/
        log.info("Clicking on my document button");
        FieldValidation.elementValidation(driver,dps.myDocument_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.elementValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_016()
	{
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on settings tab");
        FieldValidation.elementValidation(driver,dps.settings_tab,testClassName,testMethodName).click();
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on home button");
        FieldValidation.elementValidation(driver,dps.home_tab,testClassName,testMethodName).click();

		
	}
	@Test(enabled=true,groups = {"smoke"})
	public static void dashBoardPageTC_017()
	{
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on help tab");
        FieldValidation.elementValidation(driver,dps.help_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        FieldValidation.elementValidation(driver,dps.back_btn,testClassName,testMethodName).click();

	}
	@Test(enabled=true,groups = {"smoke"})
    public static void dashBoardPageTC_018()
    {
        log.info("Clicking on menu button");
        FieldValidation.elementValidation(driver,dps.menu_btn,testClassName,testMethodName).click();
        log.info("Clicking on contact us tab");
        FieldValidation.elementValidation(driver,dps.contact_us_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        BackButton.backButon(driver);
    }
    @Test(enabled=true,groups = {"smoke"})
    public static void dashBoardPageTC_019()
    {
        log.info("Clicking on privacy policy");
        FieldValidation.elementValidation(driver,dps.privacy_policy_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
    	BackButton.backButon(driver);
    }
    @Test(enabled=true,groups = {"smoke"})
    public static void dashBoardPageTC_020()
    {
        log.info ("swiping down");
        Swipe.swipeVerticalDown(driver,2);
        log.info("Clicking on terms of use");
        FieldValidation.elementValidation(driver,dps.terms_of_use_tab,testClassName,testMethodName).click();
        log.info("Clicking on back button");
        BackButton.backButon(driver);
    }
}
