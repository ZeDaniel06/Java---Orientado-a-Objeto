public class Monstro extends SerVivo{
	public Monstro(){
		this.nivel=1;
		this.nome="Monstro Nivel 1";
		this.vidaTotal=95+(this.nivel*10);
		this.vidaAtual=this.vidaTotal;
		this.forca=20+(this.nivel*5);
		this.defesa=20+(this.nivel*5);
		this.exp=(int)(this.nivel*2);
	}
	public Monstro(Personagem personagem){
		this.nivel=personagem.getNivel();
		this.nome="Monstro Nivel "+this.nivel;
		this.vidaTotal=95+(this.nivel*10);
		this.vidaAtual=this.vidaTotal;
		this.forca=20+(this.nivel*5);
		this.defesa=20+(this.nivel*5);
		this.exp=(int)(this.nivel*2);
	}
	public void revidar(Personagem personagem){
		personagem.setVidaAtual(personagem.getVidaAtual()-20);
		System.out.println("O Monstro Revidou!");
	}
}