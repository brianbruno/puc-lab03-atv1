package sort;

import response.Result;

public class Insertion extends Algorithms implements Sort {

    public Insertion() {
        super("Insertion Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        int timeTotal = magicMelhorCaso();
        return new Result(2, 3, timeTotal/REPETICOES, comparacoes,"Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        int timeTotal = magicMedioCaso();
        return new Result(2, 5, timeTotal/REPETICOES, comparacoes,"Ordenacao Pior Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        int timeTotal = magicPiorCaso();
        return new Result(2, 4, timeTotal/REPETICOES, comparacoes,"Ordenacao Caso Medio", tamanhoVetor);
    }
}
