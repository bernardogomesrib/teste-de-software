package br.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.exceptions.LocacaoException;

public class CalculadoraTest {
    @Test
    @DisplayName("deve somar dois números")
    public void teste01() {
        // Arrange
        int a = 1;
        int b = 1;
        Calculadora calc = new Calculadora();
        // Act
        int resultado = calc.somar(a, b);
        // Assert
        Assertions.assertEquals(2, resultado);
    }

    @Test
    @DisplayName("deve subtrair dois números")
    public void teste02() {
        // Arrange
        int a = 1;
        int b = 1;
        Calculadora calc = new Calculadora();
        // Act
        int resultado = calc.subtrair(a, b);
        // Assert
        Assertions.assertEquals(0, resultado);
    }

    @Test
    @DisplayName("deve dividir dois números")
    public void teste03() {
        // Arrange
        int a = 1;
        int b = 1;
        Calculadora calc = new Calculadora();
        // Act
        try {
            double resultado = calc.dividir(a, b);
            // Assert
            Assertions.assertEquals(1, resultado);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    @DisplayName("deve lançar exceção ao dividir por zero")
    public void teste04() {
        // Arrange
        int a = 1;
        int b = 0;
        Calculadora calc = new Calculadora();
        // Act
        LocacaoException exception = Assertions.assertThrows(LocacaoException.class, () -> {
            calc.dividir(a, b);
        });
        // Assert
        Assertions.assertEquals("Divisão por zero", exception.getMessage());
    }

    @Test
    @DisplayName("deve subtrair vários números")
    public void teste05() {
        // Arrange
        int[] numeros = { 1, 1, 1 };
        Calculadora calc = new Calculadora();
        // Act
        int resultado = calc.subtrair(numeros);
        // Assert
        Assertions.assertEquals(-1, resultado);
    }

    @Test
    @DisplayName("deve subtrair vários números de forma diferente")
    public void teste06() {
        // Arrange
        int a = 1;
        int b = 1;
        int c = 1;
        Calculadora calc = new Calculadora();
        // Act
        int resultado = calc.subtrair(a, b, c);
        Assertions.assertEquals(-1, resultado);
    }

    @Test
    @DisplayName("deve subtrair vários números de forma diferente")
    public void teste07() {
        // Arrange
        int a = 420;
        Calculadora calc = new Calculadora();
        // Act
        int resultado = calc.subtrair(a);
        // Assert
        Assertions.assertEquals(420, resultado);
    }

    @Test
    @DisplayName("deve dividir vários números")
    public void teste08() throws LocacaoException {
        // Arrange
        int[] numeros = { 9, 3, 3 };
        Calculadora calc = new Calculadora();
        // Act
        double resultado = calc.dividir(numeros);
        // Assert
        Assertions.assertEquals(1, resultado);
    }

    @Test
    @DisplayName("deve lançar exceção ao dividir por zero")
    public void teste09() {
        // Arrange
        int[] numeros = { 1, 0, 1 };
        Calculadora calc = new Calculadora();
        // Act
        LocacaoException exception = Assertions.assertThrows(LocacaoException.class, () -> {
            calc.dividir(numeros);
        });
        // Assert
        Assertions.assertEquals("Divisão por zero", exception.getMessage());
    }

    @Test
    @DisplayName("deve somar vários números")
    public void teste10() {
        // Arrange
        int[] numeros = { 1, 1, 1 };
        Calculadora calc = new Calculadora();
        // Act
        int resultado = calc.somar(numeros);
        // Assert
        Assertions.assertEquals(3, resultado);
    }

    @Test
    @DisplayName("deve multiplicar vários números")
    public void teste11() {
        // Arrange
        int[] numeros = { 3, 3, 3, 3 };
        Calculadora calc = new Calculadora();
        // Act
        int resultado = calc.multiplicar(numeros);
        // Assert
        Assertions.assertEquals(81, resultado);
    }

    @Test
    @DisplayName("Deve multiplicar vários números de forma diferente")
    public void teste12() {
        // Arrange
        int a = 0;
        int b = 3;
        int c = 3;
        Calculadora calc = new Calculadora();
        // Act
        int resultado = calc.multiplicar(a, b, c);
        // Assert
        Assertions.assertEquals(0, resultado);
    }
}
