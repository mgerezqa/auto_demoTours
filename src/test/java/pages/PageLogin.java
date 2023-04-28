package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

//import helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	private By userField;
	private By passwordField;
	private By loginButton;
	
	public PageLogin(WebDriver driver) {
//		PageFactory.initElements(driver, this);
		this.driver = driver;
		userField = By.name("userName");
		passwordField = By.name("password");
		loginButton = By.name("submit");

		
	}
	
	public void login(String user, String pass) {
		
		driver.findElement(userField).sendKeys(user); //deberia ir en otro pag
		driver.findElement(passwordField).sendKeys(pass);//deberia ir en otro pag
		driver.findElement(loginButton).click(); //deberia ir en otro pag
		
//		Helpers helper = new Helpers();
//		helper.sleepSeconds(3);
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
}
