import java.util.ArrayList;
import java.util.Scanner;
public class Rpg{
	public static void main(String[] args){
		Scanner ler=new Scanner(System.in);
		int menu=50;
		boolean vivo=true;
		Personagem personagem=new Personagem();
		personagem=personagem.criarPersonagem();
		while (menu!=5){
			if (vivo==false){
				personagem=personagem.criarPersonagem();
			}
			vivo=true;
			//Menu geral
			System.out.println("\n---MENU PRINCIPAL---\n");
			System.out.println(personagem.getNome()+", O QUE DESEJA FAZER? ");
			System.out.println("1 - EXIBIR STATUS DO PERSONAGEM\n2 - BATALHAR\n3 - ABRIR INVENTARIO\n4 - SUBIR DE NIVEL\n5 - SAIR DO JOGO(PROGRESSO NAO SERA SALVO): ");
			menu=ler.nextInt();
			switch (menu){
				case 1:
					personagem.status();
					break;
				case 2:
					vivo=batalha(personagem);
					break;
				case 3:{
						//Menu de inventario
						while (menu!=0){
							System.out.println("\n---INVENTARIO---\n1 - GUARDAR ITEM\n2 - DROPAR ITEM\n3 - USAR ITEM\n4 - EXIBIR INVENTARIO\n0 - SAIR");
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
									personagem.getInventario().guardarItem(new Item(codigo,1,item));
									System.out.println("Item guardado!");
								}
									break;
								case 2:
									personagem.getInventario().droparItem();
									break;
								case 3:
									personagem.getInventario().usarItem(personagem);
									break;
								case 4:
									personagem.getInventario().exibirInventario();
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
					personagem.subirNivel();
					break;
				case 5:
					System.out.println("Saindo do jogo...");
					break;
				default:
					System.out.println("Escolha uma opcao valida...");
					break;
			}
		}
	}
		//Metodo de Batalha
		public static boolean batalha(Personagem personagem){
		Scanner ler=new Scanner(System.in);
		int decisao;
		Monstro monstro= new Monstro(personagem);
		System.out.println("\nInimigo Encontrado! "+monstro.getNome());
		while (monstro.getVidaAtual()>0){
			if(personagem.getVidaAtual()<=0){
				System.out.println("Seu personagem morreu lutando bravamente... Reiniciando jogo...");
				return false;
			}
			System.out.println("\nVida Atual do Teu Personagem: "+personagem.getVidaAtual());
			System.out.println("Vida Atual do Monstro: "+monstro.getVidaAtual());
			System.out.println("\nO que fazer?\n1 - Atacar\n2 - Usar Item\n");
			decisao=ler.nextInt();
			switch (decisao){
				case 1:
					if(personagem.getVelocidade()>=monstro.getVelocidade()){
						personagem.atacar(monstro);
						monstro.atacar(personagem);
					}else{
						monstro.atacar(personagem);
						personagem.atacar(monstro);
					}
					break;
				case 2:
					personagem.getInventario().usarItem(personagem);
					break;
				default:
					System.out.println("Digite uma opcao valida...");
					break;
			}
		}
		return true;
	}
	}