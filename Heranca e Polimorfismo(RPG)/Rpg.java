import javax.swing.JOptionPane;
public class Rpg{
	public static void main(String[] args){
		int menu=50;
		boolean vivo=true;
		Personagem personagem=new Personagem();
		personagem=personagem.criarPersonagem();
		Object[] menuPrincipal= {"STATUS DO PERSONAGEM","BATALHAR","ABRIR INVENTARIO","SUBIR DE NIVEL","SAIR DO JOGO"};
		while (menu!=4){
			if (vivo==false){
				personagem=personagem.criarPersonagem();
			}
			vivo=true;
			//Menu geral
			menu=JOptionPane.showOptionDialog(null, "MENU PRINCIPAL", "RPG", 0, 2, null, menuPrincipal, menuPrincipal[0]);
			switch (menu){
				case 0:
					personagem.status();
					break;
				case 1:
					vivo=batalha(personagem);
					break;
				case 2:{
						//Menu de inventario
					Object[] menuInventario= {"GUARDAR ITEM","DROPAR ITEM","USAR ITEM","EXIBIR INVENTARIO","FECHAR"};
						while (menu!=5){
							menu=JOptionPane.showOptionDialog(null, "---INVENTARIO---", "RPG", 0, 0, null, menuInventario, menuInventario[0])+1;
							switch (menu){
								case 1:{
									String item;
									int codigo;
									item=JOptionPane.showInputDialog("Nome do Item: ");
									codigo=Integer.parseInt(JOptionPane.showInputDialog("Atribua um numero/codigo a esse item: "));
									personagem.getInventario().guardarItem(new Item(codigo,1,item));
									JOptionPane.showMessageDialog(null,"Item guardado!");
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
								case 5:
									JOptionPane.showMessageDialog(null,"Fechando Inventario...");
									break;
								default:
									JOptionPane.showMessageDialog(null,"Saindo do Jogo...");
									System.exit(0);
									break;
							}
						}
				}break;
				case 3:
					personagem.subirNivel();
					break;
				case 4:
					JOptionPane.showMessageDialog(null,"Saindo do jogo...");
					break;
				default:
					JOptionPane.showMessageDialog(null,"Saindo do jogo...");
					break;
			}
		}
	}
		//Metodo de Batalha
		public static boolean batalha(Personagem personagem){
		int decisao;
		Object[] agir= {"Atacar","Usar Item"};
		Monstro monstro= new Monstro(personagem);
		JOptionPane.showMessageDialog(null,"Inimigo Encontrado! "+monstro.getNome());
		while (monstro.getVidaAtual()>0){
			if(personagem.getVidaAtual()<=0){
				JOptionPane.showMessageDialog(null,"Seu personagem morreu lutando bravamente... Reiniciando jogo...");
				return false;
			}
			JOptionPane.showMessageDialog(null,"\nVida Atual do Teu Personagem: "+personagem.getVidaAtual()+"\nVida Atual do Monstro: "+monstro.getVidaAtual());
			decisao=JOptionPane.showOptionDialog(null, "O que fazer?", "RPG", 0, 0, null, agir, agir[0]);
			switch (decisao){
				case 0:
					if(personagem.getVelocidade()>=monstro.getVelocidade()){
						personagem.atacar(monstro);
						monstro.atacar(personagem);
					}else{
						monstro.atacar(personagem);
						personagem.atacar(monstro);
					}
					break;
				case 1:
					personagem.getInventario().usarItem(personagem);
					break;
				default:
					JOptionPane.showMessageDialog(null,"Saindo do jogo...");
					System.exit(0);
					break;
			}
		}
		return true;
	}
	}