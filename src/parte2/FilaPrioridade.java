package parte2;

import response.Result;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilaPrioridade extends Ordenador{
    private static List<Pedido> listaProntos = new ArrayList<Pedido>();

    public FilaPrioridade(List<Pedido> pedido) {
        System.out.println("###  Fila de Prioridade - INICIANDO   ###");
        preparaListaProntos(pedido);
    }


    private void preparaListaProntos(List<Pedido> pedido) {
        List<Pedido> p = new ArrayList<Pedido>(pedido);
        int maior = 0;
        int pivo = 0;

        Comparator<Pedido> comparator = Pedido::compareToFilaPrioridade;
        p.sort(comparator);

        Collections.reverse(p);
        listaProntos = p;


        /*while(p.size() > 1) {
            pivo = 0;
            for(int i = 1; i < p.size(); i++) {
                if(p.get(pivo).getPreco() >= p.get(i).getPreco())
                    maior = pivo;
                else {
                    pivo = i;
                    maior = i;
                }
            }
            listaProntos.add(p.remove(maior));
        }*/

        if(p.size() == 1) {
            listaProntos.add(p.remove(0));
        }
    }


    public Result simularFila(int i, long timeStart) {
        //System.out.println("\n################## Atendimento em Fila de Prioridade ##################\n");
        // mostra como a fila ficará
        exibirFila(listaProntos);
        long timeEnd = System.currentTimeMillis();
        long timeTotal = timeEnd - timeStart;

        return new Result(1+i, 2, (int) timeTotal);

    }



}