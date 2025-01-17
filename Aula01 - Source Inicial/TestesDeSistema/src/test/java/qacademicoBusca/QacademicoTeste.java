package qacademicoBusca;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class QacademicoTeste {
    @Test
    public void testarQacademico() throws InterruptedException {
        WebDriver edge = new EdgeDriver();
        QacademicoBuscaNota buscaNota = new QacademicoBuscaNota(edge);
        List<Double> notas = QacademicoBuscaNota.retornarNotasDeMateria(buscaNota, "Teste", "login", "senha");
        edge.quit();
        assertEquals(10, notas.get(0));

    }
}
