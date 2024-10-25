package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void teste01() {
		//Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuário 01");
		Filme filme = new Filme("Filme 01", 1, 10.0);
		
		//Ação
		Locacao locacao = service.alugarFilme(usuario, filme);
		
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

	}
}
