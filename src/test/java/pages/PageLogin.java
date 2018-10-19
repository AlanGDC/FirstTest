package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import methods.Methods;

public class PageLogin {
	private WebDriver driver;
	public PageLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String user, String pass) {
		driver.findElement(By.name("loginfmt")).sendKeys(user);
		driver.findElement(By.id("idSIButton9")).click();
		Methods Method = new Methods();
		Method.sleepSeconds(5);
		driver.findElement(By.name("passwd")).sendKeys(pass);
		driver.findElement(By.id("idSIButton9")).click();;
		Method.sleepSeconds(5);
	}

}
