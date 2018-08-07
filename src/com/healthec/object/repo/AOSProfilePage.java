package com.healthec.object.repo;

import org.openqa.selenium.By;

public class AOSProfilePage {
	
	  public By menu_btn=By.xpath("//i[@class='material-icons header_menu_icn']");
	  public By menu_back_btn=By.xpath("//i[@class='material-icons panel_lft_arrw_icn']");
	  public By home_tab=By.id("idHome");
	  public By contacts_menu=By.xpath("//div[contains(text(),'Contacts')]");
	  public By profile_tab=By.xpath("//span[contains(text(),'Profile')]");
	  public By no_record_text=By.xpath("//div[@class='no-records-msg']");
	  public By back_btn=By.xpath("//i[@class='material-icons sub_head_lft_arrw_icn']");
	  public By add_btn=By.xpath("//a[@id='idViewAdd']");
	  public By add_more_pop_btn=By.id("idAddMore");
	  public By view_info_pop_btn=By.id("idViewInfo");
	  //contacts
	  public By personal_tab=By.id("idContactsPersonal");
	  public By personal_editAndUpdate_btn=By.id("editAndAdd");
	  public By cancel_btn=By.id("editAndAdd");
	  public By personal_phone_number=By.id("phoneNumber");
	  public By email_personal=By.id("emailID");
	  public By address=By.id("address");
	  public By city_personal=By.id("city");
	  public By state_personal=By.id("state");
	  public By zipcode_personal=By.id("pinCode");
	  public By updated_successfully_popup=By.id("idOk1");
	  //Emergency
	  public By Emergency_tab=By.id("idContactsEmergency");
	  public By firstname=By.id("firstName");
	  public By lastname=By.id("lastName");
	  public By emergency_phone_number=By.id("phoneNumber");
	  public By email_emergency=By.id("emailID");
	  public By street=By.id("street");
	  public By city_emergency=By.id("city");
	  public By state_emergency=By.id("state");
	  public By zipcode_emergency=By.id("pinCode");
	  public By emergency_editAndUpdate_btn=By.id("editAndAdd");
	  public By emergency_updated_successfully_popup=By.id("idOk1");
	  //physicians
	  public By physicians_tab=By.xpath("//div[contains(text(),'Physicians')]");
	  //public By physicians_add_btn=By.id("idViewAdd");
	  public By physicians_lastname=By.id("idLastName");
	  public By physicians_firstname=By.id("idFirstName");
	  public By physicians_phone_number=By.id("idNumber");
	  public By physicians_email=By.id("idEmail");
	  public By select_physicians=By.id("idSelectPhyType");
	  public By physicians_type_dentist=By.xpath("//option[contains(text(),'Dentist']");
	  public By physicians_type_facility=By.xpath("//option[contains(text(),'Dentist']");
	  public By physicians_type_lab=By.xpath("//option[contains(text(),'Dentist']");
	  public By physicians_type_pcp=By.xpath("//option[contains(text(),'Dentist']");
	  public By physicians_type_specialist=By.xpath("//option[contains(text(),'Dentist']");
	  public By add_physician_btn=By.id("idAddPhysician");
	  //pharmacy
	  public By pharmacy_tab=By.xpath("//div[contains(text(),'Pharmacy')]");
	  public By pharmacy_Name_txt_field=By.id("idPharmacyName");
	  public By contact_person_txt_field=By.id("idContactPerson");
	  public By pharmacy_phone_number_txt_field=By.id("idPhoneNumber");
	  public By pharmacy_add_btn=By.id("idAddPharmacy");
	  //Insurance
	  public By insurance_tab=By.xpath("//div[contains(text(),'Insurance')]");
	  public By insurance_type=By.id("idInsuranceType");
	  public By plan_type=By.id("idPlanType");
	  public By plan_name=By.id("idPlanName");
	  public By group_number=By.id("idGroupNumber");
	  public By insurance_add_btn=By.id("idAddInsurance");
	  //Social History
	  public By social_history_tab=By.xpath("//div[contains(text(),'Social History')]");
	  public By edit_social_history=By.id("idAddSocialHistory");
	  public By update_social_history=By.id("idUpdateSocialHistory");
	  public By alcohol_radio_btn_no=By.id("idRadioAlcohalNo");
	  public By alcohol_radio_btn_yes=By.id("idRadioAlcohalYes");
	  public By drink_per_week=By.id("idDrinkPerWeek");
	  public By drink_noOfYears=By.id("idDrinkNumberYear");
	  public By smoke_radio_btn_no=By.id("idRadioSmokeNo");
	  public By smoke_radio_btn_yes=By.id("idRadioSmokeYes");
	  public By packs_per_week=By.id("idSmokePackPerWeek");
	  public By packs_noOfYears=By.id("idSmokeNumberYear");
	  public By exercise_radio_btn_no=By.id("idRadioExerciseNo");
	  public By exercise_radio_btn_yes=By.id("idRadioExerciseYes");
	  public By exercise_per_week=By.id("idExcerciseDayPerWeek");
	  public By exercise_type=By.id("idExerciseType");
	  public By updated_successfully_ok_btn=By.id("idOk");
	  //Acess sharing
	  public By access_sharing_tab=By.xpath("//div[contains(text(),'Access Sharing')]");
	  public By add_access_sharing_icon=By.id("idAddAS");
	 // public By search_txt_field=By.xpath("//label[contains(text(),'Search by Last Name, First Name, Email')]");
	  public By search_txt_field=By.id("chained_relative-flexdatalist");
	  public By search_autopopulate_user=By.className("flexdatalist-results");
	 // public By serach_no_user_results_found=By.xpath("//li[contains(text(),'No results found for')]");
	  public By serach_no_user_results_found=By.xpath("//li[@class='item no-results']");
	  public By search_autopopulate_user_first_name=By.xpath("//span[@class='item item-firstName']");
	  public By user_lastname_txt_field=By.id("LastName");
	  public By user_firstname_txt_field=By.id("FirstName");
	  public By user_email_txt_field=By.id("Email");
	  public By user_relationship_dropdown=By.id("RelationOption");
	  public By user_acess_level_dropdown=By.id("AccessOption");
	  public By access_duration_from=By.id("myDocFromDate");
	 // public By access_duration_from_month_dropdown = By.className("ui-datepicker-month");
	  public By access_duration_from_month_dropdown = By.xpath("//select[@class='ui-datepicker-month']");
	  public By access_duration_from_month_select_month = By.xpath("//select[@class='ui-datepicker-month']/option");
	  public By access_duration_from_year_dropdown = By.className("ui-datepicker-year");
	  public By access_duration_from_month_select_year = By.xpath("//select[@class='ui-datepicker-year']/option");
	  public By access_duration_from_select_dates = By.xpath("//table[@class='ui-datepicker-calendar']//td");
	  public By access_duration_from_cancel_btn=By.id("datePickerCancel");
	  public By access_duration_from_ok_btn=By.id("datePickerOk");
	  public By access_duration_to=By.id("myDocToDate");
	  public By access_duration_to_month_dropdown=By.xpath("//div[@id='dobDatePicker1']//select[@class='ui-datepicker-month']");
	  public By access_duration_to_year_dropdown=By.xpath("//div[@id='dobDatePicker1']//select[@class='ui-datepicker-year']");
	  public By access_duration_toDate_cancel_btn=By.id("datePickerCancel1");
	  public By access_duration_toDate_ok_btn=By.id("datePickerOk1");
	  public By features_profile=By.xpath("//label[contains(text(),'Profile')]");
	  public By features_healthTracker=By.xpath("//label[contains(text(),'Health Tracker')]");
	  public By features_medicalCare=By.xpath("//label[contains(text(),'Medical Care')]");
	  public By features_alerts=By.xpath("//label[contains(text(),'Alerts')]");
	  public By features_healthtopic=By.xpath("//label[contains(text(),'Health Topic')]");
	  public By features_myDocument=By.xpath("//label[contains(text(),'My Document')]");
	  public By notes=By.id("message");
	  public By profile_Contacts=By.xpath("//label[contains(text(),'Contacts')]");
	  public By profile_expand_btn_open=By.xpath("//label[contains(text(),'Profile')]/parent::*//div[@class='arrow collapsed']");
	  public By profile_expand_btn_close=By.xpath("//label[contains(text(),'Profile')]/parent::*//div[@class='arrow expanded']");
	  public By profile_subMenus=By.xpath("//label[contains(text(),'Profile')]/parent::*//li");
	  public By healthTracker_subMenus=By.xpath("//label[contains(text(),'Health Tracker')]/parent::*//li");
	  public By healthTracker_expand_btn_open=By.xpath("//label[contains(text(),'Health Tracker')]/parent::*//div[@class='arrow collapsed']");
	  public By healthTracker_expand_btn_close=By.xpath("//label[contains(text(),'Health Tracker')]/parent::*//div[@class='arrow expanded']");
	  public By medicalCare_subMenus=By.xpath("//label[contains(text(),'Medical Care')]/parent::*//li");
	  public By medicalCare_expand_btn_open=By.xpath("//label[contains(text(),'Medical Care')]/parent::*//div[@class='arrow collapsed']");
	  public By medicalCare_expand_btn_close=By.xpath("//label[contains(text(),'Medical Care')]/parent::*//div[@class='arrow expanded']");
	  public By alerts_checkbox=By.xpath("//label[contains(text(),'Alerts')]");
	  public By healthTopic_checkbox=By.xpath("//label[contains(text(),'Health Topic')]");
	  public By myDocument_checkbox=By.xpath("//label[contains(text(),'My Document')]");
	  public By add_access_sharing_btn=By.id("assignAccess");
	  public By view_Info_access_sharing = By.id("idViewInfo");
	  public By add_more_access_sharing = By.id("idAddMore");
	  
			  
			  
	  
	  
	  
	  
	 

}
