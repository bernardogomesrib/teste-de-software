package br.edu.ifpe.jaboatao.ts.servicos;

//br.edu.ifpe.jaboata.ts.servicos
import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.exceptions.ProjetoException;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoService {

	public Locacao alugarRoupa(Cliente cliente, List<Roupa> roupa) throws ProjetoException {
		if(cliente == null) {
			throw new ProjetoException("Cliente não pode ser nulo.");
		}
		if(roupa == null) {
			throw new ProjetoException("Exceção: Roupa nula.");
		}
		if(roupa.isEmpty()) {
			throw new ProjetoException("Exceção: Roupa nula.");
		}
		for (Roupa roupa2 : roupa) {

			if(roupa2 == null) {
				throw new ProjetoException("Exceção: Roupa nula.");
			}

			if(roupa2.getValor() == null||roupa2.getValor() == 0||roupa2.getValor() < 0) {
				throw new ProjetoException("Exceção: Verificar valor da roupa.");
			}
			if(roupa2.getEstoque() == null||roupa2.getEstoque() == 0) {
				throw new ProjetoException("Estoque da roupa não pode ser nulo.");
			}
		}


		Locacao locacao = new Locacao();
		locacao.setRoupa(roupa);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(roupa.stream().mapToDouble(Roupa::getValor).sum());

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