package response;

public class AlgorithmsResult {

    double media;
    double desvioPadrao;
    int trocas;

    public AlgorithmsResult(double media, double desvioPadrao, int trocas) {
        this.media = media;
        this.desvioPadrao = desvioPadrao;
        this.trocas = trocas;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
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
