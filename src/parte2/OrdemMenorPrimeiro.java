package parte2;

import response.Result;

import java.util.Collections;
import java.util.List;

public class OrdemMenorPrimeiro extends Ordenador {

    private List<Pedido> pedidos;

    public OrdemMenorPrimeiro(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        // ordena os pedidos, pois é o menor primeiro. Para isso, o pedido se tornou "Comparable"
        ordenarPedidos(pedidos);
    }

    public Result simularFila() {

        System.out.println("\n################## Atendimento em Ordem de Menor Primeiro ##################\n");
        // mostra como a fila ficará
        long timeStart = System.currentTimeMillis();
        exibirFila(pedidos);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;

        return new Result(1, 2, (int) timeTotal);

    }
}
