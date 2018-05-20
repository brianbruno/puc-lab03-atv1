import core.Ordenadores;
import core.Processador;
import file.Report;
import sort.*;

public class AppThread {
    private static Sort ordenadores[] = new Sort[7];
    public static final int TAMANHOS[] = { 10000, 20000 };
    public static final int THREADS = 4;
    public static Processador[] proc;

    public static void main(String[] args) {

        System.out.println("### Algoritmos de Ordenacao ###");

        Ordenadores sorters = new Ordenadores();
        proc = new Processador[THREADS * TAMANHOS.length];
        Report report = new Report();

        for(int tam: TAMANHOS) {
            sorters.novoOrdenador(new Insertion(), tam);
            sorters.novoOrdenador(new Merge(), tam);
            sorters.novoOrdenador(new Quick(), tam);
            sorters.novoOrdenador(new Selection(), tam);
            sorters.novoOrdenador(new Shell(), tam);
            sorters.novoOrdenador(new Heap(), tam);
            sorters.novoOrdenador(new Bubble(), tam);
        }

        for (int i = 0; i < THREADS; i++) {
            proc[i] = new Processador(sorters, report);
            proc[i].start();
            i++;
        }

        for (int i = 0; i<proc.length; i++) {
            try {
                if(proc[i] != null) {
                    proc[i].join();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
