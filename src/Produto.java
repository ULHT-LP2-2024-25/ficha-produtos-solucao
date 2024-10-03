public class Produto {

    String titulo;
    int peso;
    int preco;
    int quantidade;

    public Produto(String titulo, int peso, int preco, int quantidade) {
        this.titulo = titulo;
        this.peso = peso;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return titulo + " " + peso + " " + preco + " " + quantidade;
    }

    int obterStock() {
        return quantidade;
    }

    boolean vender() {
        if (quantidade > 0) {
            quantidade--;
            return true;
        }
        return false;
    }

    void adicionarStock(int quantidadeAdicional) {
        quantidade += quantidadeAdicional;
    }

    int obterValorTotal() {
        return preco * quantidade;
    }

    boolean estaPrestesAEsgotar() {
        return quantidade < 3;
    }

}
