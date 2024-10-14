package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test; // vem do @Test
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // vem do webDeiver driver
import org.openqa.selenium.chrome.ChromeDriver; // vem de new ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions; // vem do ChromeOptions

public class CompraTeste {

	WebDriver driver;
	ChromeOptions options = new ChromeOptions(); // é uma class do selinium para adicionar alguns argumentos como opçoes

	@Test
	public void comprarAtivo() { // modificador de acesso

		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get(
				"file:///C:/Users/DENISE%20TI/AppData/Local/Temp/423cf0c0-e21c-45d1-bf91-b44a79b8304f_hb.zip.04f/hb/hb.html");
		driver.findElement(By.id("asset")).sendKeys("AAPL");
		driver.findElement(By.id("price")).sendKeys("25.00");
		driver.findElement(By.id("quantity")).sendKeys("10"); // coloca a quantidade
		driver.findElement(By.id("buy-button")).click();

		String saldoAtualizado = driver.findElement(By.id("balance")).getText();
		String carteiraAtualizada = driver.findElement(By.id("portfolio")).getText();

		assertEquals(saldoAtualizado, "R$9750.00");
		assertEquals(carteiraAtualizada, "AAPL: 10");

		driver.quit();

	}

	@Test
	public void comprarPrecoErrado() { // modificador de acesso

		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get(
				"file:///C:/Users/DENISE%20TI/AppData/Local/Temp/423cf0c0-e21c-45d1-bf91-b44a79b8304f_hb.zip.04f/hb/hb.html");
		driver.findElement(By.id("asset")).sendKeys("AAPL");
		driver.findElement(By.id("price")).sendKeys("2.00");
		driver.findElement(By.id("quantity")).sendKeys("10"); // coloca a 2 reais quantidade
		driver.findElement(By.id("buy-button")).click();

		// driver.switchTo().alert().getText(); //capturar a msg

		// 1 desafio
		String erro = driver.switchTo().alert().getText();
		assertEquals(erro, "Dados inválidos.");

		driver.quit();
	}
}
