package com.healthec.UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.healthec.object.repo.AOSLoginPage;

public class LoginPage {
	
	AOSLoginPage aos ;
	String instance;
	RemoteWebDriver driver;
	
	public LoginPage(RemoteWebDriver driver)
	{
		this.driver = driver;
		instance = driver.getClass().getName();
		aos = new AOSLoginPage();
	}
	
	public WebElement userName_txtField()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.username_txt_field);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement password_txtField()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.password_txt_field);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement login_Btn()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.login_btn);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement sign_Up_link()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.signUp_link);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement login_Error_msg1()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.loginErr);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement login_Error_msg2()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.passwordErr);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement spinner()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.spinner);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement invalid_credentials_popup()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.invalid_credentials_popup);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement invalid_credentials_popup_Ok_btn()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.invalid_credentials_popup_Ok);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement login_check()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.login_In_Check);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement contact_us_link()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.contact_us);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement privacy_policy_link()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.privacy_policy);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
	public WebElement terms_of_use_link()
	{
		if (instance.contains("AndroidDriver"))
			return driver.findElement(aos.terms_of_use);
		else if (instance.contains("IOSDriver"))
			System.out.println("Not yet Implemented");
		return null;
		}
}
