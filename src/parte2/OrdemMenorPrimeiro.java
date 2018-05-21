package parte2;

import response.Result;

import java.util.Collections;
import java.util.List;

public class OrdemMenorPrimeiro extends Ordenador {

    private List<Pedido> pedidos;

    public OrdemMenorPrimeiro(List<Pedido> pedidos) {
        System.out.println("###    Menor Primeiro - INICIANDO     ###");
        this.pedidos = pedidos;
        // ordena os pedidos, pois é o menor primeiro. Para isso, o pedido se tornou "Comparable"
        ordenarPedidos(pedidos);
    }

    public Result simularFila(int i, long timeStart) {

        //System.out.println("\n################## Atendimento em Ordem de Menor Primeiro ##################\n");
        // mostra como a fila ficará
        exibirFila(pedidos);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;

        return new Result(1+i, 3, (int) timeTotal);

    }
}
