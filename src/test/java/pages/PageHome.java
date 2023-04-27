package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class PageHome {
	private WebDriver driver;
	private By signOn;
	private By flights;
	
	public PageHome(WebDriver driver) {
//		PageFactory.initElements(driver, this);
		this.driver = driver;
		signOn = By.partialLinkText("SIGN-ON");
		flights = By.linkText("Flights");
	}
	
	public void signOn() {
		
		driver.findElement(signOn).click();
		Helpers helper = new Helpers();
		helper.sleepSeconds(3);
	}
	
	public void flights() {
		driver.findElement(flights).click();
		Helpers helper = new Helpers();
		helper.sleepSeconds(3);		
	}
}
