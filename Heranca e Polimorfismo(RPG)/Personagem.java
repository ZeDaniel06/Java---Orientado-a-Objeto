import java.util.Random;
import java.util.Scanner;
public class Personagem extends SerVivo{
	Scanner ler=new Scanner(System.in);
	Random random=new Random();
	private Inventario inventario=new Inventario();
	private String raca;
	private String classe;
	Item arma= new Item();
	public Personagem(){
		
	}
	public Personagem(String nome, String raca, String classe, int bonus, int extra, Item arma){
		this.nome=nome;
		this.raca=raca;
		this.classe=classe;
		this.nivel=1;
		this.vidaTotal=100+(this.nivel*10)+extra;
		this.vidaAtual=this.vidaTotal;
		this.forca=25+(this.nivel*5)+bonus;
		this.defesa=25+(this.nivel*5)+bonus;
		this.exp=0;
		this.velocidade=10+((int)(this.nivel*2))+extra;
		this.inventario.guardarItem(new Item(1,1,"Pocao +25hp"));
		this.inventario.guardarItem(new Item(1,1,"Pocao +25hp"));
		this.inventario.guardarItem(new Item(1,1,"Pocao +25hp"));
		this.arma=arma;
	}
	
	public Personagem criarPersonagem(){
		System.out.println("\n---Seja Bem Vindo Ao Nosso Mini RPG em Java---\n");
		System.out.println("Para comecar criaremos o seu personagem, informe suas preferencias: ");
		String nome, classe="a", raca="a";
		System.out.println("Nome do Personagem: ");
		nome=ler.nextLine();
		int escolha=4, bonus=0, extra=0;
		while(escolha<1 || escolha>2){
			System.out.println("Raca(Pode ser: 1 - Elfo, 2 - Humano): ");
			escolha=ler.nextInt();
			switch (escolha){
				case 1:
				raca="Elfo";
				bonus=2;
				extra=4;
				break;
				case 2:
				raca="Humano";
				bonus=4;
				extra=2;
				break;
				default:
				System.out.println("Escolha uma opcao valida.");
				break;
			}
		}
		escolha=4;
		Item arma=new Item();
		while(escolha<1 || escolha>2){
			System.out.println("Classe(1 - Guerreiro, 2 - Mago): ");
			escolha=ler.nextInt();
			switch (escolha){
				case 1:
				classe="Guerreiro";
				arma=new Item(5,3,"Espada de Ferro");
				break;
				case 2:
				classe="Mago";
				arma=new Item(6,2,"Cajado Magico");
				break;
				default:
				System.out.println("Escolha uma opcao valida.");
				break;
			}
		}
		Personagem personagem=new Personagem(nome, raca, classe, bonus, extra, arma);
		System.out.println("Personagem Criado!");
		return personagem;
	}
	
	public String getRaca(){
		return this.raca;
	}
	public void setRaca(String raca){
		this.raca=raca;
	}

	public String getClasse(){
		return this.classe;
	}
	public void setClasse(String classe){
		this.classe=classe;
	}
	public void subirNivel(){
		if(this.exp<(this.nivel*this.nivel)){
			System.out.println("Exp insuficiente para subir de nivel...");
		}else{
			this.setExp(this.getExp()-(this.getNivel()*2));
			this.setNivel(this.getNivel()+1);
			this.setForca(25+(this.nivel*5));
			this.setDefesa(25+(this.nivel*5));
			this.setVidaTotal(100+(this.nivel*10));
			this.setVidaAtual(this.getVidaAtual()+50);
			if (this.getVidaAtual()>this.getVidaTotal()){
				this.setVidaAtual(this.getVidaTotal());
			}
			System.out.println("Subiu para o nivel "+this.getNivel());
		}
	}
	public void status(){
		String texto="\n---STATUS---\nNome: "+this.getNome()+"\nRaca: "+this.getRaca()+"\nClasse: "+this.getClasse()+"\nVida Total: "
		+this.getVidaTotal()+"\nVida Atual: "+this.getVidaAtual()+"\nForca: "+this.getForca()+"\nDefesa: "+this.getDefesa()+"\nNivel: "
		+this.getNivel()+"\nArma: "+this.getArma().getNome()+"\nExp: "+this.getExp()+"\n";
		System.out.println(texto);
	}
	
	public void atacar(Monstro monstro){
		boolean acerto=random.nextBoolean();
		if (acerto){
			monstro.setVidaAtual(monstro.getVidaAtual()-(this.forca-((int)(monstro.getDefesa()/2))));
			System.out.println("Voce Atacou o "+monstro.getNome());
			if(monstro.getVidaAtual()<=0){
				System.out.println("\nMonstro Derrotado! "+monstro.getExp()+" EXP adquirido...");
				this.setExp(this.getExp()+monstro.getExp());
				this.subirNivel();
				int item=random.nextInt(3);
				switch (item){
					case 0:
					System.out.println("Parabens, voce ganhou uma pocao +50hp!");
					this.inventario.guardarItem(new Item(2,1,"Pocao +50hp"));
					break;
					case 1:
					System.out.println("Parabens, voce ganhou uma pocao +25hp!");
					this.inventario.guardarItem(new Item(1,1,"Pocao +25hp"));
					break;
					case 2:
					break;
				}
			}
		}else{
			System.out.println("Voce Errou o Ataque!");
		}
	}
	public Inventario getInventario(){
		return this.inventario;
	}
	public void setInventario(Inventario inventario){
		this.inventario=inventario;
	}
	public Item getArma(){
		return this.arma;
	}
	public void setArma(Item arma){
		this.arma=arma;
	}
	
}