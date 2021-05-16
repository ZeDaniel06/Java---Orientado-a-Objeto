public class Item extends Armazenamento{
	private int codigo;
	private String nome;
	
	public Item(){
		this.codigo=0;
		this.tamanho=0;
		this.nome="Vazio";
	}
	public Item(int codigo, int tamanho, String nome){
		this.codigo=codigo;
		this.tamanho=tamanho;
		this.nome=nome;
	}
	
	public void setTamanho(int tamanho){
		this.tamanho=tamanho;
	}
	public int getCodigo(){
		return this.codigo;
	}
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}

	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome=nome;
	}

}