package aula02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginFacebookPageTest {
	WebDriver driver;
	LoginFacebookPage facebook;
	@BeforeEach
	public void preCodicoes() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com.br");
		facebook = new LoginFacebookPage(driver);
	}
	@Test
	public void deveLogarComSucesso() {
		//Enviar usuario e senha corretos;
		facebook.logarcomo("Maria", "123");
	}
	@Test
	public void naodeveLogarSemSenha() {
		//Enviar senha em branco.
		facebook.logarcomo("Maria", "");
	}
	public void tentarLogarComSenhaErrada() {
		//Enviar senha errada.
		facebook.logarcomo("Maria", "qwe");
	}
	
	@AfterEach
	public void posCodicoes() {
		driver.quit();
	}
}
