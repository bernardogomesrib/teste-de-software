package aula2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class LoginFacebookTeste {
     @Test
    public void login() throws InterruptedException{
        EdgeOptions options = new EdgeOptions();
        options.addArguments("headless");
        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        LoginFacebook login = new LoginFacebook(driver);
        login.iniciar()
                .preencherEmail("maconhasafada")
                .preencherSenha("123")
                .logar();
        driver.quit();
    }
    @Test
    public void loginInvalido() throws InterruptedException{
        EdgeOptions options = new EdgeOptions();
        options.addArguments("headless");
        WebDriver driver = new EdgeDriver(options);
        LoginFacebook login = new LoginFacebook(driver);
        login.iniciar()
                .preencherEmail("maconhasafada")
                .preencherSenha("")
                .logar();
        driver.quit();
    }
}
