package br.edu.ifpe.jaboatao.ts.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Bicicleta {
	private String nome;
	private Integer estoque;
	private Double valor;
//	private String modelo;
}
