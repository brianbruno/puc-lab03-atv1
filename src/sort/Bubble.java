package sort;

import response.AlgorithmsResult;
import response.Result;

public class Bubble extends Algorithms implements Sort {

    public Bubble() {
        super("Bubble Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMelhorCaso();
        return new Result(2, 22, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes, "Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMedioCaso();
        return new Result(2, 23, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes, "Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicPiorCaso();
        return new Result(2, 24, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes, "Ordenacao Pior Caso", tamanhoVetor);
    }

    public void ordenarVetor() {
        int[] v = vetor;
        for (int i = v.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (comparacoes++>-1 && v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
    }
}
