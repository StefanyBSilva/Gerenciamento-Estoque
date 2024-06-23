package estoque;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import programa.fornecedor;
import programa.produto;


public class pedido {
		private int codigoPedido;
		private Date dataInicial;
		private Date dataEntrega;
		private String status;
		
		public pedido(int codigoPedido) {
			this.codigoPedido = codigoPedido;
			this.dataInicial = new Date();
			this.dataEntrega = new Date();
			this.status = "Inicializar";
 	
		}
		//-------------------------------------------------//
		private int getCodigoPedido() {
			return codigoPedido;
		}
		private int setCodigoPedido(int codigoPedido) {
			this.codigoPedido = codigoPedido;
		}
		//-------------------------------------------------//
		private Date getDataInicial() {
			return dataInicial;
		}
		private Date setDataInicial(Date dataInicial {
			this.dataInicial = dataInicial;
		}
		//-------------------------------------------------//
		private Date getDataEntrega() {
			return dataInicial;
		}
		private Date setDataEntrega(Date dataEntrega) {
			this.dataEntrega = dataEntrega;
		}
		//-------------------------------------------------//
		private String getStatus() {
			return status;
		}
		private void setStatus(String status) {
			this.status = status;
		}
		//-------------------------------------------------//
		
		public static class GerenciadorPedidos{
			private List<pedido> pedidosAtuais;
			private List<pedido> historicoPedidos;
			private int contadorPedidos;
			
			public GerenciadorPedidos() {
				this.pedidosAtuais = new ArrayList<>();
				this.historicoPedidos = new ArrayList<>();
				this.contadorPedidos = 0;
			}
			//INICIALIZAÇÃO DOS PEDIDOS
			public void inicializarPedido() {
				pedido novoPedido = new pedido(++contadorPedido);
				pedidosAtuais.add(novoPedido);
				System.out.println("Pedido inicializado: " + novoPedido.getId());
				produto.addProduto();
				fornecedor.addFornecedor();
			}
			
			public void Entregue(int idPedido) {
	            for (pedido novoPedido : pedidosAtuais) {
	                if (novoPedido.getCodigoPedido() == idPedido) {
	                    novoPedido.setStatus("Entregue");
	                    novoPedido.setDataEntrega(new Date());
	                    historicoPedidos.add(novoPedido);
	                    pedidosAtuais.remove(novoPedido);
	                    System.out.println("Pedido " + idPedido + " marcado como entregue.");
	                    return;
	                }
	            }
	            System.out.println("Pedido " + idPedido + " não encontrado.");
	        }
			
	        public void listaPedidosAtuais() {
	            System.out.println("Pedidos Atuais:");
	            for (pedido novoPedido : pedidosAtuais) {
	                System.out.println("ID: " + novoPedido.getCodigoPedido() + ", Status: " + novoPedido.getStatus() + ", Data de Inicialização: " + novoPedido.getDataInicial());
	            }
	        }
	        
	        public void listaHistoricoPedidos() {
	            System.out.println("Histórico de Pedidos:");
	            for (pedido novoPedido : historicoPedidos) {
	                System.out.println("ID: " + novoPedido.getCodigoPedido() + ", Data de Inicialização: " + novoPedido.getDataInicial() + ", Data de Entrega: " + novoPedido.getDataEntrega());
	            }
	        }
		
		}
		
		public static void menuPedido() {
			System.out.println("---- Menu Pedidos ----");
			System.out.println("1 _ Iniciar Pedido;");
			System.out.println("2 _ Lista de Pedidos em andamento;");
			System.out.println("3 _ Pedidos Entregue;");
			System.out.println("4 _ Historico de Pedidos;");
			System.out.println("5 _ Fechar Programa");
		}
		
		public static void menuPrincipal() {
			System.out.println("---- Menu Principal ----");
			System.out.println("1 _ Área de Produtos;");
			System.out.println("2 _ Área de Fornecedores;");
			System.out.println("3 _ Área de Pedidos;");
			System.out.println("4 _ Fechar Programa");
		}
		public static void menuProdutos() {
			System.out.println("---- Menu Pedidos ----");
			System.out.println("1 _ Adicionar Produto;");
			System.out.println("2 _ Verificar Produto;");
			System.out.println("3 _ Editar Produto;");
			System.out.println("4 _ Remover Produto;");
			System.out.println("5 _ Retorna ao menu principal");
		}

}
