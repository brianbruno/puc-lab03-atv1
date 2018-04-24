package response;

public class Result {

    private int cell;
    private int row;
    private int dado;
    private int comparacoes;
    private String descricao;
    public static final int TAMANHOS[] = { 1000000, 10000000 };

    public Result(int cell, int row, int dado, int comparacoes, String descricao, int tamanhoVetor) {
        int somador = 0;
        for(int tam : TAMANHOS) {
            if(tam == tamanhoVetor)
                this.cell = cell + somador;
            else
                somador = somador + 2;
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

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
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
}
