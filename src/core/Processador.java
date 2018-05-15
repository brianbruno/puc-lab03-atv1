package core;

import file.Report;
import response.Result;
import sort.Sort;

import java.util.ArrayList;
import java.util.HashMap;

public class Processador extends Thread {

    Ordenadores sorters;
    Report report;

    public Processador(Ordenadores sorters, Report report) {
        this.sorters = sorters;
        this.report = report;
    }

    public void run() {
        try {
            HashMap<String, Object> sorter;
            while ((sorter = sorters.getOrdenador()) != null) {
                int tamanho = (int) sorter.get("tamanho");
                Sort ordenador = (Sort) sorter.get("ordenador");
                ArrayList<Result> resultados = new ArrayList<>();
                System.out.println("Método iniciado: " + ordenador.getNomeMetodo() + ". Tamanho: " + tamanho);
                resultados.add(ordenador.ordenarMelhorCaso(tamanho));
                resultados.add(ordenador.ordenarCasoMedio(tamanho));
                resultados.add(ordenador.ordenarPiorCaso(tamanho));

                System.out.println("Método finalizado: " + ordenador.getNomeMetodo() + ". Tamanho: " + tamanho);
                if (!report.atualizarRelatorio(resultados))
                    System.err.println("Erro ao salvar o arquivo");
            }

        }
        catch (Exception e) {
            // Throwing an exception
            e.printStackTrace();
            System.out.println ("Exception is caught");
        }
    }
}
