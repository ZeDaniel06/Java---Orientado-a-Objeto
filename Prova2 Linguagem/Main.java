import java.util.ArrayList;
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner ler= new Scanner(System.in);
		Banco bc= new Banco();
		String a;  // Apenas para dar uma pausa no programa, permitindo o usuário ler antes de prosseguir.
		int menu=99;
		
		while(menu != 0){
			System.out.println("\n---MENU PRINCIPAL---\n");
			System.out.println("1 - NOVO CADASTRO\n2 - MOSTRAR CONTAS EXISTENTES");
			System.out.println("3 - REALIZAR SAQUE\n4 - REALIZAR DEPOSITO\n0 - SAIR");
			menu= ler.nextInt();
			switch (menu){
				case 1:
				bc.cadastrar();
				break;
				case 2:
				bc. mostrar();
				break;
				case 3:
				bc.sacar();
				break;
				case 4:
				bc.depositar();
				break;
				case 0:
				System.out.println("ENCERRANDO PROGRAMA...");
				break;
				default:
				System.out.println("VALOR INVALIDO, ESCOLHA UMA DAS OPCOES.");
				break;
			}
		}
		
	}
}