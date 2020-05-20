package com.selenium.SeleniumFunctions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumFunctions {

	WebDriver driver;
	Actions actions;

	public void invokebrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\SouthWest\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.get(url);
	}

	public void testcaseone() {
		invokebrowser("https://www.paytm.in");
		boolean element = driver.findElement(By.className("shPe")).isSelected();
		if (element == false) {
			System.out.println("Not checked");
		} else {
			System.out.println("checked");
		}
		terminate();
	}

	public void testcasetwo() {
		invokebrowser("https://redbus.in");
		WebElement Ele = driver.findElement(By.xpath("//body"));
		actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
		actions.keyDown(Ele, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).perform();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testcasethree() {
		String PageContent = driver.getPageSource();
		System.out.println("The Page content: " + PageContent);
		terminate();
	}

	public void testcasefour() {
		invokebrowser("https://www.facebook.com");
		String Title = driver.getTitle();
		System.out.println(Title);
		String secondline = driver.findElement(By.xpath("//div[contains(text(), 'helps you connect')]")).getText();
		System.out.println(secondline);
		String thirdline = driver.findElement(By.xpath("//div[contains(text(),'quick')]")).getText();
		System.out.println(thirdline);
		terminate();
	}

	public void terminate() {
		driver.quit();
	}

	public static void main(String[] args) {
		SeleniumFunctions obj = new SeleniumFunctions();
		obj.testcaseone();
		obj.testcasetwo();
		obj.testcasethree();
		obj.testcasefour();
		obj.terminate();
	}
}
