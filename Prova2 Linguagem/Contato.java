import java.util.Scanner;
public class Contato{
	Scanner ler= new Scanner(System.in);
	String email;
	String telefone;
	String celular;
	
	public Contato(){
		System.out.println("\n---CONTATOS DO CLIENTE---\n");
		System.out.print("Email: ");
		setEmail(ler.nextLine());
		System.out.print("Telefone: ");
		setTelefone(ler.nextLine());
		System.out.print("Celular: ");
		setCelular(ler.nextLine());
	}
	
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email=email;
	}

	public String getTelefone(){
		return this.telefone;
	}
	public void setTelefone(String telefone){
		this.telefone=telefone;
	}

	public String getCelular(){
		return this.celular;
	}
	public void setCelular(String celular){
		this.celular=celular;
	}

	public String status(){
		String a="\nEmail: "+this.email+"\nTelefone: "+this.telefone+"\nCelular: "+this.celular;
		return a;
	}
}