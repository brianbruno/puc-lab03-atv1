package sort;

import response.AlgorithmsResult;
import response.Result;

public class Quick extends Algorithms implements Sort{

    public Quick() {
        super("Quick Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMelhorCaso();
        return new Result(2, 10, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Melhor Caso", tamanhoVetor, resultado.getTrocas());
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicMedioCaso();
        return new Result(2, 11, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Caso Medio", tamanhoVetor, resultado.getTrocas());
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        AlgorithmsResult resultado = magicPiorCaso();
        return new Result(2, 12, resultado.getMedia(), resultado.getDesvioPadrao(), comparacoes,"Ordenacao Pior Caso", tamanhoVetor, resultado.getTrocas());
    }

    @Override
    public int sortMagic() {
        comparacoes = 0;
        trocas = 0;
        long timeTotal = 0;
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
                trocas++;
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
