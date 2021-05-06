import java.util.Scanner;
public class Cliente{
	Scanner ler= new Scanner(System.in);
	String nome;
	int idade;
	String sexo;
	String cpf;
	Conta conta= new Conta();
	Endereco endereco= new Endereco();
	Contato contato= new Contato();
	
	public Cliente(){
		System.out.println("\n---DADOS DO CLIENTE---\n");
		System.out.print("Nome: ");
		this.setNome(ler.nextLine());
		System.out.print("Idade: ");
		this.setIdade(ler.nextInt());
		ler.nextLine();
		System.out.print("Sexo: ");
		this.setSexo(ler.nextLine());
		System.out.print("CPF: ");
		this.setCpf(ler.nextLine());
	}
	
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome=nome;
	}

	public int getIdade(){
		return this.idade;
	}
	public void setIdade(int idade){
		this.idade=idade;
	}

	public String getSexo(){
		return this.sexo;
	}
	public void setSexo(String sexo){
		this.sexo=sexo;
	}

	public String getCpf(){
		return this.cpf;
	}
	public void setCpf(String cpf){
		this.cpf=cpf;
	}

	public String status(){
		String a="Nome: "+this.nome+"\nIdade: "+this.idade+"\nSexo: "+this.sexo+"\nCPF: "+this.cpf;
		return a;
	}
}