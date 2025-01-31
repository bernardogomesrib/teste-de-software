package aula01;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Formularios {
	EdgeDriver driver; 
	@BeforeEach
	public void preCodicao() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
//	@SuppressWarnings("deprecation")
	@Test
	public void facebook() {
		//Acessar o site e clicar no botão Criar nova conta.
		driver.get("https://facebook.com");
		driver.findElement(By.linkText("Criar nova conta")).click();
		//No formulário
		//Informar o nome
		driver.findElement(By.name("firstname")).sendKeys("Nome");
		//Informar o sobrenome
		driver.findElement(By.name("lastname")).sendKeys("Sobrenome");
		
		//Preencher a data de nascimento
		//Dia
		WebElement comboDia = driver.findElement(By.id("day"));
		Select selectDia = new Select(comboDia);
		selectDia.selectByIndex(1);
		
		//Mês
		driver.findElement(By.id("month")).sendKeys("Fev");
		
		//Ano
		driver.findElement(By.id("year")).sendKeys("2000");
		
		//Gênero
		List<WebElement> radios = driver.findElements(By.id("sex"));
		for (WebElement radio: radios) {
			if (radio.getAttribute("value").equals("2")) {
				radio.click();
			}
		}
		
		//Email
		driver.findElement(By.name("reg_email__")).sendKeys("a@b.com");
		
		//Senha
		driver.findElement(By.id("password_step_input")).sendKeys("123");
		
		//Clicar no botão Cadastrar...
		driver.findElement(By.linkText("Cadastre-se")).click();
	}
	@AfterEach
	public void posCondicao() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
