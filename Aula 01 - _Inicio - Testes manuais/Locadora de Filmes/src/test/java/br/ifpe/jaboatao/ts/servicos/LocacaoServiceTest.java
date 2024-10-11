package br.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoServiceTest {
    @Test
    void testTeste01() {
        //Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 01");
		Filme filme = new Filme("FIlme 01", 1, 10.0);
		//Ação
		Locacao locacao = service.alugarFilme(usuario, filme);
		//Resultado
		Assertions.assertTrue(DataUtils.boDatasIguais(locacao.getDataRetorno(), DataUtils.incrementarQntDias(1)));
		
		//valor do filme
		Assertions.assertTrue(locacao.getFilme().getValor() == 10.0);
		//valor da locação
		Assertions.assertTrue(locacao.getValorLocacao()==10.0);
		//nome do filme
		Assertions.assertTrue(locacao.getFilme().getTitulo()=="FIlme 01");
		//estoque do filme
		Assertions.assertTrue(locacao.getFilme().getEstoque()==1);
    }
}
