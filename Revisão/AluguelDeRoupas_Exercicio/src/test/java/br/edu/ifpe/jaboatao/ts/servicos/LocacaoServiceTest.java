package br.edu.ifpe.jaboatao.ts.servicos;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.exceptions.ProjetoException;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;

public class LocacaoServiceTest {

    private static LocacaoService service;
    private static Cliente cliente;
    private static Roupa roupanull;
    private static Roupa roupa;
    private static Roupa roupa2;
    private static Roupa roupa3;
    private static Roupa roupa4;
    private static Roupa roupa5;
    private static Roupa roupa6;
    
    @BeforeAll
    public static void setUp() {
        service = new LocacaoService();
        cliente = new Cliente("João");
        roupa = new Roupa("Camisa","M",10,10.0);
        roupa2 = new Roupa("Calça","M",10,20.0);
        roupa3 = new Roupa("meia","M",10,20.0);
        roupa4 = new Roupa("paleto","M",10,20.0);
        roupa5 = new Roupa("cinto","M",10,20.0);
        roupa6 = new Roupa("cinto","M",10,-20.0);
        roupanull = null;
    }


    @Test
    @DisplayName("a. Crie um teste com 5 roupas e teste se o valor da locação está sendo calculado corretamente. ")
    public void testAlugarRoupa() throws ProjetoException {
        Locacao locacao = service.alugarRoupa(cliente, Arrays.asList(roupa,roupa2,roupa3,roupa4,roupa5));
        Assertions.assertEquals(90.0, locacao.getValorLocacao());
    }

    @Test
    @DisplayName("b. Crie um teste com 3 roupas onde uma roupa será nula (apenas uma) e teste se a exceção \"Exceção: Roupa nula.\" vai ser acionada. Utilize o assertThrow para isso.")
    public void testAlugarRoupa1() {
        ProjetoException exception  = Assertions.assertThrows(ProjetoException.class, () -> service.alugarRoupa(cliente, Arrays.asList(roupa,roupa2,roupanull)));
        Assertions.assertEquals("Exceção: Roupa nula.", exception.getMessage());
    }
    
    @Test
    @DisplayName("c. Crie um teste passando o objeto roupas nulo e verifique se a exceção \"Exceção: Roupa nula.\" vai ser acionada. Crie dois métodos de teste, um utilizando o try/catch e outro a assertiva assertThrow, que deverão fazer a verificação.")
    public void testAlugarRoupa3() {
        try {
            service.alugarRoupa(cliente, null);
            Assertions.fail("Deveria ter lançado uma exceção.");
        } catch (ProjetoException e) {
            Assertions.assertEquals("Exceção: Roupa nula.", e.getMessage());
        }
    }
    @Test
    @DisplayName("c. Crie um teste passando o objeto roupas nulo e verifique se a exceção \"Exceção: Roupa nula.\" vai ser acionada. Crie dois métodos de teste, um utilizando o try/catch e outro a assertiva assertThrow, que deverão fazer a verificação.")
    public void testAlugarRoupa4() {
        ProjetoException exception  = Assertions.assertThrows(ProjetoException.class, () -> service.alugarRoupa(cliente, null));
        Assertions.assertEquals("Exceção: Roupa nula.", exception.getMessage());
    }
    @Test
    @DisplayName("d. Teste se a exceção \"Exceção: Verificar valor da roupa.\" vai ser acionada. Crie dois métodos de teste, um utilizando o try/catch e outro a assertiva assertThrow, que deverão fazer a verificação.")
    public void testAlugarRoupa5() {
        try {
            service.alugarRoupa(cliente, Arrays.asList(roupa,roupa2,roupa3,roupa4,roupa6));
            Assertions.fail("Deveria ter lançado uma exceção.");
        } catch (ProjetoException e) {
            Assertions.assertEquals("Exceção: Verificar valor da roupa.", e.getMessage());
        }
    }
    @Test
    @DisplayName("d. Teste se a exceção \"Exceção: Verificar valor da roupa.\" vai ser acionada. Crie dois métodos de teste, um utilizando o try/catch e outro a assertiva assertThrow, que deverão fazer a verificação.")
    public void testAlugarRoupa6() {
        ProjetoException exception  = Assertions.assertThrows(ProjetoException.class, () -> service.alugarRoupa(cliente, Arrays.asList(roupa,roupa2,roupa3,roupa4,roupa6)));
        Assertions.assertEquals("Exceção: Verificar valor da roupa.", exception.getMessage());
    }
}
