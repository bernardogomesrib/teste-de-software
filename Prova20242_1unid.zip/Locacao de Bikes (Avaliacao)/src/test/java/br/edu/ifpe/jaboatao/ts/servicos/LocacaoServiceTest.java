package br.edu.ifpe.jaboatao.ts.servicos;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.exceptions.BicicletaExcepton;

public class LocacaoServiceTest {
    private LocacaoService locacaoService;
    private Bicicleta bicicleta;
    private Bicicleta bicicleta2;
    private Bicicleta bicicleta3;
    private Bicicleta bicicleta4;
    private Bicicleta bicicleta5;
    private Cliente cliente;
    private List<Bicicleta> bicicletas;
    
    @BeforeEach
    public void setUp() {

        this.locacaoService = new LocacaoService();
        this.bicicleta = new Bicicleta("Caloi", 10, 10.0);
        this.bicicleta2 = new Bicicleta("Monark", 10, 40.0);
        this.bicicleta3 = new Bicicleta("Trek", 10, 30.0);
        this.bicicleta4 = new Bicicleta("Scott", 10, 20.0);
        this.bicicleta5 = null;
        this.bicicletas = Arrays.asList(bicicleta, bicicleta2, bicicleta3, bicicleta4);
        this.cliente = new Cliente("João");

    }

    @Test
    @DisplayName("Questão 4.a - Valor da locação com 4 bicicletas")
    public void testAlugarBicicleta() {
        
        try {
            var locacao = locacaoService.alugarBicicleta(cliente, bicicletas);
            Assertions.assertEquals(100.0, locacao.getValorLocacao());

        } catch (Exception e) {
            Assertions.fail(e);
        }
    }
    
    @Test
    @DisplayName("Questão 4.b - Bicicleta null com assert throw")
    public void testAlugarBicicletaBicicletaNull() {

        Exception exception = Assertions.assertThrows(BicicletaExcepton.class, () -> {
            locacaoService.alugarBicicleta(cliente, Arrays.asList(bicicleta, bicicleta2, bicicleta3, bicicleta4, bicicleta5));
        },"Deveria ter lançado uma exceção");
        Assertions.assertEquals("Exceção: Bicicleta nula.", exception.getMessage());
    }

    @Test
    @DisplayName("Questão 4.c - Bicicleta null com try catch")
    public void testAlugarBicicletaClienteNull() {

        try {
            bicicletas = Arrays.asList(bicicleta, bicicleta2, bicicleta3, bicicleta4, bicicleta5);
            locacaoService.alugarBicicleta(cliente, bicicletas);
            Assertions.fail("Deveria ter lançado uma exceção");
        } catch (BicicletaExcepton e) {
            Assertions.assertEquals("Exceção: Bicicleta nula.", e.getMessage());
        } catch (Exception e) {
            Assertions.fail(e);
        }
      
    }

    @Test
    @DisplayName("Questão 4.d - Bicicleta com valor menor que 5 com assert throw")
    public void testAlugarBicicletaBicicletaValorMenorQue5() {

        bicicleta.setValor(4.0);
        Exception exception = Assertions.assertThrows(BicicletaExcepton.class, () -> {
            locacaoService.alugarBicicleta(cliente, bicicletas);
        });
        Assertions.assertEquals("Exceção: Verificar valor da bicicleta.", exception.getMessage());
    }

    @Test
    @DisplayName("Questão 4.d - Bicicleta com valor menor que 5 com try catch")
    public void testAlugarBicicletaBicicletaValorMenorQue5TryCatch() {

        bicicleta.setValor(4.0);
        try {
            locacaoService.alugarBicicleta(cliente, bicicletas);
            Assertions.fail("Deveria ter lançado uma exceção");
        } catch (BicicletaExcepton e) {
            Assertions.assertEquals("Exceção: Verificar valor da bicicleta.", e.getMessage());
        } catch (Exception e) {
            Assertions.fail(e);
        }
        
    }
}
