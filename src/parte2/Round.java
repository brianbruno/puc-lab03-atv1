package parte2;

import response.Result;

import java.util.ArrayList;
import java.util.List;



public class Round extends Ordenador{

	private static final double QUANTUM = 1;
    private static List<Pedido> listaProntos = new ArrayList<Pedido>();
    private static List<Pedido> listaFinal = new ArrayList<Pedido>();

    public Round(List<Pedido> pedidos) {
        preparaListaProntos(pedidos);
        // enquanto houver pedidos na lista de prontos
        while (!listaProntos.isEmpty()) {
            Pedido p = listaProntos.remove(0);
            //Verifica se o pedido da vez possui tempo restante maior que o QUANTUM
    		//Caso contr�rio o resto do tempo � pego e o pedido finalizado
            if (p.getDuracaoRestante() > QUANTUM) {
                p.setDuracaoRestante(p.getDuracaoRestante() - QUANTUM);
                //preparaListaProntos(pedidos);
                // adiciona o pedido no final da lista, pois n�o foi finalizado
                listaProntos.add(p);
            }else {
            	listaProntos.remove(p);
            	listaFinal.add(p);
            }
        }
    }
    
    //Prepara a lista de prontos de acordo com o tempo de chegada
    private void preparaListaProntos(List<Pedido> pedidos) {
    	for (Pedido p : pedidos) {
				if(!listaProntos.contains(p)) {
					for (Pedido processo : pedidos) {
						listaProntos.add(processo);
					}
				}
		}
	}
  
    public Result simularFila() {

        System.out.println("\n################## Atendimento em Round Robin ##################\n");
        long timeStart = System.currentTimeMillis();
        exibirFila(listaFinal);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;

        return new Result (1, 4, (int) timeTotal);

    }
}

