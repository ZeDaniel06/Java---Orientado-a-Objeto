import java.util.Scanner;
public class Programa{
	public static void main(String[] args){
		int menu=99;
		while (menu != 0){
			System.out.println();
			System.out.println("Dados do Estudante:");
			System.out.println();
			Estudante aluno= new Estudante();
			Contato contatos= new Contato();
			Endereco local= new Endereco();
			System.out.println();
			System.out.println("Dados da Disciplina:");
			System.out.println();
			Disciplina materia= new Disciplina();
			System.out.println();
			System.out.println("Notas da Unidade Tematica I:");
			System.out.println();
			UT unidade1= new UT();
			System.out.println();
			System.out.println("Notas da Unidade Tematica II:");
			System.out.println();
			UT unidade2= new UT();
			
			Scanner ler= new Scanner(System.in);
			System.out.print("\n\n1 - CONTINUAR PROGRAMA\n2 - RELATORIO\n0 - SAIR\nESCOLHA: ");
			menu=ler.nextInt();
			if (menu==2){
				System.out.println();
				System.out.println("----------\nRELATORIO DO ALUNO:\n\nInformacoes Pessoais:\n\n");
				aluno.status();
				System.out.println();
				contatos.status();
				System.out.println();
				local.status();
				System.out.println();
				materia.status();
				System.out.println();
				System.out.println("Unidade Tematica I:");
				unidade1.status();
				System.out.println();
				System.out.println("Unidade Tematica II:");
				unidade2.status();
				float media1=unidade1.media();
				float media2=unidade2.media();
				float mediafinal=(media1+media2)/2;
				String resultado=unidade1.aprovacao(mediafinal);
				System.out.println();
				System.out.println("RESULTADO FINAL:\n");
				System.out.println(resultado);
			}
		}
	}
}