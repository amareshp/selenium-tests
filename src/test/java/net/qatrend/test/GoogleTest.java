package net.qatrend.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GoogleTest {

	@Test
	public void testSearch() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		WebElement element = driver.findElement(By.ByCssSelector.cssSelector("input[name='q']"));
		System.out.println("style: " + element.getAttribute("style"));
		try {
			Thread.sleep(5000);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		driver.quit();
	}
}
