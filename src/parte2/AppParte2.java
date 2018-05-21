package parte2;

import file.Report;
import response.Result;

import java.util.ArrayList;
import java.util.List;

public class AppParte2 {

    private static int ARQUIVOS = 11;

    public static void main(String[] args) {
    	
    	Arquivo arquivo = new Arquivo();
    	Report report = new Report();
    	ArrayList<Result> tempos;

        System.out.println("Simulador de lavanderia");

       // gravando no arquivo
        List<Pedido> pedidos;
        String linha;
        long timeStart;
        for (int i = 0; i < ARQUIVOS; i++) {
            System.out.println("#########################################");
            System.out.println("###         Lendo Arquivo: " + (10+i) + "         ###");
            int tamanho = 0;
            tempos = new ArrayList<>();

            pedidos = arquivo.lerArquivo(i);
            tamanho = pedidos.size();

            if(tamanho < 10000) {
                System.out.println("###      TOTAL DE REGISTROS: " + tamanho + "     ###");
            } else if (tamanho <= 100000) {
                System.out.println("###     TOTAL DE REGISTROS: " + tamanho + "     ###");
            }

            timeStart = System.currentTimeMillis();
            //criando uma fila de prioridade
            FilaPrioridade fp = new FilaPrioridade(pedidos);
            tempos.add(fp.simularFila(i, timeStart));

            timeStart = System.currentTimeMillis();
            // criando uma fila de menor primeiro
            OrdemMenorPrimeiro menorPrimeiro = new OrdemMenorPrimeiro(pedidos);
            tempos.add(menorPrimeiro.simularFila(i, timeStart));

            timeStart = System.currentTimeMillis();
            // criando uma fila por ordem de chegada
            OrdemChegada fifo = new OrdemChegada(pedidos);
            tempos.add(fifo.simularFila(i, timeStart));

            timeStart = System.currentTimeMillis();
            // criando uma fila por Round Robin
            Round round = new Round(pedidos);
            tempos.add(round.simularFila(i, timeStart));

            System.out.println("###          GERANDO GRAFICO          ###");
            System.out.println("#########################################");
            System.out.println(" ");
            for (Result resultado : tempos) {
                report.atualizarRelatorioParteDois(resultado);
            }
        }
 
    }
}
