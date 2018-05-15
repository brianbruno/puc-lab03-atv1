package response;

public class Result {

    private int cell;
    private int row;
    private double dado;
    private double desvioPadrao;
    private int comparacoes;
    private String descricao;
    public static final int TAMANHOS[] = { 10000, 11000 };

    public Result(int cell, int row, double dado, double desvioPadrao, int comparacoes, String descricao, int tamanhoVetor) {
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
}
