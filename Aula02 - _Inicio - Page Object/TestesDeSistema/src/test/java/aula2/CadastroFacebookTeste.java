package aula2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CadastroFacebookTeste {
    @Test
    public void teste01() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        CadastroFacebook cadastro = new CadastroFacebook(driver);
        cadastro.iniciarCadastro()
                .preencherNome("Fulano")
                .preencherSobrenome("de Tal")
                .preencherDataNascimento("1", "jan", "1990")
                .preencherGenero("Neutro", "Helicóptero Apache")
                .preencherEmail("fulanodetal@gememail.com")
                .preencherSenha("123")
                .cadastrar();
    }
   
}
