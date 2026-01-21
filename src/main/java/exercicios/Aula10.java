package exercicios;

import exercicios.base.Aula;

import java.util.stream.Stream;

public class Aula10 extends Aula {

    public Aula10() {
        var estudanteStream = estudantes
                .stream()
                .filter(Estudante::isAprovado);
        double maiorNotaHomens = maiorNotaHomens(estudanteStream);
        System.out.println("Nota do F: " + maiorNotaHomens);

                estudantes.stream()
                        .filter(e -> e.getSexo() == 'F')
                        .mapToDouble((Estudante::getNota))
                        .max()
                        .ifPresent(maiorNota -> System.out.println("Maior nota: " + maiorNota));

    }

    private double maiorNotaHomens(Stream<Estudante> estudanteStream) {
        return estudanteStream.mapToDouble(Estudante::getNota).max().orElse(0);
    }
}
