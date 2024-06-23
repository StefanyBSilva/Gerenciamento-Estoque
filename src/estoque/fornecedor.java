package estoque;


import java.util.ArrayList;
import java.util.Scanner;

public class fornecedor {
	//Atributos
    private int codigo;
    private String nomeFornecedor;
    private double cnpjCpf;
    private double telFixo;
    private double telCel;
    private String endereco;
    private boolean origemProduto;
    private boolean status;

    public fornecedor(int codigo, String nomeFornecedor, double cnpjCpf, double telFixo, double telCel, String endereco/*, boolean origemProduto, boolean status*/) {
        this.codigo = codigo;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpjCpf = cnpjCpf;
        this.telFixo = telFixo;
        this.telCel = telCel;
        this.endereco = endereco;
        /*this.origemProduto = origemProduto;
        this.status = status;*/
    }
    //------------------------------------------------------------------//
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    //------------------------------------------------------------------//
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }
    //------------------------------------------------------------------//
    public double getCnpjCpf() {
        return cnpjCpf;
    }
    public void setCnpjCpf(double cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }
    //------------------------------------------------------------------//
    public double getTelFixo() {
        return telFixo;
    }
    public void setTelFixo(double telFixo) {
        this.telFixo = telFixo;
    }
    //------------------------------------------------------------------//
    public double getTelCel() {
        return telCel;
    }
    public void setTelCel(double telCel) {
        this.telCel = telCel;
    }
    //------------------------------------------------------------------//
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    //------------------------------------------------------------------//
    public boolean isOrigemProduto() {
        return origemProduto;
    }
    public void setOrigemProduto(boolean origemProduto) {
        this.origemProduto = origemProduto;
    }
    //------------------------------------------------------------------//
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }   
    //------------------------------------------------------------------//
    //atributo alternativo para armazenar os dados
    private ArrayList<fornecedor> listFornecedor = new ArrayList<>();
     //get e set para os atributos temporario
    public ArrayList<fornecedor> getListFornecedor(){
    	return listFornecedor;
    }
    //------------------------------------------------------------------//
	
    //metodos addFornecedor = adicionar Fornecedor;
	Scanner ler = new Scanner(System.in);
    
    public void addFornecedor( ) {
    	//Scanner ler = new Scanner(System.in);
    	
    	codigo = codigo++;
    	
    	System.out.println("Código: "+codigo);
    	System.out.println("Nome do Fornecedor: ");
    	nomeFornecedor = ler.nextLine();
    	System.out.println("CNPJ ou CPF:");
    	cnpjCpf = ler.nextDouble();
    	System.out.println("Se o fornecedor só tenha um dos meios de contato preencha com 0 o que não tiver");
    	System.out.println("Telefone Fixo:");
    	telFixo = ler.nextDouble();
    	System.out.println("Telefone Celular");
    	telCel = ler.nextDouble();
    	System.out.println("Endereço: ");
    	endereco = ler.nextLine();
    	origemFornecedor();
    	statusFornecedor();
    	
    	//objeto que sera colocado na lista 
    	fornecedor pessoa = new fornecedor(codigo,nomeFornecedor,cnpjCpf,telFixo,telCel,endereco);
    	//adicionando na lista
    	listFornecedor.add(pessoa);
    	System.out.println("Fornecedor adicionado com Sucesso.");
    }
    //------------------------------------------------------------------//
    //metodo para exibir o fornecedores que busca
	public void verificarFornecedor() {
		System.out.println("-----------------------------------");
		System.out.println("Fornecedor: ");
		if(listFornecedor.isEmpty()) {
			System.out.print("O produto não está cadastrado");
		}else{
			for(fornecedor pessoa:listFornecedor) {
				System.out.println("Codigo: "+pessoa.getCodigo()+"| Fornecedor: "+pessoa.getNomeFornecedor());
				System.out.println("CNPJ ou CPF: "+pessoa.getCnpjCpf()+"| Contato: "+pessoa.getTelFixo()+"ou"+pessoa.getTelCel());
				System.out.println("Endereço: "+pessoa.getEndereco());
			}
		}
	}
	//metodo de editar um produto
	public void editarFornecedor() {
		//Scanner ler = new Scanner(System.in);
		System.out.println("Digite o nome do Fornedor para atualiza-lo ou editar:");
		String nomeFornecedor = ler.nextLine();
		ler.nextLine();
		boolean naLista = false;
		for(fornecedor pessoa:listFornecedor) {
			if(pessoa.getNomeFornecedor() == nomeFornecedor) {
				//System.out.println("Codigo:" +produto.getCodProduto);
				System.out.println("Fornecedor encontrado pode editar!");
				System.out.println("Nome do Fornecedor: ");
				nomeFornecedor = ler.nextLine();
				pessoa.setNomeFornecedor(nomeFornecedor);
				System.out.println("CNPJ ou CPF: ");
				cnpjCpf = ler.nextInt();
				pessoa.setCnpjCpf(cnpjCpf);
				System.out.println("Telefone Fixo Obs.caso não tenha preencha com 0: ");
				telFixo= ler.nextInt();
				pessoa.setTelFixo(telFixo);
				System.out.println("Telefone Celular Obs.caso não tenha preencha com 0: ");
				telCel= ler.nextInt();
				pessoa.setTelCel(telCel);
				System.out.println("Telefone Fixo Obs.caso não tenha preencha com 0: ");
				endereco= ler.nextLine();
				pessoa.setEndereco(endereco);
		    	
				origemFornecedor();
		    	statusFornecedor();

				System.out.println("Fornecedor atualizado e editado.");
				naLista = true;
			}else {
				System.out.println("Item não encontrado.");
			}
		}		
	}

	//metodo para apagar os dados do produto
	public void removerFornecedor(){
		//Scanner ler = new Scanner(System.in);
		System.out.println("Digite o nome do produto: ");
		String nomeFornecedor = ler.nextLine();
		boolean removendo = false;
		for (fornecedor pessoa:listFornecedor) {
			if(pessoa.getNomeFornecedor() == nomeFornecedor) {
				listFornecedor.remove(pessoa);
				removendo = true;
				break;
			}else {
				System.out.println("Produto não encontrado em estoque.");
			}
		}
	}
	//metodo para saber a origem do produto
	
	private void origemFornecedor() {
		origemProduto = false;//para nacional
		//Scanner ler = new Scanner(System.in());
		System.out.println("1 -> Fornecedor Nacional.");
		System.out.println("2 -> Fornecedor Internacional.");
		System.out.println("Digite a opção: ");
		int op = ler.nextInt();
		switch (op) {
			case 1:
				origemProduto = false;
				System.out.println("Nacional");
				break;
			case 2:
				origemProduto =true;
				System.out.println("Internacional");
				break;
			default:
				System.out.println("Opção invalida");
	            break;
		}
	}
	private void statusFornecedor() {
		status = false;
		System.out.println("1 -> Empresa Ativa.");
		System.out.println("2 -> Empresa Inativa.");
		System.out.println("Digite a opção: ");
		int op = ler.nextInt();
		switch (op) {
			case 1:   
				status = true;
				System.out.println("Empresa está ativa!");
				break;
			case 2:
				status = false;
				System.out.println("Empresa está inativa!");
				break;
			default :
				System.out.println("Opção inválida!");
				break;
		}
	}
	
	public void menuFornecedor() {
		System.out.println("====>>> Menu Fornecedor <<<====");
		System.out.println("1 _ Adicionar Fornecedor;");
		System.out.println("2 _ Verificar Fornecedor;");
		System.out.println("3 _ Editar Fornecedor;");
		System.out.println("4 _ Remover Fornecedor;");
		System.out.println("5 _ Retorna ao menu principal");
	}

}
