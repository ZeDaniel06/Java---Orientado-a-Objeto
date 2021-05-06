import java.util.Scanner;
public class Endereco{
	Scanner ler= new Scanner(System.in);
	String rua;
	int numero;
	String bairro;
	String cidade;
	
	public Endereco(){
		System.out.println("\n---ENDERECO DO CLIENTE---\n");
		System.out.print("Rua: ");
		setRua(ler.nextLine());
		System.out.print("Numero: ");
		setNumero(ler.nextInt());
		ler.nextLine();
		System.out.print("Bairro: ");
		setBairro(ler.nextLine());
		System.out.print("Cidade: ");
		setCidade(ler.nextLine());
	}
	
	public String getRua(){
		return this.rua;
	}
	public void setRua(String rua){
		this.rua=rua;
	}

	public int getNumero(){
		return this.numero;
	}
	public void setNumero(int numero){
		this.numero=numero;
	}

	public String getBairro(){
		return this.bairro;
	}
	public void setBairro(String bairro){
		this.bairro=bairro;
	}

	public String getCidade(){
		return this.cidade;
	}
	public void setCidade(String cidade){
		this.cidade=cidade;
	}

	public String status(){
		String a="\nRua: "+this.rua+"\nNumero: "+this.numero+"\nBairro: "+this.bairro+"\nCidade: "+this.cidade;
		return a;
	}
}