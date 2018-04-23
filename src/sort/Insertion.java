package sort;

import response.Result;

public class Insertion extends Algorithms implements Sort {

    public Insertion() {
        super("Insertion Sort");
    }

    @Override
    public Result ordenarMelhorCaso (int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        ordenar();
        long timeStart = System.currentTimeMillis();
        ordenarVetor();
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 3,(int) timeTotal, "Ordenacao Melhor Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarPiorCaso(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        ordenarVetorDecrescente();
        long timeStart = System.currentTimeMillis();
        ordenarVetor();
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 5,(int) timeTotal, "Ordenacao Pior Caso", tamanhoVetor);
    }

    @Override
    public Result ordenarCasoMedio(int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        long timeStart = System.currentTimeMillis();
        ordenarVetor();
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return new Result(2, 4,(int) timeTotal, "Ordenacao Caso Medio", tamanhoVetor);
    }

    private void ordenarVetor () {
        for (int i = 1; i < vetor.length; i++){

            int aux = vetor[i];
            int j = i;

            while ((j > 0) && (vetor[j-1] > aux)){
                vetor[j] = vetor[j-1];
                j -= 1;
            }
            vetor[j] = aux;

        }
    }




}
