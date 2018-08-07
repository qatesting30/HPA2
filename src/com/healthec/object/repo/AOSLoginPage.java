package com.healthec.object.repo;

import org.openqa.selenium.By;

public class AOSLoginPage {
	
	public By username_txt_field= By.id("userNameTxt");
	public By password_txt_field= By.id("passwordTxt");
	public By login_btn = By.id("loginBtn");
	public By loginErr = By.id("loginErr");
	public By passwordErr = By.id("passErr");
	public By spinner = By.xpath("//*[@id='spinner']/img");//By.xpath("//img[@src='assets/images/ajax-loader-1.gif']")
	public By invalid_credentials_popup  = By.id("idMsg");   
	public By invalid_credentials_popup_Ok  = By.id("idOk"); //By.xpath("//div[@id='idMsg']");
	public By login_In_Check  =  By.id("demo-page");
	public By contact_us = By.xpath("//android.view.View[@content-desc='Contact Us']");
	public By privacy_policy = By.xpath("//android.view.View[@content-desc='Privacy Policy']");
	public By terms_of_use = By.xpath("//android.view.View[@content-desc='Terms of Use']");
	public By signUp_link = By.id("idSignUp");
	

}
