package parte2;

import response.Result;

import java.util.Collections;
import java.util.List;

public class OrdemChegada extends Ordenador {

    private List<Pedido> pedidos;

    public OrdemChegada(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Result simularFila() {

        System.out.println("\n################## Atendimento em Ordem de Chegada ##################\n");
        // mostra como a fila ficará
        long timeStart = System.currentTimeMillis();
        exibirFila(pedidos);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;

        return new Result(1, 3, (int) timeTotal);

    }

}
