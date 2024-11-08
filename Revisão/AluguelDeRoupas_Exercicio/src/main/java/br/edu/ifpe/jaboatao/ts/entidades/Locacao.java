package br.edu.ifpe.jaboatao.ts.entidades;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Locacao {
	private Cliente cliente;
	private List<Roupa> roupa;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valorLocacao;
}