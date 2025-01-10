package dados;

public class Produto {
    private String id, nome, categoria;
    private int quantidadeEmEstoque;
    private double preco;

    // Construtor do objeto da classe Produto.java.
    public Produto(String nome, String categoria, int quantidadeEmEstoque, double preco) {
        this.id = "1";
        this.nome = nome;
        this.categoria = categoria;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.preco = preco;
    }

    // Modifica o ID do objeto. É usado durante a adição do objeto na lista de
    // objetos, na classe Inventario.java.
    public void setId(String id) {
        this.id = id;
    }

    // Setters para modificar o Nome, Categoria, Quantidade em estoque e preços dos
    // produtos
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Getters para retornar o ID, Nome, Categoria, Quantidade em estoque e preço
    // dos produtos
    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getQuantidadeEmEstoque() {
        return this.quantidadeEmEstoque;
    }

    // Retorna o preço do objeto Produto
    public double getPreco() {
        return this.preco;
    }
}
