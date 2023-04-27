package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import helpers.Helpers;
import pages.PageHome;
import pages.PageLogin;
import pages.PageReservation;

public class Tests {
 
	String url = "https://demo.guru99.com/test/newtours/";
	private WebDriver driver;
	
	@BeforeSuite //rutina para abrir el navegador
	public void setUp() { //se suele llamar setUp()
		// 1) Configurando el navegador Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		// 2) Abrir el navegador en la página donde haremos la prueba
		driver.get(url);
//		3)  maximizar el navegador
		driver.manage().window().maximize();
		
		Helpers helper = new Helpers();
		helper.sleepSeconds(5);
	}
	
	@Test
	public void tc01_iniciarSesion() {

		PageHome home = new PageHome(driver);
		home.signOn();
		PageLogin user = new PageLogin(driver);
		user.login("user", "user");
		
//		Validacion de login correcto
		Assert.assertTrue(driver.findElement(By.xpath("//tbody//tr//td//h3")).getText().contains("Login Successfully"));
	}
	
	@Test
	public void tc02_reservarVuelo() {

		PageHome home = new PageHome(driver);
		home.signOn();
		PageLogin user = new PageLogin(driver);
		user.login("mercury", "mercury");
		home.flights();
		
		PageReservation reservation = new PageReservation(driver);
		reservation.continueReservation();
		
//		Validacion de login correcto
//		Assert.assertTrue(driver.findElement(By.xpath("//tbody//tr//td//h3")).getText().contains("Login Successfully"));
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
		
	}
}

//
//Access details to demo site.
//User ID :	mngr496247
//Password :	eraquze
//This access is valid only for 20 days.