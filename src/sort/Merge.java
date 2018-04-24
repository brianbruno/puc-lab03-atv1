package sort;

import response.Result;

public class Merge extends Algorithms implements Sort {

    private int[] helper;

    public Merge() {
        super("Merge Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        int timeTotal = magicMelhorCaso();
        return new Result(2, 6, timeTotal, comparacoes,"Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        int timeTotal = magicMedioCaso();
        return new Result(2, 7, timeTotal, comparacoes, "Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        int timeTotal = magicPiorCaso();
        return new Result(2, 8,(int) timeTotal, comparacoes,"Ordenacao Pior Caso", tamanhoVetor);
    }

    @Override
    public int sortMagic() {
        long timeTotal = 0;
        int tamanhoVetor = vetor.length;
        this.helper = new int[tamanhoVetor];
        comparacoes = 0;

        long timeStart = System.currentTimeMillis();
        mergesort(0,tamanhoVetor-1);
        long timeEnd = System.currentTimeMillis();
        timeTotal += timeEnd - timeStart;

        return (int) timeTotal;
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
        while (comparacoes++>-1 && i <= middle && j <= high) {
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
