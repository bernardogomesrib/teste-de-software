package aula02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFacebookPage {

	WebDriver driver;
	
	public LoginFacebookPage(WebDriver driver) {
		this.driver = driver;
	}
	public LoginFacebookPage preencherUsuario(String usuario) {
		driver.findElement(By.name("email")).sendKeys(usuario);
		return this;
	}
	public LoginFacebookPage preencherSenha(String senha) {
		driver.findElement(By.name("pass")).sendKeys(senha);
		return this;
	}
	public void entrar() {
		driver.findElement(By.name("login")).click();
	}
	public void logarcomo(String usuario, String senha) {
		preencherUsuario(usuario).preencherSenha(senha);//.entrar();
	}
	
}
