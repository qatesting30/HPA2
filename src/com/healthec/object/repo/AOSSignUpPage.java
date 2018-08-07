package com.healthec.object.repo;

import org.openqa.selenium.By;

public class AOSSignUpPage {
	
	//Screen1
	public By signUp_link = By.id("idSignUp");
	public By firstname_txt_field = By.id("firstName");
	public By lastname_txt_field = By.id("lastName");
	public By gender =  By.id("gender");
	public By dob =  By.id("dob");
	public By dob_year = By.className("ui-datepicker-year");
	public By dob_month = By.className("ui-datepicker-month");
	public By dob_day = By.xpath("//table[@class='ui-datepicker-calendar']//td");
	public By datePicker_Ok = By.id("datePickerOk");
	public By datePicker_cancel = By.id("datePickerCancel");
	public By email = By.id("email");	
	public By security_qns_1 =  By.id("securityQuestion1");
	public By security_qns_2 =  By.id("securityQuestion2");
	public By security_qns_3 =  By.id("securityQuestion3");
	public By security_qns_4 =  By.id("securityQuestion4");
	public By security_ans_1 =  By.id("answer1");
	public By security_ans_2 =  By.id("answer2");
	public By security_ans_3 =  By.id("answer3");
	public By security_ans_4 =  By.id("answer4");
	public By step1_next_btn = By.id("stepOneNext");
	//Screen2
	public By username = By.id("userName");
	public By password = By.id("password");
	public By confirm_password = By.id("confirmPassword");
	public By previous_btn =  By.id("stepTwoPrevious");
	public By Next_btn =  By.id("stepTwoNext");
	
	
	
			
			
	
	
	

}
