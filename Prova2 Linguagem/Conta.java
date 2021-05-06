import java.util.Scanner;
public class Conta{
	Scanner ler= new Scanner(System.in);
	int agencia;
	int numeroConta;
	float saldo;
	int senha;
	
	public Conta(){
		System.out.println("\n---DADOS DA CONTA---\n");
		System.out.print("Agencia: ");
		this.setAgencia(ler.nextInt());
		System.out.print("Numero da Conta: ");
		this.setNumeroConta(ler.nextInt());
		System.out.print("Saldo: ");
		this.setSaldo(ler.nextFloat());
		System.out.print("Senha para futuros saques: ");
		this.setSenha(ler.nextInt());
	}
	
	public int getAgencia(){
		return this.agencia;
	}
	public void setAgencia(int agencia){
		this.agencia=agencia;
	}

	public int getNumeroConta(){
		return this.numeroConta;
	}
	public void setNumeroConta(int numeroConta){
		this.numeroConta=numeroConta;
	}

	public float getSaldo(){
		return this.saldo;
	}
	public void setSaldo(float saldo){
		this.saldo=saldo;
	}

	public String status(){
		String a="\nAgencia: "+this.agencia+"\nNumero da Conta: "+this.numeroConta+"\nSaldo: "+this.saldo;
		return a;
	}

	public int getSenha(){
		return this.senha;
	}
	public void setSenha(int senha){
		this.senha=senha;
	}
}