package exercicios;

import exercicios.base.Aula;
import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Map;

/**
 * Implementação da Aula06 utilizando Programação Funcional (Java Stream API).
 * Aplica filtros (Predicate), ordenação (Comparator) e agregação (Collector).
 */
public class Aula06 extends Aula {

    // --- Predicados e Composição de Funções (Funções Puras) ---
    private final Predicate<Estudante> isMulher = Estudante::isMulher;
    private final Predicate<Estudante> estaMatriculada = Estudante::hasCurso;
    private final Predicate<Estudante> estaAprovada = Estudante::isAprovado;

    /**
     * Predicado composto: Mulher AND Tem Curso AND Aprovada.
     */
    private final Predicate<Estudante> mulheresAprovadas = isMulher
            .and(estaMatriculada)
            .and(estaAprovada);

    /**
     * Chama os métodos implementados e imprime os resultados.
     */
    public Aula06() {
        // --- Chamadas para conferir os valores retornados ---

        System.out.println("--- 1. Mulheres Aprovadas Não Ordenadas (Apenas Filtro) ---");
        List<Estudante> mulheresFiltradas = this.getEstudantesMulheresAprovadas();
        mulheresFiltradas.forEach(System.out::println);
        System.out.println("Total de estudantes filtradas: " + mulheresFiltradas.size());
        System.out.println("----------------------------------------------------------\n");

        System.out.println("--- 2. Média de Notas Agrupada por Curso (Agregação/Reduce) ---");
        Map<String, Double> mediasPorCurso = this.calcularMediaPorCurso();
        mediasPorCurso.forEach((curso, media) ->
                System.out.printf("Curso: %-25s Média: %.2f\n", curso, media)
        );
        System.out.println("----------------------------------------------------------\n");
    }

    /**
     * Veja o método construtor {@link #Aula06()}.
     */
    public static void main(String[] args) {
        new Aula06();
    }

    /**
     * Obtém uma Lista <b>NÃO-MODIFICÁVEL</b> de mulheres matriculadas e aprovadas.
     * @return uma Lista NÃO-MODIFICÁVEL de estudantes.
     */
    public List<Estudante> getEstudantesMulheresAprovadas() {
        return getEstudantes().stream()
                .filter(mulheresAprovadas)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Obtém uma Lista com os mesmos filtros, mas ordenada por Curso (Crescente) e Nota (Crescente).
     * @return uma Lista NÃO-MODIFICÁVEL de estudantes.
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota() {
        return getEstudantes().stream()
                .filter(mulheresAprovadas)
                .sorted(Comparator
                        .comparing((Estudante e) -> e.getCurso().getNome()) // Curso Crescente
                        .thenComparing(Estudante::getNota) // Nota Crescente
                )
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Obtém uma Lista com os mesmos filtros, mas ordenada por Curso (Decrescente) e Nota (Crescente).
     * @return uma Lista NÃO-MODIFICÁVEL de estudantes.
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente() {
        return getEstudantes().stream()
                .filter(mulheresAprovadas)
                .sorted(Comparator
                        .comparing((Estudante e) -> e.getCurso().getNome())
                        .reversed() // Curso Decrescente
                        .thenComparing(Estudante::getNota) // Nota Crescente
                )
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Obtém uma Lista com os mesmos filtros, mas na ordem original.
     * A lista deve ser <b>MODIFICÁVEL</b>.
     * @return uma Lista MODIFICÁVEL de estudantes.
     */
    public List<Estudante> getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {
        return getEstudantes().stream()
                .filter(mulheresAprovadas)
                .collect(Collectors.toList());
    }

    /**
     * Obtém uma Lista com os mesmos filtros, mas ordenada de forma decrescente tanto pelo curso quanto pela nota.
     * @return uma Lista NÃO-MODIFICÁVEL de estudantes.
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente() {
        return getEstudantes().stream()
                .filter(mulheresAprovadas)
                .sorted(Comparator
                        .comparing((Estudante e) -> e.getCurso().getNome())
                        .reversed() // Curso Decrescente
                        .thenComparing(Comparator.comparing(Estudante::getNota).reversed()) // Nota Decrescente
                )
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Obtém uma Lista com os mesmos filtros, mas ordenada por Curso (Crescente) e Nota (Decrescente).
     * @return uma Lista NÃO-MODIFICÁVEL de estudantes.
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente() {
        return getEstudantes().stream()
                .filter(mulheresAprovadas)
                .sorted(Comparator
                        .comparing((Estudante e) -> e.getCurso().getNome()) // Curso Crescente
                        .thenComparing(Comparator.comparing(Estudante::getNota).reversed()) // Nota Decrescente
                )
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Implementação do Modelo Map/Reduce para agregação de dados.
     * Agrupa estudantes por curso e calcula a nota média (Reduce).
     */
    public Map<String, Double> calcularMediaPorCurso() {
        return getEstudantes().stream()
                .filter(Estudante::hasCurso)
                .collect(Collectors.groupingBy(
                        (Estudante e) -> e.getCurso().getNome(), // Map: Agrupamento pela chave (Nome do Curso)
                        Collectors.averagingDouble(Estudante::getNota) // Reduce: Cálculo da Média
                ));
    }
}