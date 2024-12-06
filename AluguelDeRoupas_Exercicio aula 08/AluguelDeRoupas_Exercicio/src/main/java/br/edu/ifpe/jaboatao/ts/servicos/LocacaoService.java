package br.edu.ifpe.jaboatao.ts.servicos;

import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoService {
	private boolean promocao;

	public boolean isPromocao() {
		return this.promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public Locacao alugarRoupa(Cliente cliente, List<Roupa> roupas) throws LocacaoException {

		if (roupas == null || roupas.isEmpty()) {
			throw new LocacaoException("Exceção: Roupas está nulo ou vázio.");
		}

		for (Roupa r : roupas) {
			if (r == null) {
				throw new LocacaoException("Exceção: Roupa nula.");
			}
			if (r.getValor() < 0) {
				throw new LocacaoException("Exceção: Verificar valor da roupa.");
			}
		}

		Locacao locacao = new Locacao();
		locacao.setRoupas(roupas);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());

		Double valorTotalLocacao = (double) 0;
		for (Roupa r : roupas) {
			valorTotalLocacao += r.getValor();
		}
		if(promocao) {
			int quantidade = roupas.size();
			if(quantidade >= 5) {
				valorTotalLocacao -= valorTotalLocacao * 0.5;
			}else if(quantidade == 4){
				valorTotalLocacao -= valorTotalLocacao * 0.25;
			}else if(quantidade == 3){
				valorTotalLocacao -= valorTotalLocacao * 0.15;
			}else if(quantidade == 2){
				valorTotalLocacao -= valorTotalLocacao * 0.10;
			}
		}
		locacao.setValorLocacao(valorTotalLocacao);

		// Definir a entrega para 3 dias depois.
		Date dataEntrega = ManipulandoDatas.novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}
}