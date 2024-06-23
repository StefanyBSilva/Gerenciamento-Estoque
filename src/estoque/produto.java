package estoque;

import java.util.ArrayList;
import java.util.Scanner;

public class produto {
		private int codProduto;
		private String nomeProduto;
		private String valLote;
		private String fabLote;
		private int quantidade;
		
		
		//construtor
		public produto(int codProduto, String nomeProduto, int quantidade,  String valLote, String fabLote) {
		        this.nomeProduto = nomeProduto;
		        this.quantidade = quantidade;
		        this.codProduto = codProduto++;
		        this.valLote = valLote;
		        this.fabLote = fabLote;
		}
		//------------------------------------------------------------------//
		private int getCodProduto(){
			return codProduto;
		}
		private void setCodProduto(int codProduto) {
			this.codProduto = codProduto++;
		}
		//------------------------------------------------------------------//
		public String getNomeProduto() {
			return nomeProduto;
		}
		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}
		//------------------------------------------------------------------//
		public String getValLote() {
			return valLote;
		}	
		public void setValLote(String valLote) {
			this.valLote = valLote;
		}
		//------------------------------------------------------------------//
		public String getFabLote() {
			return fabLote;
		}
		public void setFabLote(String fabLote) {
			this.fabLote = fabLote;
		}
		//------------------------------------------------------------------//
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		
		//------------------------------------------------------------------//
		
		//atributo alternativo para armazenamento
		private ArrayList<produto> listProduto = new ArrayList<>(); 
			
		//get e set para o atributo temporario
		public ArrayList<produto> getListPrudoto(){
			return listProduto;
		}
		public void setListProduto (ArrayList<produto> listProduto) {
			this.listProduto = listProduto;
		}
		
		//-------------------------------------------------------------------//
		//metodos addProduto = adicionar produto
		Scanner ler = new Scanner(System.in);

		public void addProduto() {
			//Scanner ler = new Scanner(System.in);
			codProduto = codProduto ++;
			System.out.print("Código: "+codProduto);
			System.out.println("\nNome do produto:");
			nomeProduto = ler.next();
			System.out.print("Quantidade: ");
			quantidade = ler.nextInt();
			System.out.print("Data de fabricação do lote: ");
			fabLote = ler.next();
			System.out.print("Data de validade do lote: ");
			valLote = ler.next();
			//objeto que sera utilizado para colocar na lista//  
			produto item = new produto(codProduto,nomeProduto,quantidade,fabLote,valLote);
			listProduto.add(item);//adição na lista 
			System.out.println("Produto adicionado com sucesso");
		}
		
		//metodo de exibir a lista de produto
		public void verificarProduto() {
			System.out.println("-----------------------------------");
			System.out.println("Produto: ");
			if(listProduto.isEmpty()) {
				System.out.print("O produto não está cadastrado");
			}else{
				for(produto item:listProduto) {
					System.out.println("Codigo: "+item.getCodProduto()+"| Produto: "+item.getNomeProduto());
					System.out.println("Quantidade: "+item.getQuantidade()+"| Validade: "+item.getValLote());
				}
			}
		}
		
		//metodo de editar um produto
		public void editarProduto() {
			//Scanner ler = new Scanner(System.in);
			System.out.println("Digite o nome do produto para atualiza-lo:");
			String nomeProduto = ler.nextLine();
			ler.nextLine();
			boolean naLista = false;
			for(produto item:listProduto) {
				if(item.getNomeProduto() == nomeProduto) {
					//System.out.println("Codigo:" +produto.getCodProduto);
					System.out.println("Item emcontrado pode editar!");
					System.out.println("Nome do produto: ");
					nomeProduto = ler.nextLine();
					item.setNomeProduto(nomeProduto);
					System.out.println("Quantidade em estoque: ");
					quantidade = ler.nextInt();
					item.setQuantidade(quantidade);
					System.out.println("Validade do lote dos produtos: ");
					valLote= ler.next();
					item.setValLote(valLote);
					System.out.println("Produto atualizado e editado.");
					naLista = true;
				}else {
					System.out.println("Item não encontrado.");
				}
			}		
		}
		//metodo para apagar os dados do produto
		public void removerProduto(){
			//Scanner ler = new Scanner(System.in);
			System.out.println("Digite o nome do produto:");
			String nomeProduto = ler.nextLine();
			boolean removendo = false;
			for (produto item:listProduto) {
				if(item.getNomeProduto() == nomeProduto) {
					listProduto.remove(item);
					removendo = true;
					break;
				}else {
					System.out.println("Produto não encontrado em entoque.");
					
				}
			}
		}
		public static void menuProdutos() {
			System.out.println("=====>>>> Menu Produtos <<<<=====");
			System.out.println("1 _ Adicionar Produto;");
			System.out.println("2 _ Verificar Produto;");
			System.out.println("3 _ Editar Produto;");
			System.out.println("4 _ Remover Produto;");
			System.out.println("5 _ Retorna ao menu principal");
		}
}
