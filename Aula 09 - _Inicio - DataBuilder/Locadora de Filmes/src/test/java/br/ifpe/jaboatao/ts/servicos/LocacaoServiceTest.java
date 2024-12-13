package br.ifpe.jaboatao.ts.servicos;

import static br.ifpe.jaboatao.ts.servicos.builders.UsuarioBuilder.*;

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
import br.ifpe.jaboatao.ts.servicos.builders.FilmeBuilder;

@SuppressWarnings("unused")
public class LocacaoServiceTest {
	// private static int cont = 0;
	private LocacaoService service;

	@BeforeEach
	public void setup() {
		service = new LocacaoService();
		// cont++;
		// System.out.println(cont);
		// incrementar
		// imprimir na tela
	}

	@Test
	@DisplayName("Exception - Filme sem Estoque - Método try/catch")
	public void teste02() {
		// Cenário
		// LocacaoService service = new LocacaoService();
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(
			FilmeBuilder.umFilme()
			.comTitulo("Titulo")
			.comEstoque(0)
			.comValor(10.0)
			.agora()
			/* new Filme("Titulo", 0, 10.0) */);

		// Ação
		try {
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
		// LocacaoService service = new LocacaoService();
		//Usuario usuario = new Usuario("Pedro");
		Usuario usuario =  umUsuario().comNome("ana").agora();
		List<Filme> filmes = Arrays.asList(
			FilmeBuilder.umFilme().comTitulo("Filme 01").comEstoque(0).comValor(22.0).agora()
			/* new Filme("Filme 01", 0, 22.0) */);

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
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(
			FilmeBuilder.umFilme().comTitulo("Filme 2").comEstoque(20).comValor(30.0).agora()
			/* ,new Filme("Filme 2", 20, 30.0) */);

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
		// Cenário
		// LocacaoService service = new LocacaoService();
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = null;
		// Acao
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filmes);
		}, "Filme deveria ser null.");
		// Verificacao
		Assertions.assertEquals("Filme nulo.", e.getMessage());
	}

	// Criar um teste com 3 filmes e verificar o valor da locação;
	@Test
	public void teste06() throws LocacaoException {
		// Cenário
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(
				FilmeBuilder.umFilme().comTitulo("Filme 1").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Filme 2").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Filme 3").comEstoque(1).comValor(10.0).agora()
				/* new Filme("Título1", 1, 10.0),
				new Filme("Título 2", 1, 10.0),
				new Filme("Título 3", 1, 10.0) */);

		// Ação
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// Verificação
		Assertions.assertEquals(30.0, locacao.getValorLocacao());
	}

	// Criar um teste com 2 filmes, sendo um deles nulo. Verificar o valor da
	// locação.
	@Test
	@DisplayName("sei lá")
	public void teste07() throws LocacaoException {
		// Cenário
		Usuario usuario = umUsuario().comNome("Maria").agora();
		List<Filme> filmes = Arrays.asList(new Filme("Título", 1, 10.0), null);

		// Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filmes);
		}, "Filme deveria ser null.");
		// Verificacao
		Assertions.assertEquals("Filme nulo.", e.getMessage());
	}


	@Test
	@DisplayName("!Deve dar desconto de 25% ao 3º filme")
	public void teste08() throws LocacaoException {
		// Cenário
		service.setPromocao(true);
		Usuario usuario = umUsuario().comNome("Maria").agora();
		List<Filme> filmes = Arrays.asList(
			FilmeBuilder.umFilme().comTitulo("Titulo").comEstoque(1).comValor(10.0).agora(),
			FilmeBuilder.umFilme().comTitulo("Titulo2").comEstoque(1).comValor(10.0).agora(),
			FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora()
				/* new Filme("Título", 1, 10.0),
				new Filme("Título2", 1, 10.0),
				new Filme("Título3", 1, 10.0) */);

		// Ação
		Locacao locacao = service.alugarFilme(usuario, filmes);
		// Verificacao
		// 10+10+7.5
		Assertions.assertEquals(27.5, locacao.getValorLocacao());
	}
	@Test
	@DisplayName("Deve dar desconto de 50% ao 4º filme")
	public void teste09() throws LocacaoException {

		service.setPromocao(true);
		Usuario usuario = umUsuario().comNome("Maria").agora();
		List<Filme> filmes = Arrays.asList(
			FilmeBuilder.umFilme().comTitulo("Titulo").comEstoque(1).comValor(10.0).agora(),
			FilmeBuilder.umFilme().comTitulo("Titulo2").comEstoque(1).comValor(10.0).agora(),
			FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
			FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora()
			/* new Filme("Título", 1, 10.0),
			new Filme("Título2", 1, 10.0),
			new Filme("Título2", 1, 10.0),
			new Filme("Título3", 1, 10.0) */);
		
		// Ação
		Locacao locacao = service.alugarFilme(usuario, filmes);
		// Verificacao
		// 10+10+7.5+5
		Assertions.assertEquals(32.5, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Deve dar desconto de 75% ao 5º filme")
	public void teste10() throws LocacaoException {

		service.setPromocao(true);
		Usuario usuario = umUsuario().comNome("Maria").agora();
		List<Filme> filmes = Arrays.asList(
				FilmeBuilder.umFilme().comTitulo("Titulo").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo2").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora()
				/* new Filme("Título", 1, 10.0),
				new Filme("Título2", 1, 10.0),
				new Filme("Título3", 1, 10.0),
				new Filme("Título3", 1, 10.0),
				new Filme("Título3", 1, 10.0) */
				);

		// Ação
		Locacao locacao = service.alugarFilme(usuario, filmes);
		// Verificacao
		// 10+10+7.5+5+2.5
		Assertions.assertEquals(35, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Deve dar desconto de 100% ao 6º filme")
	public void teste11() throws LocacaoException {

		service.setPromocao(true);
		Usuario usuario = umUsuario().comNome("Maria").agora();
		List<Filme> filmes = Arrays.asList(
				FilmeBuilder.umFilme().comTitulo("Titulo").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo2").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora()
				/*
				new Filme("Título", 1, 10.0),
				new Filme("Título2", 1, 10.0),
				new Filme("Título3", 1, 10.0),
				new Filme("Título3", 1, 10.0),
				new Filme("Título3", 1, 10.0),
				new Filme("Título3", 1, 10.0)
				*/
				);

		// Ação
		Locacao locacao = service.alugarFilme(usuario, filmes);
		// Verificacao
		// 10+10+7.5+5+2.5+0
		Assertions.assertEquals(35, locacao.getValorLocacao());
	}
	@Test
	@DisplayName("Deve dar desconto de 0% ao 7º filme")
	public void teste12() throws LocacaoException {

		service.setPromocao(true);
		Usuario usuario = umUsuario().comNome("Maria").agora();
		List<Filme> filmes = Arrays.asList(
				FilmeBuilder.umFilme().comTitulo("Titulo").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo2").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora(),
				FilmeBuilder.umFilme().comTitulo("Titulo3").comEstoque(1).comValor(10.0).agora()
				/* 
				new Filme("Título", 1, 10.0),
				new Filme("Título2", 1, 10.0),
				new Filme("Título3", 1, 10.0),
				new Filme("Título3", 1, 10.0),
				new Filme("Título3", 1, 10.0),
				new Filme("Título3", 1, 10.0),
				new Filme("Título3", 1, 10.0) */);

		// Ação
		Locacao locacao = service.alugarFilme(usuario, filmes);
		// Verificacao
		// 10+10+7.5+5+2.5+0+10
		Assertions.assertEquals(45, locacao.getValorLocacao());
	}
}
