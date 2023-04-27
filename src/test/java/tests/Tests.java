package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
		
	try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void tc01_iniciarSesion() {
		driver.findElement(By.partialLinkText("SIGN-ON")).click();	
		driver.findElement(By.name("userName")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.name("submit")).click();
	try {
		Thread.sleep(5000);
	} catch(InterruptedException e) {
		e.printStackTrace();
	}
	Assert.assertTrue(driver.findElement(By.xpath("//tbody//tr//td//h3")).getText().contains("Login Successfully"));
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