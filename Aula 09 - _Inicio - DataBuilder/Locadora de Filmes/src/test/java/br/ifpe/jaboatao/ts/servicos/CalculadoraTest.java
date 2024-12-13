package br.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.exceptions.LocacaoException;

public class CalculadoraTest {

	@Test
	@DisplayName("Deve somar dois números.")
	public void teste01() {
		//Cenário
		int a = 4;
		int b = 3;
		Calculadora calc = new Calculadora();
		
		//Acao
		int resultado = calc.somar(a,b);
		
		//Verificacao
		Assertions.assertEquals(7, resultado);
	}
	@Test
	@DisplayName("Deve subtrair dois números")
	public void teste02() {
		//Cenário
		int a = 3;
		int b = 2;
		Calculadora calc = new Calculadora();
		
		//Ação
		int resultado = calc.subtrair(a,b);
		
		//Subtração
		Assertions.assertEquals(1, resultado);
	}
	@Test
	@DisplayName("Deve dividir dois números.")
	public void teste03() throws LocacaoException {
		//Cenário
		int a = 6;
		int b = 3;
		Calculadora calc = new Calculadora();
		
		//Acao
		double resultado = calc.dividir(a,b);
		
		//Verificacao
		Assertions.assertEquals(2, resultado);
	}
	@Test
	@DisplayName("Exception: Divisão por zero")
	public void teste04() {
		//Cenário
		int a = 6;
		int b = 0;
		Calculadora calc = new Calculadora();
		
		//Ação
		LocacaoException exception = Assertions.assertThrows(LocacaoException.class, () ->{
			calc.dividir(a, b);
		},"Deveria chamar uma exception.");
		
		//Verificação
		Assertions.assertEquals("Exception: Divisão por zero.", exception.getMessage());
	}
}
