import control.*;
import model.*;

import view.ProdutoView;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Produto[] produtos = new Produto[10];

    public static void main(String[] args) throws Exception {

        ProdutoController produtoController = new ProdutoController();
        MarcaController marcaController = new MarcaController();
        ProdutoView vProduto = new ProdutoView();

        init(produtoController, marcaController);
        menuPrincipal(produtoController, marcaController, vProduto);
    }

    public static void init(ProdutoController pController, MarcaController mController) {
        Marca marca = Marca.getInstance("Minas Mais");
        mController.add(marca);
        Produto produto = Produto.getInstance("Arroz", 28.50f, marca, 500);
        inserir(pController, produto);
        produto = Produto.getInstance("Feijão", 11, marca, 2500);
        inserir(pController, produto);
        produto = Produto.getInstance("Macarrão", 8.70f, marca, 1000);
        inserir(pController, produto);
        produto = Produto.getInstance("Suco 1L", 7.99f, marca, 550);
        inserir(pController, produto);
        produto = Produto.getInstance("Café", 13.5f, marca, 1200);
        inserir(pController, produto);
    }

    public static void menuPrincipal(ProdutoController pController, MarcaController mController, ProdutoView vProduto) {
        int escolha;
        do {
            System.out.println("\n\n");
            System.out.println("---------- MENU PRINCIPAL -----------");
            System.out.println();
            System.out.println("1 - Inserir produtos");
            System.out.println("2 - Excluir produto");
            System.out.println("3 - Alterar produto");
            System.out.println();
            System.out.println("------------- LISTAGENS -------------");
            System.out.println();
            System.out.println("4 - Ver detalhes de um produto");
            System.out.println("5 - Ver produtos cadastrados");
            System.out.println("6 - Ver produtos em ordem alfabética");
            System.out.println("7 - Encerrar o programa");
            System.out.println();
            System.out.println("-------------------------------------");
            System.out.println();
            System.out.print("Opção desejada: ");
            escolha = scanner.nextInt();
        } while (escolha > 7 || escolha < 1);

        System.out.println();

        switch (escolha) {
            case 1:
                Produto produto = vProduto.lerProduto();
                if (inserir(pController, produto))
                    System.out.println("Produto inserido!");
                else
                    System.out.println("Falha ao inserir!");

                break;

            case 2:
                if (excluir(pController))
                    System.out.println("Produto excluído!");
                else
                    System.out.println("Falha ao excluir!");
                break;

            case 3:
                if (alterar(pController, mController, vProduto))
                    System.out.println("Produto alterado!");
                else
                    System.out.println("Falha ao alterar!");
                break;

            case 4:
                buscarProduto(pController, vProduto);
                break;

            case 5:
                listarTodos(vProduto);
                break;

            case 6:
                listarOrdenados(vProduto);
                break;

            default:
                return;
        }
        scanner.nextLine();
        menuPrincipal(pController, mController, vProduto);
    }

    private static boolean inserir(ProdutoController pController, Produto produto) {
        if (produto != null)
            if (pController.add(produto, produtos))
                return true;

        return false;
    }

    private static boolean excluir(ProdutoController pController) {
        System.out.print("Informe o código do produto a ser excluído: ");
        int idProduto = scanner.nextInt();

        if (pController.delete(idProduto, produtos))
            return true;

        return false;
    }

    private static void buscarProduto(ProdutoController pController, ProdutoView vProduto) {
        System.out.print("Informe o código do produto a ser exibido: ");
        int idProduto = scanner.nextInt();
        Produto produto = pController.findById(idProduto, produtos);

        if (produto != null)
            vProduto.show(produto);
        else
            System.out.println("Falha ao exibir!");
    }

    private static void listarTodos(ProdutoView vProduto) {
        vProduto.showAll(produtos);
    }

    private static void listarOrdenados(ProdutoView vProduto) {
        vProduto.showAllInOrder(produtos);
    }

    private static boolean alterar(ProdutoController pController, MarcaController mController, ProdutoView vProduto) {
        System.out.print("Informe o código do produto a ser alterado: ");
        int idProduto = scanner.nextInt();
        Produto produto = pController.findById(idProduto, produtos);

        if (produto != null) {
            vProduto.show(produto);
            int escolha;
            do {
                System.out.println("\n\n");
                System.out.println("---------- MENU DE ALTERAR ----------");
                System.out.println();
                System.out.println("1 - NOME");
                System.out.println("2 - PREÇO");
                System.out.println("3 - MARCA");
                System.out.println("4 - ESTOQUE");
                System.out.println("5 - Retornar ao MENU PRINCIPAL");
                System.out.println();
                System.out.println("-------------------------------------");
                System.out.println();
                System.out.print("Opção desejada: ");
                escolha = scanner.nextInt();
            } while (escolha > 6 || escolha < 1);

            System.out.println();

            switch (escolha) {
                case 1:
                    System.out.print("Nome do produto: ");
                    scanner.nextLine();
                    produto.setNome(scanner.next());
                    break;

                case 2:
                    System.out.print("Preço do produto: ");
                    scanner.nextLine();
                    produto.setPreco(scanner.nextFloat());
                    break;

                case 3:
                    System.out.print("Marca do produto: ");
                    scanner.nextLine();
                    String texto = scanner.next();
                    Marca marca = mController.verificarMarca(texto);
                    if (marca != null)
                        produto.setMarca(marca);
                    else {
                        marca = Marca.getInstance(texto);
                        mController.add(marca);
                        produto.setMarca(marca);
                    }
                    break;

                case 4:
                    System.out.print("Quantidade em estoque: ");
                    scanner.nextLine();
                    produto.setNome(scanner.next());
                    break;

                default:
                    menuPrincipal(pController, mController, vProduto);

            }

            if (pController.update(idProduto, produto, produtos))
                return true;
        }
        return false;
    }

}
