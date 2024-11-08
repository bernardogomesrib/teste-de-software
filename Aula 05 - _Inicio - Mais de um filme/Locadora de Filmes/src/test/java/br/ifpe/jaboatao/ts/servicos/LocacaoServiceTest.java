package br.ifpe.jaboatao.ts.servicos;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoServiceTest {
	private static int cont = 0;
	private LocacaoService service;
	
	@Disabled
	@BeforeEach
	public void setup() {
		service = new LocacaoService();
		cont++;
		System.out.println(cont);
		//incrementar
		//imprimir na tela
	}
	
	@Test
	@DisplayName("Teste com sucesso!")
	public void teste01() throws LocacaoException {
		// Cenário
		Usuario usuario = new Usuario("Usuário 01");
		Filme filme = new Filme("Filme 01", 1, 10.0);

		// Ação
		Locacao locacao = service.alugarFilme(usuario, Arrays.asList(filme));

		// Verificacao

		// Nome do usuário
		Assertions.assertEquals("Usuário 01", locacao.getUsuario().getNome());

		// Data Locação
		Assertions.assertTrue(DataUtils.boDatasIguais(locacao.getDataLocacao(), new Date()));

		// Data Retorno
		Assertions.assertTrue(DataUtils.boDatasIguais(locacao.getDataRetorno(), DataUtils.incrementarQntDias(1)));

		// Valor do filme
		Assertions.assertTrue(locacao.getFilmes().stream().anyMatch(fil-> fil.getValor().equals(10.0)));

		// Valor da locação
		Assertions.assertTrue(locacao.getValorLocacao() == 10.0);

		// Nome do filme
		Assertions.assertTrue(locacao.getFilmes().stream().anyMatch(fil -> fil.getTitulo().equals("Filme 01")));

		// Estoque do filme.
		Assertions.assertTrue(locacao.getFilmes().stream().anyMatch(fil-> fil.getEstoque().equals(1)));

	}

	@Test
	@DisplayName("Exception - Filme sem Estoque - Método try/catch")
	public void teste02() {
		// Cenário
//		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("João");
		Filme filme = new Filme("Titulo", 0, 10.0);

		// Ação
		try {
			Locacao locacao = service.alugarFilme(usuario, Arrays.asList(filme));
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
//		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Pedro");
		Filme filme = new Filme("Filme 01", 0, 22.0);

		// Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, Arrays.asList(filme));
		}, "O estoque deveria ser zero.");
		// Verificação
		Assertions.assertEquals("Filme sem estoque.", e.getMessage());
	}

	@Test
	@DisplayName("Exception - Filme nulo - Método try/catch")
	public void teste04() {
		// Cenário
		LocacaoService service = new LocacaoService();
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
//		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario");
		List<Filme> filme = null;
		//Acao
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			this.service.alugarFilme(usuario,filme);
		}, "Filme deveria ser null.");
		//Verificacao
		Assertions.assertEquals("Filme nulo.", e.getMessage());
	}
	@Test
	@DisplayName("Teste com 3 filmes")
	public void teste06() throws LocacaoException {
		//Cenário
		Usuario usuario = new Usuario("Usuario 01");
		Filme filme1 = new Filme("Filme 01", 1, 10.0);
		Filme filme2 = new Filme("Filme 02", 1, 20.0);
		Filme filme3 = new Filme("Filme 03", 1, 30.0);
		//Acao
		Locacao locacao = service.alugarFilme(usuario, Arrays.asList(filme1,filme2,filme3));
		//Verificacao
		Assertions.assertTrue(locacao.getFilmes().stream().anyMatch(fil -> fil.getTitulo().equals("Filme 01")));
		Assertions.assertTrue(locacao.getFilmes().stream().anyMatch(fil -> fil.getTitulo().equals("Filme 02")));
		Assertions.assertTrue(locacao.getFilmes().stream().anyMatch(fil -> fil.getTitulo().equals("Filme 03")));
		Assertions.assertTrue(locacao.getValorLocacao() == 60.0);
	}
	@Test
	@DisplayName("Teste com um filme null")
	public void teste07() {
		//Cenario
		Usuario usuario = new Usuario("Usuario 01");
		Filme filme1 = new Filme("Filme 01", 1, 10.0);
		Filme filme2 = null;
		//Acao
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, Arrays.asList(filme1,filme2));
		}, "Filme deveria ser null.");
		//Verificacao
		Assertions.assertEquals("Filme nulo.", e.getMessage());
	}
}
