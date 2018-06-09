package code;

class Dados {

    private String palavra;
    private int soma;
    private boolean primo;

    Dados() {
    }

    String formatarResultado() {
        return palavra + " " + (primo ? "é" : "não é") + " uma palavra prima";
    }

    String getPalavra() {
        return palavra;
    }

    void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    int getSoma() {
        return soma;
    }

    void setSoma(int soma) {
        this.soma = soma;
    }

    void setPrimo(boolean primo) {
        this.primo = primo;
    }
}