package qacademicoBusca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QacademicoBuscaNota {
    WebDriver driver;
    public QacademicoBuscaNota(WebDriver driver) {
        this.driver = driver;
    }
    public QacademicoBuscaNota iniciaBusca() {
        driver.get("https://qacademico.ifpe.edu.br/qacademico/index.asp?t=1001");
        return this;
    }
    public QacademicoBuscaNota preencherLogin(String login) {
        driver.findElement(By.id("txtLogin")).sendKeys(login);
        return this;
    }
    public QacademicoBuscaNota preencherSenha(String senha) {
        driver.findElement(By.id("txtSenha")).sendKeys(senha);
        return this;
    }
    public QacademicoBuscaNota clicarBotaoEntrar() throws InterruptedException {
        driver.findElement(By.id("btnOk")).click();
        Thread.sleep(3000);
        return this;
    }

    public QacademicoBuscaNota entrarNasNotas() {
        driver.findElement(By.linkText("Boletim")).click();
        return this;
    }
    public QacademicoBuscaNota buscarNotaDeTeste(String materia) {
        WebElement tabela = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table[4]/tbody"));
        List<WebElement> linhas = tabela.findElements(By.tagName("tr"));
        Collections.reverse(linhas);
        for (WebElement webElement : linhas) {
            if(webElement.getText().contains(materia)){
                List<String> notas = List.of(webElement.getText().split(" "));
                for (String nota : notas) {
                    if(nota.matches(".*[0-9].*")){
                        try {
                            Double n = Double.parseDouble(nota.replace(",", "."));
                            if(n<20){
                                System.out.println(n);
                            }
                        } catch (Exception e) {
                            continue;
                        }
                    }
                }
                break;
            }else{
                continue;
            }
            
        }
        return this;
    }
    public static List<Double> retornarNotasDeMateria(QacademicoBuscaNota navegador,String materia,String login,String senha) throws InterruptedException{
        List<Double> notas = new ArrayList<>();
        navegador.iniciaBusca()
        .preencherLogin(login)
        .preencherSenha(senha)
        .clicarBotaoEntrar()
        .entrarNasNotas();
        WebDriver driver = navegador.driver;
        WebElement tabela = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/table[4]/tbody"));
        List<WebElement> linhas = tabela.findElements(By.tagName("tr"));
        Collections.reverse(linhas);
        for (WebElement webElement : linhas) {
            if(webElement.getText().contains(materia)){
                List<WebElement> nts = webElement.findElements(By.tagName("td"));
                for (int i = 5; i < nts.size(); i+=2) {
                    String nota = nts.get(i).getText();
                    if(nota.matches(".*[0-9].*")){
                        try {
                            Double n = Double.parseDouble(nota.replace(",", "."));
                            /* notas.add("nota:"+ n+"como "+mapValue(i)+"ª nota"); */
                            notas.add(n);
                        } catch (Exception e) {
                            continue;
                        }
                    }
                }
                break;
            }else{
                continue;
            }
            
        }
        


        return notas;
    }
    public static int mapValue(int input) {
        return (input - 3) / 2;
    }
}
