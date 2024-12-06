package br.ifpe.jaboatao.ts.servicos;

import br.ifpe.jaboatao.ts.exceptions.LocacaoException;

public class Calculadora {

	public int somar(int a, int b) {
		return a + b;
	}

	public int subtrair(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	public double dividir(int a, int b) throws LocacaoException {
		if (b == 0) {
			throw new LocacaoException("Exception: Divisão por zero.");
		}
		return a/b;
	}

}
