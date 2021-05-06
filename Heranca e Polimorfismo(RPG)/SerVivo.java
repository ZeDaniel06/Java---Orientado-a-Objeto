public class SerVivo{
	protected String nome;
	protected int vidaTotal;
	protected int vidaAtual;
	protected int forca;
	protected int defesa;
	protected int nivel;
	protected int exp;

	
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome=nome;
	}

	public int getVidaTotal(){
		return this.vidaTotal;
	}
	public void setVidaTotal(int vidaTotal){
		this.vidaTotal=vidaTotal;
	}

	public int getVidaAtual(){
		return this.vidaAtual;
	}
	public void setVidaAtual(int vidaAtual){
		this.vidaAtual=vidaAtual;
	}

	public int getForca(){
		return this.forca;
	}
	public void setForca(int forca){
		this.forca=forca;
	}

	public int getDefesa(){
		return this.defesa;
	}
	public void setDefesa(int defesa){
		this.defesa=defesa;
	}


	public int getNivel(){
		return this.nivel;
	}
	public void setNivel(int nivel){
		this.nivel=nivel;
	}

	public int getExp(){
		return this.exp;
	}
	public void setExp(int exp){
		this.exp=exp;
	}
}