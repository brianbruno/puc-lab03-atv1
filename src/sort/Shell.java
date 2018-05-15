package sort;

import response.Result;

public class Shell extends Algorithms implements Sort {

    public Shell() {
        super("Shell Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        int timeTotal = magicMelhorCaso();
        return new Result(2, 16, timeTotal, comparacoes,"Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        int timeTotal = magicMedioCaso();
        return new Result(2, 17, timeTotal, comparacoes,"Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        int timeTotal = magicPiorCaso();
        return new Result(2, 18, timeTotal, comparacoes,"Ordenacao Pior Caso", tamanhoVetor);
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
                    j -= incremento;
                }
                vetor[j + incremento] = temp;
            }
        }
    }
}
