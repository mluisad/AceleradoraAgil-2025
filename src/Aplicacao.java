import sistema.Inventario;

import java.io.IOException;
import java.util.Scanner;

import dados.Produto;

public class Aplicacao {
    Inventario inventario;
    Scanner scanner = new Scanner(System.in);

    public Aplicacao() {
        inventario = new Inventario();
    }

    public void executar() {
        menuInicial();
    }

    public void menuInicial() {
        System.out.println("\n~s~s~s~s~s~s~s~s~s~s~s~s~s~s~s~s~s~");
        System.out.println("Painel de Gerenciamento de Produtos");
        System.out.println("~s~s~s~s~s~s~s~s~s~s~s~s~s~s~s~s~s~");
        System.out.println("Digite o número da opção escolhida");
        System.out.println("1- Adicionar Produto.");
        System.out.println("2- Listar Produtos.");
        System.out.println("3- Atualizar Produto.");
        System.out.println("4- Excluir Produto.");
        System.out.println("5- Buscar Produto.");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                adicionarProduto();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                atualizarProduto();
                break;
            case 4:
                excluirProduto();
                break;
            case 5:
                buscarProduto();
            default:
                menuInicial();
                break;
        }
    }

    public void adicionarProduto() {
        scanner.nextLine();
        try {
            System.out.println("\n Adicionando novo produto ao inventário");
            System.out.println("Digite o nome:");
            String nome = scanner.nextLine();
            System.out.println("Digite a categoria:");
            String categoria = scanner.nextLine();
            System.out.println("Digite a quantidade em estoque:");
            int quantidadeEmEstoque = scanner.nextInt();
            System.out.println("Digite o preço:");
            double preco = scanner.nextDouble();
            Produto produto = new Produto(nome, categoria, quantidadeEmEstoque, preco);
            inventario.add(produto);
        } catch (Exception e) {
            System.out.println("Uma exceção foi encontrada. Por favor preencha os dados corretamente.");
            adicionarProduto();
        } finally {
            menuInicial();
        }
    }

    public void listarProdutos() {
        scanner.nextLine();
        try {
            inventario.listarProdutos();
        } catch (Exception e) {
            System.out.println("Uma exceção foi encontrada.");
            menuInicial();
        } finally {
            menuInicial();
        }
    }

    public void atualizarProduto() {
        scanner.nextLine();
        try {
            System.out.println("\n Atualizando dados de Produto");
            System.out.println("Digite o ID do produto que será atualizado:");
            String id = scanner.nextLine();
            System.out.println("Digite a opção do dado que deseja atualizar:");
            System.out.println("1- Nome.");
            System.out.println("2- Categoria.");
            System.out.println("3- Quantidade em estoque.");
            System.out.println("4- Preço.");
            int opcao = scanner.nextInt();
            System.out.println("Digite o dado atualizado: ");
            String dado = scanner.nextLine();
            switch (opcao) {
                case 1:
                    inventario.atualizarProduto(dado, id, 1);
                    System.out.println("Atualização realizada.");
                    break;
                case 2: 
                    inventario.atualizarProduto(dado, id, 2);
                    System.out.println("Atualização realizada.");
                    break;
                case 3: 
                    int qtd = Integer.parseInt(dado);
                    inventario.atualizarProduto(qtd, id);
                    System.out.println("Atualização realizada.");
                    break;
                case 4: 
                    double preco = Double.parseDouble(dado);
                    inventario.atualizarProduto(preco, id);
                    System.out.println("Atualização realizada.");
                    break;
                    
            default: break;
            }
        }
    }

    public void excluirProduto() {
        scanner.nextLine();
        try {
            System.out.println("\n Atualizando dados de Produto");
            System.out.println("Digite o ID do produto que será excluído:");
            String id = scanner.nextLine();
            System.out.println("Confirmar exclusão de produto:");
            System.out.println("Produto a ser excluído: \n");
            System.out.println("1- Excluir   |    2- Cancelar");
            inventario.mostrarProduto(id);
            String opcao = scanner.nextLine();
            if (opcao == "1") {
                inventario.deletar(id);
                System.out.println("Produto excluído.");
            }
        } catch (Exception e) {
            System.out.println("Uma exceção foi encontrada.");
            menuInicial();
        } finally {
            menuInicial();
        }
    }

    public void buscarProduto() {

    }

}
