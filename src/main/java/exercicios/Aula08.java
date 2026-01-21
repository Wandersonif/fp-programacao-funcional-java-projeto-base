package exercicios;

import exercicios.base.Aula;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Aula08 extends Aula {
    public Aula08(){
        Map<String, Double> mapa = estudantes
                .stream()
                .collect(
                        toMap(Estudante::getNome, Estudante::getNota));
        mapa.forEach((nome, nota) -> System.out.println("Nome: " + nome + "Nota: " + nota));
//        Estudante estudante =
//                estudantes.stream()
//                .reduce((e1, e2) -> e1.getNota() > e2.getNota() ? e1 : e2)
//                .orElseThrow(() -> new NoSuchElementException("Nenhum estudante encontrado"));
//        System.out.println("Estudante Localizado: " + estudante);
//        var mapPessoaComanda = new HashMap<>(Map.of(
//                "Joao", 1.75,
//                "Maria", 1.65,
//                "José", 1.80,
//                "Ana", 1.70,
//                "Carlos", 1.75,
//                "Mariana", 1.65,
//                "Pedro", 1.80,
//                "Paula", 1.70
//        ));
//        mapPessoaComanda.putIfAbsent("Manoel", getValue());
//        mapPessoaComanda.computeIfAbsent("Raysa", nome -> getValue());
//        mapPessoaComanda.merge("Manoel", 100.0, Double::sum);
//        mapPessoaComanda.replaceAll((nome, valor) -> valor >= 100 ? valor * 0.9 : valor);
//          mapPessoaComanda
//                  .entrySet()
//                  .stream()
//                  .forEach(e -> {
//                      var novoValor = e.getValue() >= 100 ? e.getValue() * 0.9 : e.getValue();
//                      System.out.println(e.getKey() + ": " + novoValor);
//                  });
//          System.out.println(mapPessoaComanda.size());

//          mapPessoaComanda.entrySet().removeIf(entry -> entry.getValue() < 100);

//          mapPessoaComanda.forEach((nome, valor) -> System.out.println(nome+":"+valor));
    }

    private static double getValue() {
        return 100.0;
    }

    public static void main(String[] args){
        new Aula08();
    }
}
