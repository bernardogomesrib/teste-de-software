package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;
import java.util.List;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {

	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws LocacaoException {

		if (usuario == null) {
			throw new LocacaoException("Usuario nulo.");
		}
		if (filmes == null) {
			throw new LocacaoException("Filme nulo.");
		}
		if (filmes.isEmpty()) {
			throw new LocacaoException("Filme nulo.");
		}

		for (Filme filme : filmes) {
			if(filme==null) {
				throw new LocacaoException("Filme nulo.");
			}
			if (filme.getEstoque().equals(0)) {
				throw new LocacaoException("Filme sem estoque.");
			}
		}

		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());

		locacao.setValorLocacao(filmes.stream().mapToDouble(Filme::getValor).sum());

		locacao.setDataRetorno(DataUtils.incrementarQntDias(1));

		return locacao;
	}

}