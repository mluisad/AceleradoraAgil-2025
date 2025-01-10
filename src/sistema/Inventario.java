package sistema;

import java.util.ArrayList;
import java.util.UUID;

import dados.Produto;

//Classe CRUD para a aplicação, nela está todos os passos para a 
public class Inventario {
    private ArrayList<Produto> inventario;

    public Inventario() {
        inventario = new ArrayList<>();
    }

    /*
     * Adiciona o produto ao inventário, uma lista de produtos que não possuem o
     * mesmo ID.
     * Ao consultarID que a lista não possui o produto passado como parâmetro, irá
     * ser
     * criado um ID único na lista e o produto será adicionado ao inventário.
     */
    public boolean add(Produto produto) {
        if (consultarID(produto.getId()) != null) {
            return false;
        }
        gerarId(produto);
        inventario.add(produto);
        return true;
    }

    /*
     * Consulta a existência do produto na lista inventário.
     * Se houver um produto com o mesmo ID passado como parâmetro, ele irá retornar
     * esse produto, senão, retornará nulo.
     */
    public Produto consultarID(String id) {
        for (Produto produto : inventario) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }

    /*
     * Consulta a existência do produto na lista inventário.
     * Se houver um produto com o mesmo ou com parte do Nome passado como parâmetro,
     * ele irá retornar
     * esse produto, senão, retornará nulo.
     */
    public Produto consultarNome(String nome) {
        for (Produto produto : inventario) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return produto;
            }
        }
        return null;
    }

    // Gera ID a partir da classe UUID do Java. Onde, com o método RandomUUID(), é
    // gerado um identifador único.
    public void gerarId(Produto produto) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        produto.setId(uuid);
    }

    // Lista no terminal todos os produtos adicionados no inventário
    public void listarProdutos() {
        if (!inventario.isEmpty()) {
            for (Produto produto : inventario) {
                System.out.println("\n");
                System.out.println("\nID: " + produto.getId());
                ;
                System.out.println("\nNome: " + produto.getNome());
                System.out.println("\nCategoria: " + produto.getCategoria());
                System.out.println("\nQuantidade em Estoque: " + produto.getQuantidadeEmEstoque());
                System.out.println("\nPreço: " + produto.getPreco());
            }
        } else {
            System.out.println("O inventário está vazio. Adicione um Produto.");
        }
    }

    /*
     * Métodos para atualizar os dados dos produtos
     * No caso de produtos que irão trocar nome ou categoria, é usado um "caso" para
     * saber qual trocar
     * caso o valor seja 1, irá trocar o nome, caso o valor seja 2, irá trocar a
     * categoria
     */
    public boolean atualizarProduto(String variavel, String id, int caso) {
        if (consultarID(id) == null) {
            System.out.println("Nenhum produto com o ID indicadoo.");
            return false;
        }

        switch (caso) {
            case 1:
                consultarID(id).setNome(variavel);
                break;
            case 2:
                consultarID(id).setCategoria(variavel);
            default:
                break;
        }
        return true;
    }

    public boolean atualizarProduto(int quantidadeEmEstoque, String id) {
        if (consultarID(id) == null) {
            System.out.println("Nenhum produto com o ID indicadoo.");
            return false;
        }
        consultarID(id).setQuantidadeEmEstoque(quantidadeEmEstoque);
        return true;
    }

    public boolean atualizarProduto(double preco, String id) {
        if (consultarID(id) == null) {
            System.out.println("Nenhum produto com o ID indicadoo.");
            return false;
        }

        consultarID(id).setPreco(preco);
        return true;
    }

    /* Deleta um produto a partir do seu ID. */
    public boolean deletar(String id) {
        if (consultarID(id) == null) {
            System.out.println("Nenhum produto com o ID indicado.");
            return false;
        }

        inventario.remove(consultarID(id));
        return true;
    }

    // Mostra um produto a partir do seu ID ou Nome.
    public boolean mostrarProduto(String variavel) {
        if (consultarID(variavel) == null && consultarNome(variavel) == null) {
            System.out.println("Nenhum produto com o ID ou nome indicado.");
            return false;
        }

        if (consultarID(variavel) == null) {
            System.out.println("\n ID: " + consultarNome(variavel).getId());
            System.out.println("\n Nome: " + consultarNome(variavel).getNome());
            System.out.println("\n Categoria: " + consultarNome(variavel).getCategoria());
            System.out.println("\n Quantidade em Estoque: " + consultarNome(variavel).getQuantidadeEmEstoque());
            System.out.println("\n Preço : " + consultarNome(variavel).getPreco());
            return true;
        }
        if (consultarNome(variavel) == null) {
            System.out.println("\n ID: " + consultarID(variavel).getId());
            System.out.println("\n Nome: " + consultarID(variavel).getNome());
            System.out.println("\n Categoria: " + consultarID(variavel).getCategoria());
            System.out.println("\n Quantidade em Estoque: " + consultarID(variavel).getQuantidadeEmEstoque());
            System.out.println("\n Preço : " + consultarID(variavel).getPreco());
            return true;
        }
        return true;
    }

}
