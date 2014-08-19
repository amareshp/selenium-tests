package net.qatrend.test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
			Thread.sleep(10000);
			System.out.println("style: " + element.getAttribute("style"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
