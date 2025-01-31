package aula03;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Aula03 {
    WebDriver driver;
    boolean achou = false;
    @BeforeAll
    public void definirDriver() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void entrar() {
        driver.get("https://lattes.cnpq.br");
        System.out.println("Titulo da página: " + driver.getTitle());
        Wait<WebDriver> waitFluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        driver.switchTo().frame(0);
        waitFluent.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".lattes .busca_direito > a")))
                .click();
        ArrayList<String> abas = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(abas.get(1));
        waitFluent.until(ExpectedConditions.elementToBeClickable(By.id("textoBusca")))
                .sendKeys("Bernardo José Gomes Ribeiro");
        waitFluent.until(ExpectedConditions.elementToBeClickable(By.id("buscarDemais"))).click();
        waitFluent.until(ExpectedConditions.elementToBeClickable(By.id("botaoBuscaFiltros"))).click();
        waitFluent.until(ExpectedConditions.elementToBeClickable(By.linkText("Bernardo José Gomes Ribeiro"))).click();
        waitFluent.until(ExpectedConditions.elementToBeClickable(By.id("idbtnabrircurriculo"))).click();
        waitFluent.until(ExpectedConditions.numberOfWindowsToBe(3));
        
        
        driver.getWindowHandles().forEach((aba)->{
            if(achou) return;
            driver.switchTo().window(aba);
            if(driver.getTitle().contains("Currículo do Sistema de Currículos Lattes")) {
                achou = true;    
            }
                
            
        });

        if(driver.getTitle().contains("Currículo do Sistema de Currículos Lattes")) {
            System.out.println("Titulo da página: " + driver.getTitle());
            WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div[1]/ul/li[2]/span[2]"));
            assertEquals("3865101019636416", el.getText());            
        }
        assertTrue(achou);
    }

    @AfterAll
    public void fechar() {
        driver.quit();
    }
}
