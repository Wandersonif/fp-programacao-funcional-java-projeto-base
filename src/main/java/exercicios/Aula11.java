package exercicios;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Aula11 {
    private Map<String, List<String>> estadoCidadesMap =
            Map.of("MG", List.of("Belo horizonte", "Contagem", "Betim"),
                    "SP", List.of("Sao Paulo", "Campinas", "Santos"),
                    "RJ", List.of("Rio de Janeiro", "Niteroi", "Cabo Frio"));

    public Aula11() {
       var totalCidadesPorEstado = estadoCidadesMap
//          List<String> list = estadoCidadesMap
//                .values()
//                .stream()
//                .flatMap(Collection::stream)
//                .flatMap(cidades -> cidades.stream().map(String::toUpperCase))
//                .flatMap(cidades -> Stream.of(cidades.size()))
//                .toList();
//                list.forEach(System.out::println);
//                .forEach((estado, cidades) -> System.out.println(estado+ ": " + cidades));
               .entrySet()
               .stream()
               .collect(
                       toMap(Map.Entry::getKey, e -> e.getValue().size()));
       totalCidadesPorEstado
               .forEach(
                       (estado, totalCidades) -> System.out.println(estado + " - " + totalCidades));

    }
    public static void main(String[] args) {
        new Aula11();

    }
}
