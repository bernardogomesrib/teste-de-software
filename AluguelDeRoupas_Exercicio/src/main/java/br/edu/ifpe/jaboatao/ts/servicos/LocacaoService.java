package br.edu.ifpe.jaboatao.ts.servicos;

//br.edu.ifpe.jaboata.ts.servicos
import java.util.Date;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoService {

	public Locacao alugarRoupa(Cliente cliente, Roupa roupa) throws LocacaoException {
		if(cliente == null) {
			throw new LocacaoException("Exceção:Usuário nulo.");
		}
		if(roupa == null) {
			throw new LocacaoException("Roupa vazia");
		}
		if(roupa.getEstoque() == 0) {
			throw new LocacaoException("Roupa sem estoque");
		}
		if(roupa.getValor()<10) {
			throw new LocacaoException("Verificar o valor da roupa");
		}
		Locacao locacao = new Locacao();
		locacao.setRoupa(roupa);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(roupa.getValor());

		// Definir a entrega para 3 dias depois.
		Date dataEntrega = ManipulandoDatas.novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}

	public static void main(String[] args) {
		System.out.println("Funcionando.");
	}
}