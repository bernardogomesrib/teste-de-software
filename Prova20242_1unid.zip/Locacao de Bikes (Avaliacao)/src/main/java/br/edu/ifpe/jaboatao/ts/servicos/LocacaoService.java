package br.edu.ifpe.jaboatao.ts.servicos;

/* import static br.edu.ifpe.jaboatao.ts.utils.ManipularDatas.boDatasIguais;
import static br.edu.ifpe.jaboatao.ts.utils.ManipularDatas.novaDataComDiferencaDeDias; */

import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.exceptions.BicicletaExcepton;
import br.edu.ifpe.jaboatao.ts.utils.ManipularDatas;

public class LocacaoService {
	
	public Locacao alugarBicicleta(Cliente cliente, List<Bicicleta> bicicletas) throws BicicletaExcepton {

		if(bicicletas == null ) {
			throw new BicicletaExcepton("Exceção: Bicicleta nula.");
		}
		
		if(cliente == null) {
			throw new BicicletaExcepton("Exceção: Cliente nulo.");
		}
		for (Bicicleta bicicleta : bicicletas) {
			if(bicicleta == null) {
				throw new BicicletaExcepton("Exceção: Bicicleta nula.");
			}
			if(bicicleta.getValor() <= 5) {
				throw new BicicletaExcepton("Exceção: Verificar valor da bicicleta.");
			}
			if (bicicleta.getEstoque() == 0) {
				throw new BicicletaExcepton("Exceção: Bicicleta sem estoque.");
				
			}
		}

		Locacao locacao = new Locacao();
		locacao.setBicicletas(bicicletas);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(bicicletas.stream().mapToDouble(Bicicleta::getValor).sum());
		
		//Definir a entrega para 3 dias depois.
		Date dataEntrega = ManipularDatas.novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}

	public static void main(String[] args) {
		System.out.println("Funcionando.");

	}
}