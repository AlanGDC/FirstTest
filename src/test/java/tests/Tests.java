package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import methods.Methods;
import pages.PageLogin;

import org.testng.annotations.AfterMethod;

public class Tests {
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://login.live.com/login.srf");
		Methods Method = new Methods();
		Method.sleepSeconds(5);
	}
	@Test
	public void loginFail() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.login("andresmilanesi@hotmail.com", "123456");
		Assert.assertTrue(driver.findElement(By.id("passwordError")).getText().contains("Your account or password is incorrect"));
	}
	@Test
	public void loginPass() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.login("andresmilanesi@hotmail.com", "Mefisto666");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"loaded-home-banner-profile-section\"]/div[2]/h1")).getText().contains("ANDRES"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
