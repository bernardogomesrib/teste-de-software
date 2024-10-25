package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void teste01() {
		//Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuário 01");
		Filme filme = new Filme("Filme 01", 1, 10.0);
		
		//Ação
		Locacao locacao;
		try {
			locacao = service.alugarFilme(usuario, filme);
			
			//Verificacao
			
			//Nome do usuário
			Assertions.assertTrue(locacao.getUsuario().getNome() == "Usuário 01");
			
			//Data Locação
			Assertions.assertTrue(DataUtils.boDatasIguais(locacao.getDataLocacao(), new Date()));
			
			//Data Retorno
			Assertions.assertTrue(DataUtils.boDatasIguais(locacao.getDataRetorno(), DataUtils.incrementarQntDias(1)));
			
			
			//Valor do filme
			Assertions.assertTrue(locacao.getFilme().getValor() == 10.0);
			
			//Valor da locação
			Assertions.assertTrue(locacao.getValorLocacao() == 10.0);
			
			//Nome do filme
			Assertions.assertTrue(locacao.getFilme().getTitulo() == "Filme 01");
			
			//Estoque do filme.
			Assertions.assertTrue(locacao.getFilme().getEstoque() == 1);
			
		} catch (LocacaoException e) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("Exception - filme sem estoque - método try/catch")
	public void teste02(){
		//cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Jão");
		Filme filme = new Filme("Filme 01", 0, 10.0);

		//ação

		try {
			@SuppressWarnings("unused")
			Locacao locacao = service.alugarFilme(usuario, filme);
			Assertions.fail("Deveria ter lançado uma exceção");
		} catch (LocacaoException e) {
			//verificação
			Assertions.assertTrue(e.getMessage().equals("Filme sem estoque"));
		}
		

	}
	@Test
	@DisplayName("Exception - filme sem estoque - método assertThrows")
	public void teste03(){
		//cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Jão");
		Filme filme = new Filme("Filme 01", 0, 10.0);

		//ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filme);
		},"O estoque deveria ser zero");
		Assertions.assertTrue(e.getMessage().equals("Filme sem estoque"));
	}

	@Test
	@DisplayName("Exception sem filme - método try/catch")
	public void teste04(){
		//cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Jão");
		Filme filme = null;
		//ação
		try {
			@SuppressWarnings("unused")
			Locacao locacao = service.alugarFilme(usuario, filme);
			Assertions.fail("Deveria ter lançado uma exceção");
		} catch (LocacaoException e) {
			//verificação
			Assertions.assertTrue(e.getMessage().equals("Filme vazio"));
		}
	}


	@Test
	@DisplayName("Exception - filme nulo - método assertThrows")
	public void teste05(){
		//cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Jão");
		Filme filme = null;
		//ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () -> {
			service.alugarFilme(usuario, filme);
		},"O filme deveria ser nulo");

		//verificação
		Assertions.assertTrue(e.getMessage().equals("Filme vazio"), "A mensagem deveria ser Filme vazio");
	}

}
