package exercicios;

import exercicios.base.Aula;

import java.util.NoSuchElementException;

public class Aula07 extends Aula {
    public Aula07() {
        var maximoOptional = estudantes.stream()
                .filter(e -> e.getSexo() == 'X')
                .mapToDouble(Estudante::getNota)
                .max();
//        double maiorNota = maximoOptional.orElse(0);
//        System.out.println("Maximo de notas: " + maximoOptional);
//        double maiorNota = maximoOptional.orElseGet(Aula07::getNotaAleatoria);
          double maiorNota = maximoOptional
                  .orElseThrow(() -> new NoSuchElementException("Nenhum Estudante Localizado"));

    }

    public static void main(String[] args) {
        new Aula07();
    }

//    private static double getNotaAleatoria() {
//        var x = Math.random();
//        var y = Math.random();
//        return x + y;
//    }
}
