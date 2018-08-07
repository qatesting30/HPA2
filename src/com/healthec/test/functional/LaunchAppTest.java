package com.healthec.test.functional;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.healthec.project.spec.CreateDriver;

public class LaunchAppTest {
	
	public static RemoteWebDriver driver;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@Parameters({"platform","deviceType"})
	@Test
	public static RemoteWebDriver launchAppTest(String platform,String deviceType)
	{
		driver= CreateDriver.getDriver(platform,deviceType);
		log.info("App has launched");
		return driver;
	}

}
