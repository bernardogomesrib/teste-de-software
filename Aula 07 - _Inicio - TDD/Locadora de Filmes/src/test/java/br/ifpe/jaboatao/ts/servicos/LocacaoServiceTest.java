package br.ifpe.jaboatao.ts.servicos;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.LocacaoException;

public class LocacaoServiceTest {
//	private static int cont = 0;
	private LocacaoService service;
	
	@BeforeEach
	public void setup() {
		service = new LocacaoService();
//		cont++;
//		System.out.println(cont);
		//incrementar
		//imprimir na tela
	}
	
	@Test
	@DisplayName("Exception - Filme sem Estoque - Método try/catch")
	public void teste02() {
		// Cenário
//		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("João");
		List<Filme> filmes = Arrays.asList(new Filme("Titulo", 0, 10.0));

		// Ação
		try {
			@SuppressWarnings("unused")
			Locacao locacao = service.alugarFilme(usuario, filmes);
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
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 0, 22.0));

		// Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filmes);
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
		@SuppressWarnings("unused")
		List<Filme> filmes = Arrays.asList(new Filme("Filme 2", 20, 30.0));

		// Acao
		try {
			@SuppressWarnings("unused")
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
		List<Filme> filmes = null;
		//Acao
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filmes);
		}, "Filme deveria ser null.");
		//Verificacao
		Assertions.assertEquals("Filme nulo.", e.getMessage());
	}
	
	//Criar um teste com 3 filmes e verificar o valor da locação;
	@Test
	public void teste06() throws LocacaoException {
		//Cenário
		Usuario usuario = new Usuario("Maria");
		List<Filme> filmes = 
				Arrays.asList(
						new Filme("Título1", 1, 10.0), 
						new Filme("Título 2", 1, 10.0), 
						new Filme("Título 3", 1, 10.0));
		
		//Ação
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		//Verificação
		Assertions.assertEquals(30.0, locacao.getValorLocacao());
	}
	
	//Criar um teste com 2 filmes, sendo um deles nulo. Verificar o valor da locação.
	@Test
	public void teste07() throws LocacaoException {
		//Cenário
		Usuario usuario = new Usuario("Maria");
		List<Filme> filmes = Arrays.asList(new Filme("Título", 1, 10.0), null);
		
		//Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filmes);
		}, "Filme deveria ser null.");
		//Verificacao
		Assertions.assertEquals("Filme nulo.", e.getMessage());
	}


}
