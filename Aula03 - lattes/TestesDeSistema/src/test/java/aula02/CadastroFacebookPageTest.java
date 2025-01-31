package aula02;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CadastroFacebookPageTest {

	@Test
	public void teste01() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		//Espera implicita - Aplicada em todo a página.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com.br");
		CadastroFacebookPage facebook = new CadastroFacebookPage(driver);
		facebook.iniciarCadastro()
					.preencherPrimeiroNome("Ana")
					.preencherSobrenome("Silva")
					.preencherDataNascimento_Dia("4")
					.preencherDataNascimento_Mes("mar")
					.preencherDataNascimento_Ano("2000")
					.preencherGenero("1")
					.preencherEmail("asd@gmail.com")
					.preencherSenha("123");
					//.enviarCadastro();
	
		Thread.sleep(3000);
		driver.quit();
	}
}
