package com.selenium.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterTest;

import io.appium.java_client.android.AndroidDriver;

public class ScreenShotTest {
	private AndroidDriver driver;
	private String destDir;
	private DateFormat dateFormat;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "4.4.2");
		capabilities.setCapability("deviceName", "SAMSUNG-SGH-L337");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.onemobility.android.agent");
		capabilities.setCapability("appActivity", "com.onemobility.android.agent.ui.Splash");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void ScreenShot() {
		takeScreenShot();
	}
	// commit to 2june branch

	public void takeScreenShot() {

		driver.findElementById("com.onemobility.android.agent:id/enrollment_ok");

		// Set folder name to store screenshots.
		destDir = "screenshots";

		// Capture screenshot.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Set date format to set It as screenshot file name.
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

		// Create folder under project with name "screenshots" provided to destDir.
		new File(destDir).mkdirs();

		// Set file name using current date time.
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void End() {
		driver.quit();
	}

}