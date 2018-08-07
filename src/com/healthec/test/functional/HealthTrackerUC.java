package com.healthec.test.functional;

import com.healthec.UI.FieldValidation;
import com.healthec.UI.Scroll;
import com.healthec.UI.SwitchView;
import com.healthec.generic.utils.*;
import com.healthec.object.repo.HealthTrackerPageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.healthec.test.functional.LoginPageUC.driver;
import java.util.concurrent.TimeUnit;

public class HealthTrackerUC extends TestBaseClass {

    public static WebDriverWait wait;
    public static HealthTrackerPageObjects hts;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    @BeforeClass
    public static void beforeHealthTrackerClass()
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait=(WebDriverWait)new WebDriverWait(driver, 30);
        SwitchView.changeContext(driver, "WEBVIEW");
    }


    @BeforeTest
    public static void beforeHealthTrackerTest()
    {
        hts = new HealthTrackerPageObjects(driver);

    }

    @Test(enabled = true)
    public static void healthTrackerPageTC_001()
    {
        FieldValidation.elementValidation(driver,hts.menu_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,hts.healthTracker_tab,testClassName,testMethodName).click();
        Assert.assertTrue(hts.healthTracker_page.isDisplayed());
    }
    @Test(enabled = true)
    public static void healthTrackerPageTC_002() throws Exception {
        FieldValidation.elementValidation(driver,hts.weight_tab,testClassName,testMethodName).click();
        try{
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if(hts.no_record_text.isDisplayed())
            {
                System.out.println("Records are not present");
            }
        }
        catch(Exception e)
        {
            System.out.println("records are present");
        }
        FieldValidation.elementValidation(driver,hts.add_weight_btn,testClassName,testMethodName).click();
        FieldValidation.elementValidation(driver,hts.date_field,testClassName,testMethodName).click();
        String weight_date = ExcelUtility.readTestdata(testdataSheet,"HealthTracker-Weight",1,0);
        System.out.println("Extracted weight_date: "+weight_date);
        DateCheck weight_dt = new DateCheck(weight_date);
        String weight_month = weight_dt.getMonth();
        int weight_year = weight_dt.getYear();
        String weight_day = Integer.toString(weight_dt.getDay());
        System.out.println("weight_year: "+weight_year);
        System.out.println("weight_month: "+weight_month);
        System.out.println("weight_day: "+weight_day);
        FieldValidation.elementValidation(driver,hts.date_datePicker_year_dropdown,testClassName,testMethodName).click();
        Scroll.scrollToText(driver,weight_year);
        FieldValidation.elementValidation(driver,hts.date_datePicker_month_dropdown,testClassName,testMethodName).click();
        Scroll.scrollToText(driver,weight_month);
        System.out.println("Totals weight dates: "+hts.date_datePicker_day.size());
        for(WebElement day : hts.date_datePicker_day) {
            if (day.getText().equalsIgnoreCase(weight_day)) {
                day.click();
            } else {
                //System.out.println(days.getText());
                System.out.println("Not able to find dates from date picker");
            }
        }
    }
    @Test(enabled=true)
    public static void healthTrackerPageTC_003()
    {

    }

}


