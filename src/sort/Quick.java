package sort;

import response.Result;

public class Quick extends Algorithms implements Sort{

    public Quick() {
        super("Quick Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        // ordeno pois eh o melhor caso
        ordenar();
        long timeStart = System.currentTimeMillis();
        quickSort(vetor,0,vetor.length-1);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 9,(int) timeTotal, "Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        long timeStart = System.currentTimeMillis();
        quickSort(vetor,0,vetor.length-1);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 10,(int) timeTotal, "Ordenacao Caso Medio", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        ordenarVetorDecrescente();
        long timeStart = System.currentTimeMillis();
        quickSort(vetor,0,vetor.length-1);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 11,(int) timeTotal, "Ordenacao Pior Caso", tamanhoVetor);
    }

    public static void quickSort(int v[], int esquerda, int direita) {
        int esq = esquerda;
        int dir = direita;
        int pivo = v[(esq + dir) / 2];
        int troca;
        while (esq <= dir) {
            while (v[esq] < pivo) {
                esq = esq + 1;
            }
            while (v[dir] > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
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
