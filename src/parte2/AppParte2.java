package parte2;

import file.Report;
import response.Result;

import java.util.ArrayList;
import java.util.List;

public class AppParte2 {
    public static void main(String[] args) {
    	
    	Arquivo arquivo = new Arquivo();
    	Report report = new Report();
    	ArrayList<Result> tempos = new ArrayList<>();
    	
        System.out.println("Simulador de lavanderia");

       // gravando no arquivo
        List<Pedido> pedidos = new ArrayList<>();

        for (int i=0;i<arquivo.lerTotal();i++) {
        	String[] pedido= arquivo.lerLinha().split(";");
            pedido[2] = pedido[2].replace(",",".");
            Pedido px = new Pedido(pedido[0],Double.parseDouble(pedido[1]),0,Double.parseDouble(pedido[2]));
           
        	pedidos.add(px);
        }
        
    

        //criando uma fila de prioridade 
        FilaPrioridade fp = new FilaPrioridade(pedidos);
        tempos.add(fp.simularFila());
        
        // criando uma fila de menor primeiro
        OrdemMenorPrimeiro menorPrimeiro = new OrdemMenorPrimeiro(pedidos);
        tempos.add(menorPrimeiro.simularFila());
        
        // criando uma fila por ordem de chegada
        OrdemChegada fifo = new OrdemChegada(pedidos);
        tempos.add(fifo.simularFila());
        
        // criando uma fila por Round Robin
        Round round = new Round(pedidos);
        tempos.add(round.simularFila());
        System.out.println("####### SALVANDO NO ARQUIVO #######");
        for (Result resultado : tempos) {
            report.atualizarRelatorioParteDois(resultado);
        }

 
    }
}
