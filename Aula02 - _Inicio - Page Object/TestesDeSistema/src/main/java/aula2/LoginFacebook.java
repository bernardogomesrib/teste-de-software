package aula2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFacebook {
    WebDriver driver;
    public LoginFacebook(WebDriver driver) {
        this.driver = driver;
    }
    public LoginFacebook iniciar(){
        driver.get("https://facebook.com");
        return this;
    }
    public LoginFacebook preencherEmail(String email){
        driver.findElement(By.id("email")).sendKeys(email);
        return this;
    }
    public LoginFacebook preencherSenha(String senha){
        driver.findElement(By.id("pass")).sendKeys(senha);
        return this;
    }
    public void logar() throws InterruptedException{
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
    }
}
