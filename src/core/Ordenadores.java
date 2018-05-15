package core;

import sort.Sort;

import java.util.ArrayList;
import java.util.HashMap;

public class Ordenadores {

    private ArrayList<HashMap<String, Object>> ordenadores;
    private int tamanho;

    public Ordenadores() {
        ordenadores = new ArrayList<>();
    }

    public void novoOrdenador (Sort ordernador, int tamanho) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ordenador", ordernador);
        map.put("tamanho", tamanho);
        ordenadores.add(map);

    }

    public synchronized HashMap<String, Object> getOrdenador() {
        HashMap<String, Object> ordernador = null;
        if(ordenadores.size() > 0) {
            ordernador = ordenadores.get(0);
            ordenadores.remove(0);
        }
        return ordernador;
    }
}
