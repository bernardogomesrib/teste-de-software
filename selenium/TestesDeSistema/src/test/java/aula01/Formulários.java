package aula01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Formulários {
    private EdgeDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void preencherFormulário() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Criar nova conta')]")).click();
        driver.findElement(By.name("firstname")).sendKeys("João");
        driver.findElement(By.name("lastname")).sendKeys("Silva");
        driver.findElement(By.id("day")).click();
        driver.findElement(By.xpath("//option[contains(text(),'21')]")).click();
        driver.findElement(By.id("month")).click();
        driver.findElement(By.xpath("//option[contains(text(),'mar')]")).click();
        driver.findElement(By.id("year")).click();
        driver.findElement(By.xpath("//option[contains(text(),'1990')]")).click();
        driver.findElement(By.xpath("//span[3]/label")).click();
        driver.findElement(By.id("preferred_pronoun")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Neutro')]")).click();
        driver.findElement(By.id("custom_gender")).sendKeys("Maconheiro");
        driver.findElement(By.name("reg_email__")).sendKeys("joao.s");
        driver.findElement(By.id("password_step_input")).sendKeys("123456");
        driver.findElement(By.linkText("Cadastre-se")).click();
        Thread.sleep(3000);
        driver.navigate().to("https://www.google.com");
        assertEquals(1,1);
    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
