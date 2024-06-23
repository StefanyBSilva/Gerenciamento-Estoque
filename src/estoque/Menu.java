package estoque;

import java.util.Scanner;
import programa.produto;
import programa.fornecedor;
import programa.pedido;
import programa.pedido.GerenciadorPedidos;


public class Menu {
	public static void gerenciarProdutos() {
        int op1;
        Scanner ler = new Scanner(System.in);
		produto Produto = new produto(1, null, 0, 0, 0);
		
		
        do {
            produto.menuProdutos();
            op1 = ler.nextInt();
            switch (op1) {
                case 1:
                    produto.addProduto();
                    break;
                case 2:
                    produto.verificarProduto();
                    break;
                case 3:
                    produto.editarProduto();
                    break;
                case 4:
                    produto.removerProduto();
                    break;
                case 5:
                    System.out.println("Retornando ao menu");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (op1 != 5);
    }
	
	public static void gerenciarFornecedores() {
        int op2;
        Scanner ler = new Scanner(System.in);
		fornecedor Fornecedor = new fornecedor(0, null, 0, 0, 0, null);
		
        do {
            fornecedor.menuFornecedor();
            op2 = ler.nextInt();
            switch (op2) {
                case 1:
                    fornecedor.addFornecedor();
                    break;
                case 2:
                    fornecedor.verificarFornecedor();
                    break;
                case 3:
                    fornecedor.editarFornecedor();
                    break;
                case 4:
                    fornecedor.removerFornecedor();
                    break;
                case 5:
                    System.out.println("Retornando ao menu principal");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (op2 != 5);
    }
	
	public static void gerenciadorPedidos() {
		int op3;
		int codigo;
		
		Scanner ler = new Scanner(System.in);
		pedido Pedidos = new pedido(0);
		GerenciadorPedidos gerenciador = new GerenciadorPedido();
		
		do {
			pedido.menuPedido();
			op3 = ler.nextInt();
			switch (op3) {
				case 1:
					gerenciador.inicializarPedido();
					break;
				case 2 :
					gerenciador.listaPedidosAtuais();
					break;
				case 3 : 
					System.out.println("Digite o codigo do pedido:");
					codigo = ler.nextInt();
					gerenciador.Entregue(codigo);
					break;
				case 4:
					gerenciador.listaHistoricoPedidos();
					break;
				case 5:
	                    System.out.println("Retornando ao menu principal");
	                    break;
	            default:
	                    System.out.println("Opção inválida");
	                    break;
			}
		}while (op3 != 5) {
			
		}	
	}
}
