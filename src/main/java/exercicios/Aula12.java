package exercicios;

import java.util.function.Predicate;

public class Aula12 {
    private final int[][] teatro = new int[10][6];

    public Aula12() {
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
    private int contar(Predicate<Integer> condicao) {
        int contador = 0;
        for (int[] linha : teatro) {
            for (int valorColuna : linha) {
                if (condicao.test(valorColuna))
                    contador++;
            }
            }
        return contador;
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

