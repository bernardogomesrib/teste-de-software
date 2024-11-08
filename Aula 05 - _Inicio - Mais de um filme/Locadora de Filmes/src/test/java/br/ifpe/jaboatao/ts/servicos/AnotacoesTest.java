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
	public static void antesDeTodos() {
		System.out.println("Antes de todos os testes");
	}
	@BeforeEach
	public void antesDoTeste() {
		System.out.println("Antes do teste");
	}
	@Test
	@DisplayName("1")
	@Order(1)
	public void teste01() {
		System.out.println("Teste 01");
	}
	@Test
	@DisplayName("3")
	@Disabled
	public void teste02() {
		System.out.println("Teste 02");
	}
	@Test
	@DisplayName("2")
	@Order(2)
	public void teste03() {
		System.out.println("Teste 03");
	}
	@AfterEach
	public void depoisDoTeste() {
		System.out.println("Depois do teste");
		System.out.println("----------------");
	}
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Depois de todos os testes");
	}
}
