package code;

import java.util.Scanner;

@SuppressWarnings({"unused", "WeakerAccess"})
class Operacoes {

    /**
     * <p>Verifica se determinado número é primo.</p>
     *
     * @param numero Número a ser verificado.
     * @return Booleano relativo se é ou não primo.
     */
    public boolean determinarPrimo(int numero) {
        boolean primo = true;

        for (int i = 2; i < numero; ++i) {
            if (numero % i == 0) {
                primo = false;
                break;
            }
        }

        return primo;
    }

    /**
     * <p>Detecta o sistema operacional e limpa a tela do terminal.</p>
     */
    public void limparTela() {
        String comando = null;

        String so = System.getProperty("os.name").toLowerCase();
        if (so.contains("linux")) {
            comando = "clear";
        } else if (so.contains("windows")) {
            comando = "cls";
        }

        if (comando != null) {
            try {
                new ProcessBuilder(comando).inheritIO().start().waitFor();
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }

    /**
     * <p>Pega uma palavra pelo terminal.</p>
     *
     * @return Palavra digitada sem espaços.
     */
    public String getPalavra() {
        limparTela();
        System.out.print("=-= =-= =-= =-= =-= =-= =-= =-= =-= =-= \n" +
                "Desafio das Palavras Primas \n" +
                "=-= =-= =-= =-= =-= =-= =-= =-= =-= =-= \n\n" +
                "Digite a palavra: ");
        return new Scanner(System.in).next().split(" ")[0];
    }

    /**
     * <p>Exibe o resultado de forma amigável.</p>
     *
     * @param dados Objeto com as informações.
     */
    public void mostrarResultado(Dados dados) {
        System.out.println("\n\n\n" +
                "=-= =-= =-= =-= =-= =-= =-= =-= =-= =-= \n"
                + dados.getPalavra() + " " + (dados.isPrimo() ? "é" : "não é") + " uma palavra prima. \n" +
                "=-= =-= =-= =-= =-= =-= =-= =-= =-= =-= \n\n");
    }

    /**
     * <p>Realiza a soma aplicando as regras do desafio.</p>
     * <p>Letras minúsculas [1-26]</p>
     * <p>Letras maiúsculas [27-52]</p>
     *
     * @param palavra Palavra a ser processada.
     * @return Soma da palavra.
     */
    public int somar(String palavra) {
        int soma = 0;
        int letra;

        for (char c : palavra.toCharArray()) {
            letra = (int) c;

            if (letra >= 65 && letra <= 90) { // Letras maiúsculas
                letra -= 38;
            } else if (letra >= 97 && letra <= 122) { // Letras minúsculas
                letra -= 96;
            }

            soma += letra;
        }

        return soma;
    }
}
