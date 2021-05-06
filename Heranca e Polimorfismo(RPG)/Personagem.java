public class Personagem extends SerVivo{
	public Inventario inventario=new Inventario();
	public String raca;
	public String classe;
	public Personagem(){
		this.nome="Jogador";
		this.raca="Humano";
		this.classe="Guerreiro";
		this.nivel=1;
		this.vidaTotal=100+(this.nivel*10);
		this.vidaAtual=this.vidaTotal;
		this.forca=25+(this.nivel*5);
		this.defesa=25+(this.nivel*5);
		this.exp=0;
	}
	public Personagem(String nome, String raca, String classe){
		this.nome=nome;
		this.raca=raca;
		this.classe=classe;
		this.nivel=1;
		this.vidaTotal=100+(this.nivel*10);
		this.vidaAtual=this.vidaTotal;
		this.forca=25+(this.nivel*5);
		this.defesa=25+(this.nivel*5);
		this.exp=0;
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
		if(this.exp<(this.nivel*2)){
			System.out.println("Exp insuficiente para subir de nivel...");
		}else{
			this.setExp(this.getExp()-(this.getNivel()*2));
			this.setNivel(this.getNivel()+1);
			this.setForca(25+(this.nivel*5));
			this.setDefesa(25+(this.nivel*5));
			this.setVidaTotal(100+(this.nivel*10));
			this.setVidaAtual(this.getVidaTotal());
			System.out.println("Subiu para o nivel "+this.getNivel());
		}
	}
	public void status(){
		String texto="\n---STATUS---\nNome: "+this.getNome()+"\nRaca: "+this.getRaca()+"\nClasse: "+this.getClasse()+"\nVida Total: "
		+this.getVidaTotal()+"\nVida Atual: "+this.getVidaAtual()+"\nForca: "+this.getForca()+"\nDefesa: "+this.getDefesa()+"\nNivel: "
		+this.getNivel()+"\nExp: "+this.getExp()+"\n";
		System.out.println(texto);
	}
	
	public void atacar(Monstro monstro){
		this.setVidaAtual(getVidaAtual()-20);
		System.out.println("Voce Atacou o "+monstro.getNome());
		if(monstro.getVidaAtual()<=0){
			System.out.println("Monstro Derrotado! "+monstro.getExp()+" adquirido...");
			this.setExp(this.getExp()+monstro.getExp());
		} 
	}
	
}