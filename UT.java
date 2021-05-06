import java.util.Scanner;
public class UT{
	float nota1;
	float nota2;
	Scanner ler= new Scanner(System.in);
	public UT(){
		System.out.print("Nota1: ");
		this.nota1=ler.nextFloat();
		System.out.print("Nota2: ");
		this.nota2=ler.nextFloat();
		ler.nextLine();
	}
	public void status(){
		System.out.println("Nota1: " + this.nota1);
		System.out.println("Nota2: " + this.nota2);
	}
	
	public float media(){
		return (this.nota1 + this.nota2) / 2;
	}
	public String aprovacao(float m){
		if (m >= 5 && m <7){
			return "Prova Final";
		}else if (m >= 7){
			return "Aprovado";
		}else{
			return "Reprovado";
		}
	}
}