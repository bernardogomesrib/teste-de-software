package aula2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroFacebook {
    WebDriver driver;

    public CadastroFacebook(WebDriver driver) {
        this.driver = driver;
    }

    public CadastroFacebook iniciarCadastro() {
        driver.get("https://facebook.com");
        driver.findElement(By.linkText("Criar nova conta")).click();
        return this;
    }

    public CadastroFacebook preencherNome(String nome) {
        driver.findElement(By.name("firstname")).sendKeys(nome);
        return this;
    }

    public CadastroFacebook preencherSobrenome(String sobrenome) {
        driver.findElement(By.name("lastname")).sendKeys(sobrenome);
        return this;
    }

    public CadastroFacebook preencherDataNascimento(String dia, String mes, String ano) {
        driver.findElement(By.id("day")).click();
        driver.findElement(By.xpath(String.format("//option[contains(text(),'%s')]", dia))).click();
        driver.findElement(By.id("month")).click();
        driver.findElement(By.xpath(String.format("//option[contains(text(),'%s')]", mes))).click();
        driver.findElement(By.id("year")).click();
        driver.findElement(By.xpath(String.format("//option[contains(text(),'%s')]", ano))).click();
        return this;
    }

    /**
     * Preencher o gênero do usuário com ou homem ou mulher para selecionar o gênero normal
     * @param genero
     * @return
     */

    public CadastroFacebook preencherGenero(String genero) {
        if (genero.equals("homem") || genero.equals("male")) {
            driver.findElement(By.xpath("//span[2]/label")).click();
        }
        if (genero.equals("mulher") || genero.equals("female")) {
            driver.findElement(By.xpath("//span[1]/label")).click();
        }
        return this;
    }

    /**
     * Preencher o gênero do usuário com um gênero customizado a primeira variavel para a identificação ao receber emails ou notificar amigos de aniversario, só pra diferenciar.
     * @param comoSerIdentificado Feminino Masculino ou Neutro
     * @param customGender gênero customizado famozo helicoptero apache
     * @return
     */
    public CadastroFacebook preencherGenero(String comoSerIdentificado, String customGender) {
        if (customGender != null) {
            driver.findElement(By.xpath("//span[3]/label")).click();
            driver.findElement(By.id("preferred_pronoun")).click();
            driver.findElement(By.xpath(String.format("//option[contains(text(),'%s')]",comoSerIdentificado))).click();
            driver.findElement(By.id("custom_gender")).sendKeys(customGender);
        }
        return this;
    }

    public CadastroFacebook preencherEmail(String email) {
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        return this;
    }

    public CadastroFacebook preencherSenha(String senha) {
        driver.findElement(By.id("password_step_input")).sendKeys(senha);
        return this;
    }

    public void cadastrar() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.quit();
    }
}
