package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;
import java.util.List;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {
	private boolean promocao;
	public LocacaoService(boolean promocao ){
		this.promocao = promocao;
	}
	public LocacaoService(){
		this.promocao=false;
	}
	public boolean isPromocao(){
		return this.promocao;
	}
	public void setPromocao(boolean promocao){
		this.promocao = promocao;
	}
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws LocacaoException {
		if (filmes == null || filmes.isEmpty()) {
			throw new LocacaoException("Filme nulo.");
		}
		for (Filme filme: filmes) {
			if (filme == null) {
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
		double valorTotal = 0;
		for (int i = 0; i < filmes.size(); i++) {
			Filme filme = filmes.get(i);
			if(promocao){
				if(i==2){
					valorTotal += filme.getValor()*0.75;
				}else if(i==3){
					valorTotal += filme.getValor()*0.5;
				}else if(i==4){
					valorTotal += filme.getValor()*0.25;
				}else if(i==5){
					valorTotal += filme.getValor()*0;
				}
				else{
					valorTotal += filme.getValor();
				}
			}else{
				valorTotal += filme.getValor();
			}
			// Adicione sua lógica aqui usando o índice 'i'
		}
//		locacao.setValorLocacao(filme.getValor());
		locacao.setValorLocacao(valorTotal);

		//Entrega no dia seguinte
//		Date dataEntrega = new Date();
//		dataEntrega = DataUtils.incrementarQntDias(1);
		locacao.setDataRetorno(DataUtils.incrementarQntDias(1));
		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.
		
		return locacao;
	}
	
}