package sort;

import response.AlgorithmsResult;
import response.Result;

public class Insertion extends Algorithms implements Sort {

    public Insertion() {
        super("Insertion Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMelhorCaso();
        return new Result(2, 4, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Melhor Caso", tamanhoVetor, resultado.getTrocas());
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMedioCaso();
        return new Result(2, 5, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Pior Caso", tamanhoVetor, resultado.getTrocas());
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicPiorCaso();
        return new Result(2, 6, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Caso Medio", tamanhoVetor, resultado.getTrocas());
    }
}
