package response;

public class Result {

    private int cell;
    private int row;
    private int dado;
    private String descricao;
    public static final int TAMANHOS[] = { 1000000, 10000000 };

    public Result(int cell, int row, int dado, String descricao, int tamanhoVetor) {
        int somador = 0;
        for(int tam : TAMANHOS) {
            if(tam == tamanhoVetor)
                this.cell = cell + somador;
            else
                somador++;
        }
        this.row = row;
        this.dado = dado;
        this.descricao = descricao;
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
}
