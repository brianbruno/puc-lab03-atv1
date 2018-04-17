import file.Report;
import sort.Insertion;
import sort.Sort;

public class App {

    private static Sort ordenadores[] = new Sort[1];

    public static void main(String[] args) {

        System.out.println("### Algoritmos de Ordenacao ###");

        ordenadores[0] = new Insertion();

        Report report = new Report();

        for(Sort sorter : ordenadores) {
            System.out.println(sorter.getNomeMetodo());
            String tempo = String.valueOf(sorter.realizarOrdenacao(10000));
            System.out.println("Tempo total: " + tempo);
            report.saveFile(tempo, 3, 3);
        }



    }

}
