package response;

public class AlgorithmsResult {

    double media;
    double desvioPadrao;

    public AlgorithmsResult(double media, double desvioPadrao) {
        this.media = media;
        this.desvioPadrao = desvioPadrao;
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
}
