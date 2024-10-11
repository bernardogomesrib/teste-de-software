package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(filme.getValor());

		//Entrega no dia seguinte
		//Date dataEntrega = new Date();
		//dataEntrega = DataUtils.incrementarQntDias(1, dataEntrega);
		locacao.setDataRetorno(DataUtils.incrementarQntDias(1));
		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.
		
		return locacao;
	}

	public static void main(String[] args) {
		//System.out.println("Funcionando.");
		//Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 01");
		Filme filme = new Filme("FIlme 01", 1, 10.0);
		//Ação
		Locacao locacao = service.alugarFilme(usuario, filme);
		//Resultado
		System.out.println("data locação: "+DataUtils.boDatasIguais(locacao.getDataLocacao(), new Date())+"\nUsuário: "+locacao.getUsuario().getNome().equals("Usuario 01")+"\nData de devolução: "+DataUtils.boDatasIguais(locacao.getDataRetorno(),DataUtils.incrementarQntDias(1)));
		
		//valor do filme
		System.out.println("valor do filme: "+(locacao.getFilme().getValor() == 10.0));
		//valor da locação
		System.out.println("Valor da locação: "+(locacao.getValorLocacao()==10.0));
		//nome do filme
		System.out.println("Nome do filme: "+(locacao.getFilme().getTitulo()=="FIlme 01"));
		//estoque do filme
		System.out.println("Estoque do filme: "+(locacao.getFilme().getEstoque()==1));
		
		
		
		
	}
}