package aula02;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroFacebookPage {

	WebDriver driver;
	
	public CadastroFacebookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CadastroFacebookPage iniciarCadastro() {
		driver.findElement(By.linkText("Criar nova conta")).click();
		return this;
	}
	
	public CadastroFacebookPage preencherPrimeiroNome(String nome) {
		driver.findElement(By.name("firstname")).sendKeys(nome);
		return this;
	}
	public CadastroFacebookPage preencherSobrenome(String sobrenome) {
		//driver.findElement(By.name("lastname")).sendKeys(sobrenome);
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lastname = waitExplicit.until(ExpectedConditions
                .elementToBeClickable(By.name("lastname")));
        lastname.sendKeys("Sobrenome");
		return this;
	}
	public CadastroFacebookPage preencherDataNascimento_Dia(String dia) {
		WebElement comboDia = driver.findElement(By.id("day"));
		Select selectDia = new Select(comboDia);
		selectDia.selectByValue(dia);
		return this;
	}
	/**
	 * Informe o mês com as iniciais do mes. Ex: jan, fev, mar...
	 * @param mes
	 * @return
	 */
	public CadastroFacebookPage preencherDataNascimento_Mes(String mes) {
		driver.findElement(By.id("month")).sendKeys(mes);
		return this;
	}
	public CadastroFacebookPage preencherDataNascimento_Ano(String ano) {
		driver.findElement(By.id("year")).sendKeys(ano);
		return this;
	}
	/**
	 * Informe: 
	 * 		Feminino:  1
	 * 		Masculino: 2
	 * @param genero
	 * @return
	 */
	public CadastroFacebookPage preencherGenero(String genero) {
		List<WebElement> radios = driver.findElements(By.id("sex"));
		for (WebElement radio: radios) {
			if (radio.getAttribute("value").equals(genero)) {
				radio.click();
			}
		}
		return this;
	}
	public CadastroFacebookPage preencherEmail(String email) {
		//driver.findElement(By.name("reg_email__")).sendKeys(email);
        Wait<WebDriver> waitFluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement campoEmail = waitFluent.until(ExpectedConditions
                .elementToBeClickable(By.name("reg_email__")));
        campoEmail.sendKeys(email);
		return this;
	}
	public CadastroFacebookPage preencherSenha(String senha) {
		driver.findElement(By.id("password_step_input")).sendKeys(senha);
		return this;
	}
	public void enviarCadastro() {
		driver.findElement(By.linkText("Cadastre-se")).click();
	}
}
