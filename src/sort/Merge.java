package sort;

import response.Result;

public class Merge extends Algorithms implements Sort {

    private int[] helper;

    public Merge() {
        super("Merge Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        this.helper = new int[tamanhoVetor];
        // ordeno pois eh o melhor caso
        ordenar();
        long timeStart = System.currentTimeMillis();
        mergesort(0,tamanhoVetor-1);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 6,(int) timeTotal, "Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        this.helper = new int[tamanhoVetor];
        long timeStart = System.currentTimeMillis();
        mergesort(0,tamanhoVetor-1);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 7,(int) timeTotal, "Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        ordenarVetorDecrescente();
        this.helper = new int[tamanhoVetor];
        long timeStart = System.currentTimeMillis();
        mergesort(0,tamanhoVetor-1);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 8,(int) timeTotal, "Ordenacao Pior Caso", tamanhoVetor);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = vetor[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                vetor[k] = helper[i];
                i++;
            } else {
                vetor[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            vetor[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
}
