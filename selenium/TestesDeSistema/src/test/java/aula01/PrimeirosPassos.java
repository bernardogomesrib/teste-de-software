package aula01;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PrimeirosPassos {
    EdgeDriver driver;

    @BeforeEach
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void teste01(){
        EdgeDriver driver = new EdgeDriver();
        //driver.navigate().to("https://www.google.com");
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Google", driver.getTitle());
        driver.quit();
    }
    @Test
    public void teste02(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://portal.ifpe.edu.br/jaboatao/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle());
        Assertions.assertEquals("403 Forbidden", driver.getTitle());
        Assertions.assertEquals(true,driver.getPageSource().contains("403 Forbidden"));
        driver.quit();
    }
    @Test
    public void teste03(){
        driver.get("https://portal.ifpe.edu.br/jaboatao/");
        System.out.println(driver.getTitle());
        Assertions.assertFalse("IFPE - Instituto Federal de Educação, Ciência e Tecnologia de Pernambuco".equals(driver.getTitle()));
        WebElement element = driver.findElement(By.xpath("//h1[contains(.,'403 Forbidden')]"));
        Assertions.assertTrue(element.isDisplayed());
        driver.quit();
    }
    @AfterEach
    public void fechar() throws InterruptedException{
        Thread.sleep(30000);
        driver.quit();
    }
    @Test
    public void teste04(){
        driver.get("https://portal.ifpe.edu.br/jaboatao/");
        driver.navigate().to("https://www.google.com");
        WebElement element = driver.findElement(By.xpath("//textarea"));
        element.sendKeys("IFPE");
        element.submit();
        element = driver.findElement(By.xpath("//textarea"));
        element.clear();
        element.sendKeys("como fazer metanfetamina");
        element.submit();

        System.out.println(driver.getTitle());
    }
    @Test
    public void teste05(){
        assertThrows(WebDriverException.class, ()->{
            driver.get("https://qacademico.ifpe.edu.br/");
        },"ERR_ADDRESS_UNREACHABLE");
        
    }
}
