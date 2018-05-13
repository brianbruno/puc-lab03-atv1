package sort;

import response.Result;

public class Bubble extends Algorithms implements Sort {

    public Bubble() {
        super("Bubble Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        // ordeno pois eh o melhor caso
        ordenar();
        long timeStart = System.currentTimeMillis();
        bubbleSort(vetor);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 21,(int) timeTotal, "Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        long timeStart = System.currentTimeMillis();
        bubbleSort(vetor);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 22,(int) timeTotal, "Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        ordenarVetorDecrescente();
        long timeStart = System.currentTimeMillis();
        bubbleSort(vetor);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 23,(int) timeTotal, "Ordenacao Pior Caso", tamanhoVetor);
    }

    public void bubbleSort(int v[]) {
        for (int i = v.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
    }
}
