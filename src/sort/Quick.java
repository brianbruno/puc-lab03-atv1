package sort;

import response.Result;

public class Quick extends Algorithms implements Sort{

    public Quick() {
        super("Quick Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        int timeTotal = 0; int i = 0;
        while (i < REPETICOES) {
            preencherVetor(tamanhoVetor);
            // ordeno pois eh o melhor caso
            ordenarVetor();
            timeTotal += sortMagic();
            i++;
        }
        timeTotal = timeTotal/REPETICOES;
        return new Result(2, 9, timeTotal, comparacoes,"Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        int timeTotal = 0; int i = 0;
        while (i < REPETICOES) {
            preencherVetor(tamanhoVetor);
            timeTotal += sortMagic();
            i++;
        }
        timeTotal = timeTotal/REPETICOES;
        return new Result(2, 10, timeTotal, comparacoes,"Ordenacao Caso Medio", tamanhoVetor);
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
        timeTotal = timeTotal/REPETICOES;
        return new Result(2, 11, timeTotal, comparacoes,"Ordenacao Pior Caso", tamanhoVetor);
    }

    @Override
    public int sortMagic() {
        long timeTotal = 0;
        comparacoes = 0;
        long timeStart = System.currentTimeMillis();
        quickSort(vetor,0,vetor.length-1);
        long timeEnd = System.currentTimeMillis();
        timeTotal += timeEnd - timeStart;

        return (int) timeTotal;
    }

    public void quickSort(int v[], int esquerda, int direita) {
        int esq = esquerda;
        int dir = direita;
        int pivo = v[(esq + dir) / 2];
        int troca;

        while (esq <= dir) {
            while (comparacoes++>-1 && v[esq] < pivo) {
                comparacoes++;
                esq = esq + 1;
            }
            while (comparacoes++>-1 && v[dir] > pivo) {
                comparacoes++;
                dir = dir - 1;
            }
            if (comparacoes++>-1 && esq <= dir) {
                troca = v[esq];
                v[esq] = v[dir];
                v[dir] = troca;
                esq = esq + 1;
                dir = dir - 1;
            }
        }
        if (dir > esquerda)
            quickSort(v, esquerda, dir);
        if (esq < direita)
            quickSort(v, esq, direita);
    }
}
