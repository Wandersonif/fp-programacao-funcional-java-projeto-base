package exercicios;

import exercicios.base.Aula;

public class Aula05 extends Aula {

    public Aula05() {
        estudantes.stream()
                .filter(e -> e.getSexo() == 'M')
                .mapToDouble(e -> e.getNota())
                .min()
                .orElse(0);
    }

    static void main(String[] args) {
//
    }

}
