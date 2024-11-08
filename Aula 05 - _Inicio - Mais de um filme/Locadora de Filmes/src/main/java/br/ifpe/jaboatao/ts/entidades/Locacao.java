package br.ifpe.jaboatao.ts.entidades;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode
public class Locacao {

	private Usuario usuario;
	private List <Filme> filmes;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valorLocacao;

	
}