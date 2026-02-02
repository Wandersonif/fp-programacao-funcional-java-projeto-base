package exercicios;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Aula12_Totalmente_Funcional {
    private final int[][] teatro = new int[10][6];

    public Aula12_Totalmente_Funcional() {
        definirValoresAssentos();
        imprimir();
        System.out.println("Total de assentos menores ou iguais a R$ 80,00 "+
                contar(valorColuna1 -> valorColuna1 < 80));
    }

    private void imprimir() {
        for (int[] linha : teatro) {
            for (int valorColuna : linha) {
                System.out.printf("%5d ",  valorColuna);
            }
            System.out.println();
        }
    }
    private long contar(IntPredicate condicao) {
        return Arrays.stream(teatro)
                .flatMapToInt(Arrays::stream)
                .filter(condicao)
                .count();
    }
    private void definirValoresAssentos(){
        for (int i = 0; i < teatro.length; i++) {
            for (int j = 0; j < teatro[i].length; j++) {
                teatro[i][j] = (int)(50 + Math.random() * 100);
            }
        }
    }
    public static void main(String[] args){
        new Aula12_Totalmente_Funcional();
    }
}

