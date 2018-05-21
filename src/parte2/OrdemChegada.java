package parte2;

import response.Result;

import java.util.Collections;
import java.util.List;

public class OrdemChegada extends Ordenador {

    private List<Pedido> pedidos;

    public OrdemChegada(List<Pedido> pedidos) {
        System.out.println("###   Ordem de Chegada - INICIANDO    ###");
        this.pedidos = pedidos;
    }

    public Result simularFila(int i, long timeStart) {

        //System.out.println("\n################## Atendimento em Ordem de Chegada ##################\n");
        // mostra como a fila ficará
        exibirFila(pedidos);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;

        return new Result(1+i, 4, (int) timeTotal);

    }

}
