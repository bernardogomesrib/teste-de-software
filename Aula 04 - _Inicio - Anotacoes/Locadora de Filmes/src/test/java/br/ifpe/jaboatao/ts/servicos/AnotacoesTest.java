package br.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnotacoesTest {
    @BeforeAll
    public static void antesDeTodosOsTestes(){
        System.out.println("Antes de todos os testes");
    }
    @BeforeEach
    public void antesDeCadaTeste(){
        System.out.println("Antes de cada teste");
    }
    @Test
    @Order(1)
    public void teste01(){
        System.out.println("Teste 01");

    }
    @Test
    @DisplayName("numero 1")
    public void teste02(){
        System.out.println("Teste 02");

    }
    @Disabled
    @Test
    public void teste03(){
        System.out.println("Teste 03");

    }
    @AfterEach
    public void depoisDeCadaTeste(){
        System.out.println("Depois de cada teste");
        System.out.println("----------------------------");
    }
    @AfterAll
    public static void depoisDeTodosOsTestes(){
        System.out.println("Depois de todos os testes");
    }
}
