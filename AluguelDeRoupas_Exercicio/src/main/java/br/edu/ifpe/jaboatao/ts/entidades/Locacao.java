package br.edu.ifpe.jaboatao.ts.entidades;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locacao {

	private Cliente cliente;
	private Roupa roupa;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valorLocacao;
}