package sort;

import response.AlgorithmsResult;
import response.Result;

public class Shell extends Algorithms implements Sort {

    public Shell() {
        super("Shell Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMelhorCaso();
        return new Result(2, 16, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Melhor Caso", tamanhoVetor, resultado.getTrocas());
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMedioCaso();
        return new Result(2, 17, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Caso Medio", tamanhoVetor, resultado.getTrocas());
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicPiorCaso();
        return new Result(2, 18, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Pior Caso", tamanhoVetor, resultado.getTrocas());
    }

    public void ordenarVetor(){
        int i , j , temp, size = vetor.length;

        int incremento = 1;
        while(incremento < size) {
            incremento = 3 * incremento + 1;
        }

        while (incremento > 1) {
            incremento /= 3;

            for(i = incremento; i < size; i++) {
                temp = vetor[i];
                j = i - incremento;
                while (comparacoes++>-1 && j >= 0 && temp < vetor[j]) {
                    vetor[j + incremento] = vetor[j];
                    trocas++;
                    j -= incremento;
                }
                vetor[j + incremento] = temp;
                trocas++;
            }
        }
    }
}
