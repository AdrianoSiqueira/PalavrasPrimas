package code;

public class Principal {
    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes();

        Dados dados = new Dados();
        dados.setPalavra(operacoes.getPalavra());
        dados.setSoma(operacoes.somar(dados.getPalavra()));
        dados.setPrimo(operacoes.determinarPrimo(dados.getSoma()));

        operacoes.mostrarResultado(dados);
    }
}
