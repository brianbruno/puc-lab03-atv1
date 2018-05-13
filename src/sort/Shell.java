package sort;

import response.Result;

public class Shell extends Algorithms implements Sort {

    public Shell() {
        super("Shell Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        // ordeno pois eh o melhor caso
        ordenar();
        long timeStart = System.currentTimeMillis();
        shellSort(vetor, vetor.length);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 15,(int) timeTotal, "Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        long timeStart = System.currentTimeMillis();
        shellSort(vetor, vetor.length);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 16,(int) timeTotal, "Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        ordenarVetorDecrescente();
        long timeStart = System.currentTimeMillis();
        shellSort(vetor, vetor.length);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 17,(int) timeTotal, "Ordenacao Pior Caso", tamanhoVetor);
    }

    void shellSort(int[] array, int number_of_elements) {

        int increment, i, temp, j;

        for (increment = number_of_elements / 2; increment > 0; increment /= 2) {
            for (i = increment; i < number_of_elements; i++)
            {
                temp = array[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp < array[j - increment]) {
                        array[j] = array[j - increment];
                    } else {
                        break;
                    }
                }
                array[j] = temp;
            }
        }
    }
}
