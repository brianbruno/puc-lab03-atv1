package sort;

import response.AlgorithmsResult;

import java.util.ArrayList;
import java.util.Random;

public class Algorithms {

    int comparacoes;
    int vetor[];
    String nomeMetodo;
    public static final int REPETICOES = 5;
    int tamanhoVetor;
    ArrayList<Integer> tempos;
    int trocas = 0;

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
        trocas = 0;
        for (int i = 1; i < vetor.length; i++){

            int aux = vetor[i];
            int j = i;

            while (comparacoes++ > -1 && (j > 0) && (vetor[j-1] > aux)){
                trocas++;
                vetor[j] = vetor[j-1];
                j -= 1;
            }
            vetor[j] = aux;

        }
    }

    public int sortMagic() {
        comparacoes = 0;
        trocas = 0;
        long timeTotal = 0;

        long timeStart = System.currentTimeMillis();
        ordenarVetor();
        long timeEnd = System.currentTimeMillis();
        timeTotal += timeEnd - timeStart;

        return (int) timeTotal;
    }

    public AlgorithmsResult magicMelhorCaso() {
        int i = 0;
        tempos = new ArrayList<>();
        while (i < REPETICOES) {
            preencherVetor(tamanhoVetor);
            // ordeno pois eh o melhor caso
            ordenarVetor();
            tempos.add(sortMagic());
            i++;
        }
        return new AlgorithmsResult(getMean(), getStdDev(), trocas);
    }

    public AlgorithmsResult magicMedioCaso() {
        int i = 0;

        while (i < REPETICOES) {
            preencherVetor(tamanhoVetor);
            tempos.add(sortMagic());
            i++;
        }

        return new AlgorithmsResult(getMean(), getStdDev(), trocas);
    }

    public AlgorithmsResult magicPiorCaso () {
        int i = 0;
        while (i < REPETICOES) {
            preencherVetor(tamanhoVetor);
            // desordeno pois é o pior caso
            ordenarVetorDecrescente();
            tempos.add(sortMagic());
            i++;
        }
        return new AlgorithmsResult(getMean(), getStdDev(), trocas);
    }

    public double getMean() {

        double sum = 0.0;
        for(int a : tempos)
            sum += a;
        return sum/tempos.size();
    }

    public double getVariance() {
        double mean = getMean();
        double temp = 0;
        for(double a : tempos)
            temp += (a-mean)*(a-mean);
        return temp/(tempos.size()-1);
    }

    public  double getStdDev() {
        return Math.sqrt(getVariance());
    }

}
