package code;

class App {

    /**
     * <p>Executa todos os processos de cálculos.</p>
     *
     * @param palavra Palavra fornecida para verificação.
     * @param dados Objeto de dados para ser iniciado.
     */
    void iniciarDados(String palavra, Dados dados) {
        dados.setPalavra(palavra);
        dados.setSoma(somar(dados.getPalavra()));
        dados.setPrimo(determinarPrimo(dados.getSoma()));
    }

    /**
     * <p>Verifica se determinado número é primo.</p>
     *
     * @param numero Número a ser verificado.
     * @return Booleano relativo se é ou não primo.
     */
    private boolean determinarPrimo(int numero) {
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
     * <p>Realiza a soma aplicando as regras do desafio.</p>
     * <p>Letras minúsculas [1-26]</p>
     * <p>Letras maiúsculas [27-52]</p>
     *
     * @param palavra Palavra a ser processada.
     * @return Soma da palavra.
     */
    private int somar(String palavra) {
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