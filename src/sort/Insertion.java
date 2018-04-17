package sort;

public class Insertion extends Algorithms implements Sort {

    public Insertion() {
        super("Insertion Sort");
    }

    public long realizarOrdenacao (int tamanhoVetor) {
        preencherVetor(tamanhoVetor);
        long timeStart = System.currentTimeMillis();
        System.out.println("Ordenacao Caso Medio");
        ordenarVetor();
        System.out.println("Ordenacao Melhor Caso");
        ordenarVetor();
        //System.out.println("Ordenacao Pior Caso");
        //ordenarVetorDecrescente();
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;
        return timeTotal;

    }

    public void ordenarVetor () {
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

    public void ordenarVetorDecrescente () {
        for (int i = vetor.length; vetor.length > 1; i--){

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
