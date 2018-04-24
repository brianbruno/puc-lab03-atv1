package sort;

import response.Result;

public class Shell extends Algorithms implements Sort{

    public Shell() {
        super("Shell Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        int timeTotal = 0; int i = 0;
        while (i < REPETICOES) {
            preencherVetor(tamanhoVetor);
            ordenarVetor();
            timeTotal = sortMagic();
            i++;
        }
        return new Result(2, 12, timeTotal/REPETICOES, comparacoes,"Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        int timeTotal = 0; int i = 0;
        while (i < REPETICOES) {
            preencherVetor(tamanhoVetor);
            timeTotal += sortMagic();
            i++;
        }
        return new Result(2, 13, timeTotal/REPETICOES, comparacoes,"Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        int timeTotal = 0; int i = 0;
        while (i < REPETICOES) {
            preencherVetor(tamanhoVetor);
            ordenarVetorDecrescente();
            timeTotal += sortMagic();
            i++;
        }
        return new Result(2, 14, timeTotal/REPETICOES, comparacoes,"Ordenacao Pior Caso", tamanhoVetor);
    }

    @Override
    public int sortMagic() {
        long timeTotal = 0;
        comparacoes = 0;
        long timeStart = System.currentTimeMillis();
        shell();
        long timeEnd = System.currentTimeMillis();
        timeTotal += timeEnd - timeStart;

        return (int) timeTotal;
    }

    public void shell(){
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
