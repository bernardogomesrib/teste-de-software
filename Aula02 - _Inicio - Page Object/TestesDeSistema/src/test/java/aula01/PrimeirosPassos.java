package aula01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PrimeirosPassos {
	EdgeDriver driver;
	@BeforeEach
	public void preCondicao() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	@Test
	@Disabled
	public void test01() {
		driver.get("https://www.google.com.br");
		System.out.println(driver.getTitle());
		Assertions.assertEquals("Google", driver.getTitle());
	}
	@Test
	public void interagindoComElementos() throws InterruptedException {
		driver.get("http://www.google.com.br");
		WebElement campoPesquisa = driver.findElement(By.name("q"));
		campoPesquisa.sendKeys("ifrn");
		campoPesquisa.submit();
		//Na pagina de resultados do google.
		//Dar um clique no primeiro link que contenha o termo ifpb.
		driver.findElement(By.partialLinkText("ifrn")).click();
		//No site do ifrn
		//Clicar no banner
		driver.findElement(By.linkText("Campi")).click();
//		Thread.sleep(7000);
		driver.findElement(By.linkText("Caicó")).click();
		driver.findElement(By.linkText("Cursos")).click();
		Assertions.assertEquals("Cursos", driver.findElement(By.className("titulo")).getText());
	}
	@AfterEach
	public void posCondicao() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
