package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoServiceTest {
	private LocacaoService service;
	private static int contador = 0;
	@BeforeEach
	public void setup() {
		this.service = new LocacaoService();
		contador++;
		System.out.println(contador);
	}
	@Test
	@DisplayName("Teste com sucesso!")
	public void teste01() throws LocacaoException {
		// Cenário
		//LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuário 01");
		Filme filme = new Filme("Filme 01", 1, 10.0);

		// Ação
		Locacao locacao = service.alugarFilme(usuario, filme);

		// Verificacao

		// Nome do usuário
		Assertions.assertTrue(locacao.getUsuario().getNome() == "Usuário 01");

		// Data Locação
		Assertions.assertTrue(DataUtils.boDatasIguais(locacao.getDataLocacao(), new Date()));

		// Data Retorno
		Assertions.assertTrue(DataUtils.boDatasIguais(locacao.getDataRetorno(), DataUtils.incrementarQntDias(1)));

		// Valor do filme
		Assertions.assertTrue(locacao.getFilme().getValor() == 10.0);

		// Valor da locação
		Assertions.assertTrue(locacao.getValorLocacao() == 10.0);

		// Nome do filme
		Assertions.assertTrue(locacao.getFilme().getTitulo() == "Filme 01");

		// Estoque do filme.
		Assertions.assertTrue(locacao.getFilme().getEstoque() == 1);

	}

	@Test
	@DisplayName("Exception - Filme sem Estoque - Método try/catch")
	public void teste02() {
		// Cenário
		//LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("João");
		Filme filme = new Filme("Titulo", 0, 10.0);

		// Ação
		try {
			Locacao locacao = service.alugarFilme(usuario, filme);
			Assertions.fail("O estoque deveria ser zero.");
		} catch (LocacaoException e) {
			// Verificação
			Assertions.assertEquals("Filme sem estoque.", e.getMessage());
		}
	}

	@Test
	@DisplayName("Exception - Filme sem Estoque - Método assertThrow()")
	public void teste03() {
		// Cenário
		//LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Pedro");
		Filme filme = new Filme("Filme 01", 0, 22.0);

		// Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filme);
		}, "O estoque deveria ser zero.");
		// Verificação
		Assertions.assertEquals("Filme sem estoque.", e.getMessage());
	}

	@Test
	@DisplayName("Exception - Filme nulo - Método try/catch")
	public void teste04() {
		// Cenário
		//LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Maria");
		Filme filme = new Filme("Filme 2", 20, 30.0);

		// Acao
		try {
			Locacao locacao = service.alugarFilme(usuario, null);
			Assertions.fail("O filme deveria ser null.");
		} catch (LocacaoException e) {
			// Verificacao
			Assertions.assertEquals("Filme nulo.", e.getMessage());
		}
	}
	@Test
	@DisplayName("Exception - Filme nulo - Meétodo assertThrow()")
	public void teste05() {
		//Cenário
		//LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario");
		Filme filme = null;
		//Acao
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filme);
		}, "Filme deveria ser null.");
		//Verificacao
		Assertions.assertEquals("Filme nulo.", e.getMessage());
	}
}
