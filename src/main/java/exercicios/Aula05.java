package exercicios;

import exercicios.base.Aula;

public class Aula05 extends Aula {

//    public Aula05() {
//        estudantes.stream()
//                .filter(e -> e.getSexo() == 'M')
//                .mapToDouble(e -> e.getNota())
//                .min()
//                .orElse(0);
//    }
//        public Aula05() {
//            double menorNota = estudantes.stream()
//                    .filter(e -> e.getSexo() == 'M')
//                    .mapToDouble(e -> e.getNota())
//                    .filter(nota -> nota > 0)
//                    .min()
//                    .orElse(0);
//        }
//    public Aula05() {
//        long totaEstados = estudantes.stream()
//                .map(e -> e.getCidade())
//                .map(cidade -> cidade.getEstado())
//                .distinct()
//                .count();
//        System.out.println("Total de estados : " + totaEstados);
//    }
        public Aula05() {
            double menorNota = estudantes.stream()
                    .filter(Estudante::isHomem)
                    .filter(Estudante::hasNota)
                    .mapToDouble(Estudante::getNota)
                    .map(nota -> nota * 100)
                    .min()
                    .orElse(0);
            System.out.println(menorNota);
        }

    static void main(String[] args) {
        new Aula05();
    }

}
