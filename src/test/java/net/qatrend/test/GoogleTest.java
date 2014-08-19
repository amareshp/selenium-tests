package net.qatrend.test;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest {

	@Test
	public void testSearch() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		WebElement element = driver.findElement(By.ByCssSelector
				.cssSelector("input[name='q']"));
		System.out.println("style: " + element.getAttribute("style"));
		try {
			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		driver.quit();
	}

	@Test
	public void sauceLabsTest() {
		try {
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setCapability("platform", "Windows 7");
			caps.setCapability("version", "30");			
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://"
					+ System.getenv("SAUCE_USER") + ":"
					+ System.getenv("SAUCE_PASS")
					+ "@ondemand.saucelabs.com:80/wd/hub"), caps);
			driver.get("http://google.com");
			WebElement element = driver.findElement(By.ByCssSelector
					.cssSelector("input[name='q']"));
			Thread.sleep(3000);
			//check that my name appears on the first page when I search for visitamaresh
			element.sendKeys("visitamaresh.com");
			element.submit();
			Assert.assertTrue(driver.getPageSource().contains("Amaresh Pattanaik"));
			File tempScreenshot = driver.getScreenshotAs(OutputType.FILE);
			System.out.println("location of screenshot file: " + tempScreenshot.getPath());
			
			File screenshot = new File("test-output/amaresh.png");
			FileUtils.deleteQuietly(screenshot);
			FileUtils.moveFile(tempScreenshot, screenshot);
			Thread.sleep(3000);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
