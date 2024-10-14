package desafio.homebroker.runner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import desafio.homebroker.drivers.DriversFactory;

public class Executa extends DriversFactory {

	
	ChromeOptions options = new ChromeOptions(); 
	
	public static void iniciarTeste() {
		ChromeOptions options = new ChromeOptions(); 

		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("file:///C:/Users/DENISE%20TI/AppData/Local/Temp/423cf0c0-e21c-45d1-bf91-b44a79b8304f_hb.zip.04f/hb/hb.html");
		
	}
	
	
	
}
