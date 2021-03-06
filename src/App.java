import core.Ordenadores;
import core.Processador;
import file.Report;
import response.Result;
import sort.*;

import java.util.ArrayList;

public class App {

    private static Sort ordenadores[] = new Sort[7];
    public static final int TAMANHOS[] = { 500000, 600000, 700000, 800000 };

    public static void main(String[] args) {

        System.out.println("### Algoritmos de Ordenacao ###");

        ordenadores[0] = new Insertion();
        ordenadores[1] = new Merge();
        ordenadores[2] = new Quick();
        ordenadores[3] = new Selection();
        ordenadores[4] = new Shell();
        ordenadores[5] = new Heap();
        ordenadores[6] = new Bubble();

        Report report = new Report();

        for (int tam : TAMANHOS) {
            System.out.println("Tamanho do arranjo: " + tam);
            for (Sort sorter : ordenadores) {
                System.out.println(sorter.getNomeMetodo());
                ArrayList<Result> resultados = new ArrayList<>();

                resultados.add(sorter.ordenarMelhorCaso(tam));
                resultados.add(sorter.ordenarCasoMedio(tam));
                resultados.add(sorter.ordenarPiorCaso(tam));

                if (!report.atualizarRelatorio(resultados))
                    System.err.println("Erro ao salvar o arquivo");
            }
        }

    }

}
