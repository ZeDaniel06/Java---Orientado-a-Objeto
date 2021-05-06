import java.util.Scanner;
public class Endereco{
	String pais;
	String uf;
	String cidade;
	String bairro;
	String rua;
	Scanner ler= new Scanner(System.in);
	public Endereco(){
		System.out.print("Pais: ");
		this.pais=ler.nextLine();
		System.out.print("UF: ");
		this.uf=ler.nextLine();
		System.out.print("Cidade: ");
		this.cidade=ler.nextLine();
		System.out.print("Bairro: ");
		this.bairro=ler.nextLine();
		System.out.print("Rua: ");
		this.rua=ler.nextLine();
	}
	public void status(){
		System.out.println("Pais: " + this.pais);
		System.out.println("UF: " + this.uf);
		System.out.println("Cidade: " + this.cidade);
		System.out.println("Bairro: " + this.bairro);
		System.out.println("Rua: " + this.rua);
	}
}