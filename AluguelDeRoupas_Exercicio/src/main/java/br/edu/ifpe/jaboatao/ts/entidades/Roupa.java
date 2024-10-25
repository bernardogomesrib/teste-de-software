package br.edu.ifpe.jaboatao.ts.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roupa {
	private String nome;
	private String tamanho;
	private Integer estoque;
	private Double valor; 
}