package br.edu.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;

public class LocacaoServiceTest {
    Roupa roupa = new Roupa("Camisa", "M", 10, 69.0);
    Cliente cliente = new Cliente("João");
    Cliente cliente2 = new Cliente("Maria");

    LocacaoService locacaoService = new LocacaoService();
    Locacao locacao = locacaoService.alugarRoupa(cliente, roupa);

    @Test
    void teste1(){
        Assertions.assertFalse(cliente.equals(cliente2));
        Assertions.assertTrue(roupa.getEstoque().equals(10));
    }
    @Test
    void teste2() {
        Assertions.assertEquals(locacao.getCliente(), cliente);
        Assertions.assertEquals(locacao.getRoupa(), roupa);
        Assertions.assertEquals(locacao.getValorLocacao(),6.0);
    }
    @Test
    void teste3(){
        assert cliente.getNome().equalsIgnoreCase("joão");
        assert roupa.getNome().equalsIgnoreCase("camisa");
        assert roupa.getTamanho().equalsIgnoreCase("M");
    }

}
