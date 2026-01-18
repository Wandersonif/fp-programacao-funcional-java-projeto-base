package exercicios;

import exercicios.base.Aula;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class Aula06_DuranteA_Aula extends Aula {
    public Aula06_DuranteA_Aula() {

        var filtro = ((Predicate<Estudante>)Estudante::hasCurso)
                .and(Estudante::isAprovado);
//        Predicate<Estudante> isHomem = Estudante::isHomem;
//        var filtro = isHomem.and(Estudante::hasCurso);
//        long homens = estudantes.stream()
//                .filter(not(filtro))
//                .count();
//        System.out.println("O homens tem: " + homens);
//
//        long homensPalmas = estudantes.stream()
//                .filter(not(filtro))
//                .filter(e -> e.getCidade().getNome().equals("Palmas"))
//                .count();
//        System.out.println("homens de Palmas: " + homensPalmas);

        estudantes.stream()
                .filter(filtro)
                .sorted(Comparator.comparingDouble(Estudante::getNota))
                .forEach(System.out::println);
    }

public static void main(String[] args) {
    new Aula06_DuranteA_Aula();
    }
}