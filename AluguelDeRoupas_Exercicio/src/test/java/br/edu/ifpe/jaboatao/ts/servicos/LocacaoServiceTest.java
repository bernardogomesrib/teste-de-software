package br.edu.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

// package declaration should be at the top

public class LocacaoServiceTest {

    private LocacaoService locacaoService;

    @BeforeEach
    public void setUp() {
        locacaoService = new LocacaoService();
    }

    @Test
    @DisplayName("Questão 6.a Testando um aluguel de roupa normal")
    public void testAlugarRoupa() {
        // Arrange
        Cliente cliente = new Cliente();
        Roupa roupa = new Roupa("roupa 1", "M", 12, 12.9);
        

        // Act
        Locacao locacao;
        try {
            locacao = locacaoService.alugarRoupa(cliente, roupa);
            Date expectedReturnDate = ManipulandoDatas.novaDataComDiferencaDeDias(3, locacao.getDataLocacao());

            // Assert
            Assertions.assertNotNull(locacao);
            Assertions.assertEquals(cliente, locacao.getCliente());
            Assertions.assertEquals(roupa, locacao.getRoupa());
            Assertions.assertNotNull(locacao.getDataLocacao());
            Assertions.assertEquals(12.9, locacao.getValorLocacao(), 0.01);

            
            Assertions.assertTrue(ManipulandoDatas.boDatasIguais(expectedReturnDate, locacao.getDataRetorno()));
        } catch (LocacaoException e) {
            e.printStackTrace();
        }
    }
    @Test
    @DisplayName("Questão 6.b Deve lançar uma exceção ao tentar alugar uma roupa sem cliente - metodo AssertThrows")
    public void testAlugarRoupaSemCliente() {
        // Arrange
        Cliente cliente = null;
        Roupa roupa = new Roupa("roupa 1", "M", 12, 12.9);
        

        // Act
        LocacaoException exception = Assertions.assertThrows(LocacaoException.class, () -> {
            @SuppressWarnings("unused")
            Locacao locacao = locacaoService.alugarRoupa(cliente, roupa);
        });

        // Assert
        Assertions.assertEquals("Exceção:Usuário nulo.", exception.getMessage());
    }
    @Test
    @DisplayName("Questão 6.b Deve lançar uma exceção ao tentar alugar uma roupa sem cliente - metodo TryCatch")
    public void testAlugarRoupaSemClienteTryCatch() {
        // Arrange
        Cliente cliente = null;
        Roupa roupa = new Roupa("roupa 1", "M", 12, 12.9);
        

        // Act
        @SuppressWarnings("unused")
        Locacao locacao = null;
        try {
            locacao = locacaoService.alugarRoupa(cliente, roupa);
        } catch (LocacaoException e) {
            // Assert
            Assertions.assertEquals("Exceção:Usuário nulo.", e.getMessage());
        }

    }

    @Test
    @DisplayName("Deve lançar uma exceção ao tentar alugar uma roupa sem roupa - metodo AssertThrows")
    public void testAlugarRoupaSemRoupa() {
        // Arrange
        Cliente cliente = new Cliente();
        Roupa roupa = null;

        // Act
        LocacaoException exception = Assertions.assertThrows(LocacaoException.class, () -> {
            @SuppressWarnings("unused")
            Locacao locacao = locacaoService.alugarRoupa(cliente, roupa);
        },"Era para ter lançado uma exceção");

        // Assert
        Assertions.assertEquals("Roupa vazia", exception.getMessage());
    }
    @Test
    @DisplayName("Deve lançar uma exceção ao tentar alugar uma roupa sem estoque - metodo AssertThrows")
    public void testAlugarRoupaSemEstoque() {
        // Arrange
        Cliente cliente = new Cliente();
        Roupa roupa = new Roupa("roupa 1", "M", 0, 12.9);
        

        // Act
        LocacaoException exception = Assertions.assertThrows(LocacaoException.class, () -> {
            @SuppressWarnings("unused")
            Locacao locacao = locacaoService.alugarRoupa(cliente, roupa);
        }, "Era para ter lançado uma exceção");

        // Assert
        Assertions.assertEquals("Roupa sem estoque", exception.getMessage());
    }


    @Disabled
    @Test
    @DisplayName("Deve lançar uma exceção ao tentar alugar uma roupa com valor menor que 10 - metodo AssertThrows")
    public void testAlugarRoupaComValorMenorQue10() {
        // Arrange
        Cliente cliente = new Cliente();
        Roupa roupa = new Roupa("roupa 1", "M", 12, 9.9);
        roupa.setValor(9.9);

        // Act
        LocacaoException exception = Assertions.assertThrows(LocacaoException.class, () -> {
            @SuppressWarnings("unused")
            Locacao locacao = locacaoService.alugarRoupa(cliente, roupa);
        }, "Era para ter lançado uma exceção");

        // Assert
        Assertions.assertEquals("Verificar o valor da roupa", exception.getMessage());
    }
}