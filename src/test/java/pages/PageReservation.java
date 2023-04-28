package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;


//Formulario de reserva de vuelo

public class PageReservation {
	private WebDriver driver;
	private By buttonContinue;
	private By passengersDrop;
	private By fromPort;
	private By arrivingIn;
	
	public PageReservation(WebDriver driver) {
		this.driver = driver;
		buttonContinue = By.name("findFlights");
		passengersDrop = By.name("passCount");
		fromPort = By.name("fromPort");
		arrivingIn = By.name("toPort");
	}

//Manejo de drop downs
	
	public void passengers(int cantidadPasajeros) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
		
		Select selectPasajeros = new Select(driver.findElement(passengersDrop));
		selectPasajeros.selectByVisibleText(Integer.toString(cantidadPasajeros));
				
	}
	
	public void departingFrom(String from) {
		Select selectPasajeros = new Select(driver.findElement(fromPort));
		selectPasajeros.selectByVisibleText((from));
		

		
	}
	
	public void arrivingIn(int index) {
		Select selectPasajeros = new Select(driver.findElement(arrivingIn));
		selectPasajeros.selectByIndex(index);

		
	}
		
	public void continueReservation() {
		
		driver.findElement(buttonContinue).click();

	}
}
