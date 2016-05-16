package Test.selenium;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTest {
	WebDriver driver;

	@Test
	public  void f() throws InterruptedException {

		driver = new FirefoxDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("demo123");
		driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
		Thread.sleep(7000);

		WebElement element = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/ul[2]/li/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.partialLinkText("http://demosite.center/wordpress/wp-login.php?action=logout&_wpnonce=cb60b46ff0")).getText();
				
	}

}
