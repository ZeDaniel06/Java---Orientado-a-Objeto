import java.util.Scanner;
import java.util.ArrayList;
public class Banco{
	Scanner ler= new Scanner(System.in);
	ArrayList<Cliente> clientes= new ArrayList<Cliente>();
	
	public void cadastrar(){
		Cliente cliente= new Cliente();
		this.clientes.add(cliente);
	}
	
	public void mostrar(){
		int tam=this.clientes.size();
		System.out.println("\n---LISTA DE CONTAS---\n");
		for (int i=0;i<tam;i++){
			System.out.println("----------");
			System.out.print(this.clientes.get(i).status());
			System.out.print(this.clientes.get(i).conta.status());
			System.out.print(this.clientes.get(i).contato.status());
			System.out.print(this.clientes.get(i).endereco.status());
			System.out.println("\n----------");
		}
	}
	
	public int sacar(){
		if(this.clientes.isEmpty()){
			System.out.println("NAO EXISTE NENHUMA CONTA CADASTRADA NO BANCO, PORTANTO, OPERACAO CANCELADA...");
			return 0;
		}
		float saque;
		int agencia=0, numConta, senha, cliente=0;
		boolean status=false;
		while (status==false && agencia!= 9999){
			System.out.println("\n---LOGIN DA CONTA PARA SAQUE--- ");
			System.out.print("AGENCIA: ");
			agencia=ler.nextInt();
			if (agencia==9999){
					System.out.println("FECHANDO MENU DE SAQUE...");
					return 0;
				}
			System.out.print("NUMERO DA CONTA: ");
			numConta=ler.nextInt();
			int tam=this.clientes.size();
			for (int i=0;i<tam;i++){
				if (agencia==this.clientes.get(i).conta.agencia){
					if (numConta==this.clientes.get(i).conta.numeroConta){
						cliente=i;
						System.out.print("CONTA ENCONTRADA! AGORA DIGITE A SENHA: ");
						senha=ler.nextInt();
						if (senha==this.clientes.get(i).conta.senha){
							System.out.println("LOGADO COM SUCESSO! ");
							status=true;
							break;
						}else{
							System.out.println("SENHA INCORRETA, TENTE NOVAMENTE. ");
						}
					}
				}
			}if (status==false && agencia!= 9999){
				System.out.println("FALHA NO LOGIN, TENTE NOVAMENTE.\nSE QUISER DESISTIR DO SAQUE, DIGITE 9999 NA AGENCIA.");
			}
		}
		status=false;
		while(status==false){
			System.out.print("\nSALDO ATUAL: "+this.clientes.get(cliente).conta.getSaldo()+"\nQUAL O VALOR DO SAQUE? ");
			saque=ler.nextFloat();
			if (saque<=this.clientes.get(cliente).conta.getSaldo()){
				this.clientes.get(cliente).conta.setSaldo(this.clientes.get(cliente).conta.getSaldo()-saque);
				System.out.println("SAQUE REALIZADO!\nNOVO SALDO: "+this.clientes.get(cliente).conta.getSaldo());
				status=true;
			}else{System.out.println("SALDO INSUFICIENTE, TENTE NOVAMENTE. ");}
		}
		return 1;
	}
	
	public int depositar(){
		if(this.clientes.isEmpty()){
			System.out.println("NAO EXISTE NENHUMA CONTA CADASTRADA NO BANCO, PORTANTO, OPERACAO CANCELADA...");
			return 0;
		}
		float deposito;
		int agencia=0, numConta, cliente=0;
		boolean status=false;
		while (status==false && agencia!= 9999 && this.clientes!=null){
			System.out.println("\n---DADOS DA CONTA PARA DEPOSITO--- ");
			System.out.print("AGENCIA: ");
			agencia=ler.nextInt();
			if (agencia==9999){
					System.out.println("FECHANDO MENU DE SAQUE...");
					return 0;
				}
			System.out.print("NUMERO DA CONTA: ");
			numConta=ler.nextInt();
			int tam=this.clientes.size();
			for (int i=0;i<tam;i++){
				if (agencia==this.clientes.get(i).conta.agencia){
					if (numConta==this.clientes.get(i).conta.numeroConta){
						cliente=i;
						System.out.print("CONTA ENCONTRADA!");
						status=true;
						break;
						}
					}
				}
				if (status==false && agencia!=9999){
				System.out.println("CONTA NAO ENCONTRADA, TENTE NOVAMENTE.\nSE QUISER DESISTIR DO DEPOSITO, DIGITE 9999 NA AGENCIA. ");
				}if (agencia==9999){
					System.out.println("FECHANDO MENU DE DEPOSITO...");
					return 0;
				}
			}
		System.out.print("\nQUAL O VALOR DO DEPOSITO? ");
		deposito=ler.nextFloat();
		this.clientes.get(cliente).conta.setSaldo(this.clientes.get(cliente).conta.getSaldo()+deposito);
		System.out.println("DEPOSITO REALIZADO!");
		return 1;
	}
	
}