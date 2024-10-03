import java.util.ArrayList;
import java.util.HashMap;

public class Loja {

    String codigo;
    ArrayList<Produto> produtos;

    public Loja(String codigo) {
        this.codigo = codigo;
        this.produtos = new ArrayList<>();
    }

    boolean adicionarProduto(Produto produto) {

        // verificar se já existe um produto com este título
        // uso uma função auxiliar para fazer esta pesquisa
        // esta função não era obrigatória, serve apenas para organizar
        // melhor o código
        Produto produtoLoja = procurarProduto(produto.titulo);
        if (produtoLoja != null) {
            return false;
        }

        // se não existir o produto, tenho que o adicionar à loja
        produtos.add(produto);
        return true;
    }

    boolean existeProduto(String titulo) {
        return procurarProduto(titulo) != null;
    }

    ArrayList<String> obterTitulosProdutos() {
        ArrayList<String> titulosDosProdutos = new ArrayList<>();

        for (Produto produto : produtos) {
            titulosDosProdutos.add(produto.titulo);
        }

        return titulosDosProdutos;
    }

    ArrayList<String> obterInformacaoProdutos() {
        ArrayList<String> informacaoProdutos = new ArrayList<>();

        for (Produto produto : produtos) {
            informacaoProdutos.add(produto.toString());
        }

        return informacaoProdutos;
    }

    int obterNrProdutos() {
        // uma vez que não existem produtos repetidos na lista de produtos
        // (o adicionarProduto() garante isso), basta ver o tamanho da lista
        return produtos.size();
    }

    int obterStock(String titulo) {
        Produto produto = this.procurarProduto(titulo);
        if (produto == null) {
            return 0;
        }

        return produto.obterStock();
    }

    boolean venderProduto(String titulo) {
        Produto produto = this.procurarProduto(titulo);
        if (produto == null) {
            return false;
        }

        return produto.vender();
    }

    void adicionarStock(String titulo, int quantidade) {
        Produto produto = this.procurarProduto(titulo);
        produto.adicionarStock(quantidade);
    }

    long obterValorTotalProdutos() {

        long valorTotal = 0;

        for (Produto produto : produtos) {
            valorTotal += produto.obterValorTotal();
        }

        return valorTotal;
    }

    HashMap<String, Integer> obterProdutosPrestesEsgotar() {

        // vou criar um HashMap em que a chave é o título do produto
        // e o valor é a quantidade desse produto
        // apenas produtos que estejam prestes a esgotar são considerados
        HashMap<String, Integer> produtosComFaltaDeStock = new HashMap<>();

        for (Produto produto : produtos) {
            if (produto.estaPrestesAEsgotar()) {
                produtosComFaltaDeStock.put(produto.titulo, produto.quantidade);
            }
        }

        return produtosComFaltaDeStock;
    }

    Produto procurarProduto(String titulo) {
        for (Produto produto : this.produtos) {
            if (produto.titulo.equals(titulo)) {
                return produto;
            }
        }

        return null;
    }

}
