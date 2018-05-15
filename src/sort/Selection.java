package sort;

import response.AlgorithmsResult;
import response.Result;

public class Selection extends Algorithms implements Sort {

    public Selection() {
        super("Selection Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMelhorCaso();
        return new Result(2, 13, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMedioCaso();
        return new Result(2, 14, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes, "Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicPiorCaso();
        return new Result(2, 15, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes, "Ordenacao Pior Caso", tamanhoVetor);
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
