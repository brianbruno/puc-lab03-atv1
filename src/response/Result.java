package response;

public class Result {

    private int cell;
    private int row;
    private double dado;
    private double desvioPadrao;
    private int comparacoes;
    private int trocas;
    private String descricao;
    public static final int TAMANHOS[] = { 500000, 600000, 700000, 800000 };

    public Result(int cell, int row, double dado, double desvioPadrao, int comparacoes, String descricao, int tamanhoVetor, int trocas) {
        int somador = 0;
        for(int tam : TAMANHOS) {
            if(tam == tamanhoVetor)
                this.cell = cell + somador;
            else
                somador = somador + 6;
        }
        this.row = row;
        this.dado = dado;
        this.descricao = descricao;
        this.comparacoes = comparacoes;
        this.trocas = trocas;
        this.desvioPadrao = desvioPadrao;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public double getDado() {
        return dado;
    }

    public void setDado(double dado) {
        this.dado = dado;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }

    public int getTrocas() {
        return trocas;
    }

    public void setTrocas(int trocas) {
        this.trocas = trocas;
    }
}
