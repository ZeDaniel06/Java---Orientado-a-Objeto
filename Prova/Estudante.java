import java.util.Scanner;
public class Estudante{
	String nome;
	int idade;
	String sexo;
	Scanner ler= new Scanner(System.in);
	public Estudante(){
		System.out.print("Nome: ");
		this.nome=ler.nextLine();
		System.out.print("Idade: ");
		this.idade=ler.nextInt();
		ler.nextLine();
		System.out.print("Sexo: ");
		this.sexo=ler.nextLine();
	}
	public void status(){
		System.out.println("Nome: " + this.nome);
		System.out.println("Idade: " + this.idade);
		System.out.println("Sexo: " + this.sexo);
	}
}