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

    public void ordenar(){

    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }


}
