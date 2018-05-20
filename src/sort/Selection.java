package sort;

import response.AlgorithmsResult;
import response.Result;

public class Selection extends Algorithms implements Sort {

    public Selection() {
        super("Selection Sort (Tamanho dividido por 100)");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor/100;
        AlgorithmsResult resultado = magicMelhorCaso();
        return new Result(2, 13, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Melhor Caso", tamanhoVetor, resultado.getTrocas());
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor/100;
        AlgorithmsResult resultado = magicMedioCaso();
        return new Result(2, 14, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes, "Ordenacao Caso Medio", tamanhoVetor, resultado.getTrocas());
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor/100;
        AlgorithmsResult resultado = magicPiorCaso();
        return new Result(2, 15, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes, "Ordenacao Pior Caso", tamanhoVetor, resultado.getTrocas());
    }

    public void ordenarVetor() {
        int [] arr = vetor;
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparacoes++ > -1 && arr[j] < arr[index])
                    index = j;
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            trocas++;
            arr[i] = smallerNumber;
        }
    }

}
