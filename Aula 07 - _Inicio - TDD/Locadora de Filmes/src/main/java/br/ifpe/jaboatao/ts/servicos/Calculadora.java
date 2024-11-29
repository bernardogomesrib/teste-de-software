package br.ifpe.jaboatao.ts.servicos;

import br.ifpe.jaboatao.ts.exceptions.LocacaoException;

public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public double dividir(int dividendo, int divisor) throws LocacaoException {
        if (divisor == 0) {
            throw new LocacaoException("Divisão por zero");
        }
        return dividendo / divisor;
    }

    public int subtrair(int... numeros) {
        int subtrair = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            subtrair -= numeros[i];
        }
        return subtrair;
    }

    public double dividir(int... numeros) throws LocacaoException {
        double resultado = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] == 0) {
                throw new LocacaoException("Divisão por zero");
            }
            resultado /= numeros[i];
        }
        return resultado;
    }

    public int somar(int... numeros) {
        int somar = 0;
        for (int i = 0; i < numeros.length; i++) {
            somar += numeros[i];
        }
        return somar;
    }

    public int multiplicar(int... numeros) {
        int multiplicar = 1;
        for (int i = 0; i < numeros.length; i++) {
            multiplicar *= numeros[i];
        }
        return multiplicar;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }
}
