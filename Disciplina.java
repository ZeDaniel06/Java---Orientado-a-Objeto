import java.util.Scanner;
public class Disciplina{
	String nome;
	String professor;
	int sala;
	String turno;
	Scanner ler= new Scanner(System.in);
	public Disciplina(){
		System.out.print("Nome: ");
		this.nome=ler.nextLine();
		System.out.print("Professor: ");
		this.professor=ler.nextLine();
		System.out.print("Sala: ");
		this.sala=ler.nextInt();
		System.out.print("Turno: ");
		ler.nextLine();
		this.turno=ler.nextLine();
	}
	public void status(){
		System.out.println("Nome: " + this.nome);
		System.out.println("Professor: " + this.professor);
		System.out.println("Sala: " + this.sala);
		System.out.println("Turno: " + this.turno);
	}
}