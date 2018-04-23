package sort;

import java.util.Random;

public class Algorithms {

    int vetor[];
    String nomeMetodo;

    public Algorithms(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
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

    public void ordenar() {
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
