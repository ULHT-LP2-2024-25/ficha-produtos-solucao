import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    // variável global que vai guardar as lojas da aplicação
    // chave = nome da loja; valor = objeto Loja associado
    // o resto da informação é guardada diretamente dentro da Loja ou do Produto
    static HashMap<String, Loja> lojas = new HashMap<>();

    static boolean adicionarProduto(String codigo, String titulo, int peso, int preco, int quantidadeInicial) {

        Loja loja = lojas.get(codigo);

        // se ainda não existe a loja, crio uma e adicionado ao hashmap de lojas
        if (loja == null) {
            loja = new Loja(codigo);
            lojas.put(codigo, loja);
        }

        // se já existe o produto, não adiciono
        if (loja.existeProduto(titulo)) {
            return false;
        }

        return loja.adicionarProduto(new Produto(titulo, peso, preco, quantidadeInicial));
    }

    static ArrayList<String> obterTitulosProdutos(String codigo) {

        Loja loja = lojas.get(codigo);
        if (loja == null) {
            return new ArrayList<>();
        }

        return loja.obterTitulosProdutos();
    }

    static ArrayList<String> obterInformacaoProdutos(String codigo) {

        Loja loja = lojas.get(codigo);
        if (loja == null) {
            return new ArrayList<>();
        }

        return loja.obterInformacaoProdutos();
    }

    static int obterNrProdutos(String codigo) {

        Loja loja = lojas.get(codigo);

        // caso não existe a loja, devemos retornar zero
        if (loja == null) {
            return 0;
        }

        return loja.obterNrProdutos();
    }

    static int obterStock(String codigo, String titulo) {

        Loja loja = lojas.get(codigo);

        // caso não existe a loja, devemos retornar zero
        if (loja == null) {
            return 0;
        }

        return loja.obterStock(titulo);
    }


    static boolean venderProduto(String codigo, String titulo) {

        // obtenho uma referência para o produto pretendido
        // como é uma referência, se atualizar este produto, estou também
        // a atualizar o produto que está na lista de produtos da loja

        Loja loja = lojas.get(codigo);

        // caso não existe a loja, devemos retornar false
        // a venda não foi efetuada
        if (loja == null) {
            return false;
        }

        return loja.venderProduto(titulo);

    }

    static void adicionarStock(String codigo, String titulo, int quantidadeAAdicionar) {

        Loja loja = lojas.get(codigo);

        // caso não existe a loja, não devemos fazer mais nada

        if (loja == null) {
            return;
        }

        loja.adicionarStock(titulo, quantidadeAAdicionar);
    }

    static long obterValorTotalProdutos(String codigo) {

        Loja loja = lojas.get(codigo);
        if (loja == null) {
            return 0;
        }

        return loja.obterValorTotalProdutos();
    }


    static HashMap<String, Integer> obterProdutosPrestesEsgotar(String codigo) {

        Loja loja = lojas.get(codigo);
        if (loja == null) {
            return new HashMap<>();
        }

        return loja.obterProdutosPrestesEsgotar();
    }

    static int obterStockTotal(String titulo) {

        int total = 0;

        // percorro todas as lojas do hashmap
        for (Loja loja : lojas.values()) {

            // para cada loja, obtenho o stock do produto
            total += loja.obterStock(titulo);
        }

        return total;
    }

    static void reiniciarCadeia() {
        // a única variável global é a variável lojas
        lojas = new HashMap<>();
    }

    public static void main(String[] args) {

        adicionarProduto("LIS01", "Nestum", 1000, 220, 50);
        adicionarProduto("", "Chocapic", 750, 270, 40);
        adicionarProduto("LIS01", "Nestum", 1000, 220, 30);

        System.out.println("nrProdutos: " + obterNrProdutos("LIS01"));
        System.out.println("stock: " + obterStock("LIS01", "Nestum"));

    }

}
