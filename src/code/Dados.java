package code;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Dados {

    private String palavra;
    private int soma;
    private boolean primo;

    public Dados() {
    }

    public Dados(String palavra, int soma, boolean primo) {

        this.palavra = palavra;
        this.soma = soma;
        this.primo = primo;
    }

    public String getPalavra() {

        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getSoma() {
        return soma;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }

    public boolean isPrimo() {
        return primo;
    }

    public void setPrimo(boolean primo) {
        this.primo = primo;
    }
}