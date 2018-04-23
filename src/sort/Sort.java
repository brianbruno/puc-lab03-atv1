package sort;

import response.Result;

public interface Sort  {

    Result ordenarMelhorCaso (int tamanhoVetor);
    Result ordenarPiorCaso (int tamanhoVetor);
    Result ordenarCasoMedio (int tamanhoVetor);
    String getNomeMetodo();

}
