package estoque;
	
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import programa.fornecedor;
import programa.pedido;
import programa.produto;
import programa.Menu;
import pedido.GerenciadorPedidos;
import java.util.List;


public class programa {
	
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		
		ArrayList<String> ListFornecedor = new ArrayList();
		ArrayList<String> ListPedido = new ArrayList();
		ArrayList<String> ListProduto = new ArrayList();
		
		fornecedor Fornecedor = new fornecedor(1, null, 0, 0, 0, null);
		produto Produto = new produto(1, null, 0.0, null, null);
		pedido Pedido = new pedido(0);
		Menu menus = new Menu();
		
		int op;
		
		do {
            pedido.menuPrincipal();
            op = ler.nextInt();
            switch (op) {
                case 1:
                    menus.gerenciarProdutos();
                    break;
                case 2:
                    menus.gerenciarFornecedores();
                    break;
                case 3:
                	menus.gerenciadorPedidos();
                    break;
                case 4:
                    System.out.println("Encerrando programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (op != 4);{
        	
        }
	}

}

