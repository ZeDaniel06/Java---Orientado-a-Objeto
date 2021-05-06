import java.util.ArrayList;
import java.util.Scanner;
public class Rpg{
	
	public static void batalha(Personagem personagem){
		Scanner ler=new Scanner(System.in);
		Monstro monstro= new Monstro(personagem);
		System.out.println("Inimigo Encontrado! "+monstro.getNome());
		while (monstro.getVidaAtual()>=0){
			System.out.println("Ataque o Monstro Apertando Enter!");
			String a=ler.nextLine();
			monstro.setVidaAtual(monstro.getVidaAtual()-20);
			System.out.println("Voce Atacou o "+monstro.getNome());
			System.out.println("Vida Atual do Monstro: "+monstro.getVidaAtual());
			monstro.revidar(personagem);
			System.out.println("Vida Atual do Teu Personagem: "+personagem.getVidaAtual());
			if(monstro.getVidaAtual()<=0){
				System.out.println("Monstro Derrotado! "+monstro.getExp()+" adquirido...");
				personagem.setExp(personagem.getExp()+monstro.getExp());
				personagem.subirNivel();
			}
		}
	}
	
	public static void main(String[] args){
		Scanner ler=new Scanner(System.in);
		System.out.println("");
		int menu=50;
		System.out.println("\n---Seja Bem Vindo Ao Nosso Mini RPG em Java---\n");
		System.out.println("Para comecar criaremos o seu personagem, informe suas preferencias: ");
		String nome, classe, raca;
		System.out.println("Nome do Personagem: ");
		nome=ler.nextLine();
		System.out.println("Raca(Pode ser Elfo, Humano, Draconiano, Orc): ");
		raca=ler.nextLine();
		System.out.println("Classe(Guerreiro, Ladino, Paladino): ");
		classe=ler.nextLine();
		Personagem personagem=new Personagem(nome, raca, classe);
		System.out.println("Personagem Criado!");
		while (menu!=4){
			//Menu geral
			System.out.println("\n---MENU PRINCIPAL---\n");
			System.out.println(personagem.getNome()+", O QUE DESEJA FAZER? ");
			System.out.println("1 - EXIBIR STATUS DO PERSONAGEM\n2 - BATALHAR\n3 - ABRIR INVENTARIO\n4 - SAIR DO JOGO(PROGRESSO NAO SERA SALVO): ");
			menu=ler.nextInt();
			switch (menu){
				case 1:
					personagem.status();
					break;
				case 2:
					batalha(personagem);
					break;
				case 3:{
						//Menu de inventario
						while (menu!=0){
							System.out.println("\n---INVENTARIO---\n1 - GUARDAR ITEM\n2 - DROPAR ITEM\n3 - EXIBIR INVENTARIO\n0 - SAIR");
							menu=ler.nextInt();
							switch (menu){
								case 1:{
									String item;
									int codigo;
									ler.nextLine();
									System.out.println("Nome do Item: ");
									item=ler.nextLine();
									System.out.println("Atribua um numero/codigo a esse item: ");
									codigo=ler.nextInt();
									personagem.inventario.guardarItem(new Item(codigo,1,item));
									System.out.println("Item guardado!");
								}
									break;
								case 2:
									personagem.inventario.droparItem();
									break;
								case 3:
									personagem.inventario.exibirInventario();
									break;
								case 0:
									System.out.println("Saindo...");
									break;
								default:
									System.out.println("Escolha uma opcao valida...");
									break;
							}
						}
				}
				case 4:
					System.out.println("Fechando Jogo...");
					break;
				default:
					System.out.println("Escolha uma opcao valida...");
			}
		}
	}
		//
	}