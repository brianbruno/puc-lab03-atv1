package sort;

import java.util.Random;

public class Algorithms {

    int comparacoes;
    int vetor[];
    String nomeMetodo;
    public static final int REPETICOES = 100;

    public Algorithms(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
        this.comparacoes = 0;
    }

    public void preencherVetor(int valores){
        vetor = new int[valores];

        Random gerador = new Random();

        for(int i : vetor)
            vetor[i] = gerador.nextInt(100000);

    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void ordenarVetorDecrescente () {
        for (int i = vetor.length-1; i >= 0; i--){

            int aux = vetor[i];
            int j = i;

            while ((j > 0) && (vetor[j-1] > aux)){
                vetor[j] = vetor[j-1];
                j -= 1;
            }
            vetor[j] = aux;
        }
    }

    public void ordenarVetor() {
        for (int i = 1; i < vetor.length; i++){

            int aux = vetor[i];
            int j = i;

            while (comparacoes++ > -1 && (j > 0) && (vetor[j-1] > aux)){
                vetor[j] = vetor[j-1];
                j -= 1;
            }
            vetor[j] = aux;

        }
    }

    public int sortMagic() {
        comparacoes = 0;
        long timeTotal = 0;

        long timeStart = System.currentTimeMillis();
        ordenarVetor();
        long timeEnd = System.currentTimeMillis();
        timeTotal += timeEnd - timeStart;

        return (int) timeTotal;
    }

    public int magicMelhorCaso() {
        int timeTotal = 0; int i = 0;
        while (i < REPETICOES) {
            preencherVetor(vetor.length);
            // ordeno pois eh o melhor caso
            ordenarVetor();
            timeTotal += sortMagic();
            i++;
        }
        return timeTotal/REPETICOES;
    }

    public int magicMedioCaso() {
        int timeTotal = 0; int i = 0;
        while (i < REPETICOES) {
            preencherVetor(vetor.length);
            timeTotal += sortMagic();
            i++;
        }
        return timeTotal/REPETICOES;
    }

    public int magicPiorCaso () {
        int timeTotal = 0; int i = 0;
        while (i < REPETICOES) {
            preencherVetor(vetor.length);
            // desordeno pois é o pior caso
            ordenarVetorDecrescente();
            timeTotal += sortMagic();
            i++;
        }
        return timeTotal/REPETICOES;
    }
}
