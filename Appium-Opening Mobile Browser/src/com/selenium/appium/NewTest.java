package com.selenium.appium;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

public class NewTest {
	private AppiumDriver driver;
	public static String baseurl;

	@BeforeClass()
	public void init() throws MalformedURLException {
		// app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browser", "Chrome");
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName", "SM-G900H");
		capabilities.setCapability("VERSION", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void googleTest() throws InterruptedException {

		baseurl = "www.google.com";
		driver.get(baseurl + "/");

	}
}
