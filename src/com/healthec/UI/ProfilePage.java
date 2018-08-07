package com.healthec.UI;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.healthec.object.repo.AOSProfilePage;

public class ProfilePage {
	
	RemoteWebDriver driver;
	String instance;
	AOSProfilePage aos;
	
	public ProfilePage(RemoteWebDriver driver)
	{
		this.driver=driver;
		instance=driver.getClass().getName();
		aos=new AOSProfilePage();
	}
	public WebElement menu_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.menu_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement menu_back_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.menu_back_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement home_tab()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.home_tab);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement profile_tab()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.profile_tab);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	//contacts
	public WebElement contacts_menu()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.contacts_menu);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement personal_tab()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.personal_tab);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement No_record_message()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.no_record_text);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement editAndUpdate_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.personal_editAndUpdate_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement phoneNumber_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.personal_phone_number);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement email_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.email_personal);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement address_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.address);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement personal_city_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.city_personal);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement personal_state_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.state_personal);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement personal_zipcode_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.zipcode_personal);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement updated_sucessfully_pop_up_ok_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.updated_successfully_popup);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_tab()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.Emergency_tab);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_editAndUpdate_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.emergency_editAndUpdate_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_firstname_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.firstname);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_lastname_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.lastname);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_phonenumber_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.emergency_phone_number);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_email_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.email_emergency);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_street_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.street);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_city_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.city_emergency);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_state_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.state_emergency);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_zipcode_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.zipcode_emergency);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement emergency_updatedSucessfully_popUp_ok_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.emergency_updated_successfully_popup);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement back_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.back_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	//physiscian
	public WebElement physician_tab()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.physicians_tab);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement add_physician_icon()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.add_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement physician_lastname()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.physicians_lastname);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement physician_firstname()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.physicians_firstname);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement physician_phone_number()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.physicians_phone_number);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement physician_email()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.physicians_email);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement physician_type()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.select_physicians);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement add_physician_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.add_physician_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement add_more_popUp_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.add_more_pop_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement view_info__popUp_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.view_info_pop_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	//pharmacy
	public WebElement pharmacy_tab()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.pharmacy_tab);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement pharmacy_add_icon()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.add_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement pharmacy_Name_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.pharmacy_Name_txt_field);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement contact_person_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.contact_person_txt_field);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement pharmacy_phone_number_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.pharmacy_phone_number_txt_field);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement pharmacy_add_data_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.pharmacy_add_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	//Insurance 
	public WebElement Insurance_tab()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.insurance_tab);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement Insurance_add_icon()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.add_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement Insurance_type()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.insurance_type);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement plan_type()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.plan_type);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement plan_name()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.plan_name);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement group_number()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.group_number);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement insurance_add_data_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.insurance_add_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	//social-history
	public WebElement social_history_tab()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.social_history_tab);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement edit_social_history_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.edit_social_history);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement update_social_history_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.update_social_history);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement alcohol_radio_btn_no()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.alcohol_radio_btn_no);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement alcohol_radio_btn_yes()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.alcohol_radio_btn_yes);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement drinks_per_week()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.drink_per_week);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement drinks_no_of_years()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.drink_noOfYears);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement smoke_radio_btn_no()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.smoke_radio_btn_no);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement smoke_radio_btn_yes()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.smoke_radio_btn_yes);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement packs_per_week()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.packs_per_week);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement packs_no_of_years()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.packs_noOfYears);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement exercise_radio_btn_no()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.exercise_radio_btn_no);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement exercise_radio_btn_yes()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.exercise_radio_btn_yes);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement exercise_per_week()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.exercise_per_week);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement exercise_type()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.exercise_type);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement updated_successfully_ok_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.updated_successfully_ok_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	//Access-sharing
	public WebElement access_sharing_tab()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_sharing_tab);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement add_access_sharing_add_icon()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.add_access_sharing_icon);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement search_user_by_lastName()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.search_txt_field);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement search_check_user_available()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.serach_no_user_results_found);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
	}
	public WebElement search_user_autopopulate_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.search_autopopulate_user);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement search_user_autopopulate_field_firstname()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.search_autopopulate_user_first_name);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement search_user_lastname_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.user_lastname_txt_field);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement search_user_firstname_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.user_firstname_txt_field);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement search_user_email_txt_field()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.user_email_txt_field);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_relationship_dropdown()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.user_relationship_dropdown);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_level_dropdown()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.user_acess_level_dropdown);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_duration_dromDate_datePicker()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_from);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_duration_from_month()
	{
		try{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_from_month_dropdown);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		}
		catch(Exception e){
			System.out.println("Exception in finding element: "+e.getMessage());
		}
		return null; 
	}
	public List<WebElement> user_access_duration_from_select_month()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElements(aos.access_duration_from_month_select_month);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_duration_from_year()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_from_year_dropdown);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public List<WebElement> user_access_duration_from_select_year()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElements(aos.access_duration_from_month_select_year);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public List<WebElement> user_access_duration_from_select_dates()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElements(aos.access_duration_from_select_dates);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_duration_fromdate_Ok_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_from_ok_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_duration_fromdate_cancel_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_from_cancel_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	
	public WebElement user_access_duration_todate_datePicker()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_to);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_duration_todate_month_dropdown()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_to_month_dropdown);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_duration_todate_year_dropdown()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_to_year_dropdown);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_duration_toDate_cancel_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_toDate_cancel_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement user_access_duration_toDate_ok_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.access_duration_toDate_ok_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement select_features_profile_all()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.features_profile);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement select_features_health_tracker_all()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.features_healthTracker);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement select_features_medical_care_all()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.features_medicalCare);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement select_features_alerts_all()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.features_alerts);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement select_features_health_topic_all()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.features_healthtopic);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement select_features_my_document_all()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.features_myDocument);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement notes()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.notes);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	public WebElement add_access_sharing_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.add_access_sharing_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null; 
	}
	//features
	public WebElement profile_expand_btn_open()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.profile_expand_btn_open);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;	
	}
	public WebElement profile_expand_btn_close()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.profile_expand_btn_close);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;	
	}
	public List<WebElement>profile_subMenus()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElements(aos.profile_subMenus);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;	
	}
	
   public WebElement profile_contacts_checkBox()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.profile_Contacts);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;	
	}
   public List<WebElement>healthTracker_subMenus()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElements(aos.healthTracker_subMenus);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;	
	}
	public WebElement healthTracker_expand_btn_open()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.healthTracker_expand_btn_open);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;	
	}
	public WebElement healthTracker_expand_btn_close()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.healthTracker_expand_btn_close);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;	
	}
	
	
	 public List<WebElement>medicalCare_subMenus()
		{
			if(instance.contains("AndroidDriver"))
				return driver.findElements(aos.medicalCare_subMenus);
			else if (instance.contains("IOSDriver"))
				System.out.println("Not yet Implemented");
			return null;	
		}
		public WebElement medicalCare_expand_btn_open()
		{
			if(instance.contains("AndroidDriver"))
				return driver.findElement(aos.medicalCare_expand_btn_open);
			else if (instance.contains("IOSDriver"))
				System.out.println("Not yet Implemented");
			return null;	
		}
		public WebElement medicalCare_expand_btn_close()
		{
			if(instance.contains("AndroidDriver"))
				return driver.findElement(aos.medicalCare_expand_btn_close);
			else if (instance.contains("IOSDriver"))
				System.out.println("Not yet Implemented");
			return null;	
		}
		public WebElement alerts_checkBox()
		{
			if(instance.contains("AndroidDriver"))
				return driver.findElement(aos.alerts_checkbox);
			else if (instance.contains("IOSDriver"))
				System.out.println("Not yet Implemented");
			return null;	
		}
		public WebElement healthTopic_checkBox()
		{
			if(instance.contains("AndroidDriver"))
				return driver.findElement(aos.healthTopic_checkbox);
			else if (instance.contains("IOSDriver"))
				System.out.println("Not yet Implemented");
			return null;	
		}
		public WebElement myDocument_checkBox()
		{
			if(instance.contains("AndroidDriver"))
				return driver.findElement(aos.myDocument_checkbox);
			else if (instance.contains("IOSDriver"))
				System.out.println("Not yet Implemented");
			return null;	
		}
		public WebElement access_sharing_view_info_btn()
		{
			if(instance.contains("AndroidDriver"))
				return driver.findElement(aos.view_Info_access_sharing);
			else if (instance.contains("IOSDriver"))
				System.out.println("Not yet Implemented");
			return null;	
		}
		public WebElement access_sharing_add_more_btn()
		{
			if(instance.contains("AndroidDriver"))
				return driver.findElement(aos.add_more_access_sharing);
			else if (instance.contains("IOSDriver"))
				System.out.println("Not yet Implemented");
			return null;	
		}
		
	 
	
}
