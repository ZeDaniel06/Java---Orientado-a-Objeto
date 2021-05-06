import java.util.Scanner;
public class Contato{
	String celular;
	String email;
	Scanner ler= new Scanner(System.in);
	public Contato(){
		System.out.print("Celular: ");
		this.celular=ler.nextLine();
		System.out.print("Email: ");
		this.email=ler.nextLine();
	}
	public void status(){
		System.out.println("Celular: " + this.celular);
		System.out.println("Email: " + this.email);
	}
}