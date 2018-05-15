package sort;

import response.Result;

public class Insertion extends Algorithms implements Sort {

    public Insertion() {
        super("Insertion Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        int timeTotal = magicMelhorCaso();
        return new Result(2, 4, timeTotal, comparacoes,"Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        int timeTotal = magicMedioCaso();
        return new Result(2, 5, timeTotal, comparacoes,"Ordenacao Pior Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        int timeTotal = magicPiorCaso();
        return new Result(2, 6, timeTotal, comparacoes,"Ordenacao Caso Medio", tamanhoVetor);
    }
}
