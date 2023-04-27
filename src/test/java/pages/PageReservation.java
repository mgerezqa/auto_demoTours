package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class PageReservation {
	private WebDriver driver;
	private By buttonContinue;
	public PageReservation(WebDriver driver) {
//		PageFactory.initElements(driver, this);
		this.driver = driver;
		buttonContinue = By.name("findFlights");
	}
	
	public void continueReservation() {
		
		driver.findElement(buttonContinue).click();
		Helpers helper = new Helpers();
		helper.sleepSeconds(3);
	}
}
