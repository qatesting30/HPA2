package com.healthec.UI;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.healthec.object.repo.AOSSignUpPage;

public class SignUpPage {
	
       RemoteWebDriver driver;
	   String instance;
	   AOSSignUpPage aos;
	
	public SignUpPage(RemoteWebDriver driver)
	{
		this.driver = driver;
		instance =  driver.getClass().getName();
		aos = new AOSSignUpPage();
	}
	public WebElement signUp_link()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.signUp_link);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement firstName_textField()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.firstname_txt_field);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement lastName_textField()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.lastname_txt_field);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement gender()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.gender);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement gender_Male()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.gender);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement gender_Female()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.gender);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement gender_Unknown()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.gender);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	
	public WebElement dob()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.dob);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement dob_year()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.dob_year);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement dob_month()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.dob_month);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public List<WebElement> dob_AllDates()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElements(aos.dob_day);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement datePicker_ok_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.datePicker_Ok);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement datePicker_cancel_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.datePicker_cancel);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement email()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.email);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement security_question_1()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.security_qns_1);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement security_question_2()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.security_qns_2);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement security_question_3()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.security_qns_3);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement security_question_4()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.security_qns_4);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement security_answer_1()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.security_ans_1);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement security_answer_2()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.security_ans_2);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement security_answer_3()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.security_ans_3);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement security_answer_4()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.security_ans_4);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement step_1_next_btn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.step1_next_btn);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement enter_userName()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.username);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement enter_password()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.password);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement enter_confirmPassword()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.confirm_password);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement perviousBtn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.previous_btn);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	public WebElement nextBtn()
	{
		if(instance.contains("AndroidDriver"))
			return driver.findElement(aos.Next_btn);
		else if(instance.contains("IOSDriver"))
			System.out.println("Not Yet Implemented");
		return null;
	}
	

}
