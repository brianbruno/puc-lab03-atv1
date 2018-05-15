package sort;

import response.Result;

public class Selection extends Algorithms implements Sort {

    public Selection() {
        super("Selection Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        int timeTotal = magicMelhorCaso();
        return new Result(2, 13, timeTotal, comparacoes,"Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        int timeTotal = magicMedioCaso();
        return new Result(2, 14, timeTotal, comparacoes, "Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        int timeTotal = magicPiorCaso();
        return new Result(2, 15, timeTotal, comparacoes, "Ordenacao Pior Caso", tamanhoVetor);
    }

    public void ordenarVetor() {
        int [] arr = vetor;
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (comparacoes++>-1 && arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

}
