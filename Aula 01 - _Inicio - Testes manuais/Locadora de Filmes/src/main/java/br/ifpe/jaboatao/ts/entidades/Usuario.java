package br.ifpe.jaboatao.ts.entidades;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Usuario {

	private String nome;
	
	public Usuario() {}
	
	public Usuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}