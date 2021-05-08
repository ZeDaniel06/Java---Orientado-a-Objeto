import java.util.ArrayList;
import java.util.Scanner;
public class Inventario extends Armazenamento{
	private ArrayList<Item> espaco= new ArrayList<Item>();
	Scanner ler=new Scanner(System.in);
	public Inventario(){
		this.setTamanho();
		this.setEspaco();
	}
	public ArrayList<Item> getEspaco(){
		return this.espaco;
	}
	public void setEspaco(){
		for (int i=0;i<this.getTamanho();i++){
			this.espaco.add(new Item());
		}
	}
	public void guardarItem(Item item){
		for (int i=0;i<espaco.size();i++){
			if (this.espaco.get(i).tamanho==0){
				espaco.set(i,item);
				return;
			}
		}
	}
	public void usarItem(Personagem personagem){
		for(int i=0;i<this.getTamanho();i++){
			if (this.getEspaco().get(i).getCodigo()!=0){
				System.out.println("Nome: "+this.getEspaco().get(i).getNome()+"\nCodigo: "+this.getEspaco().get(i).getCodigo());
			}
		}
		System.out.println("Codigo do item que deseja usar? ");
		int codigo=ler.nextInt();
		boolean uso=this.droparItem(codigo);
		if(uso){
			if (codigo==1){
				personagem.setVidaAtual(personagem.getVidaAtual()+25);
				System.out.println("Item usado!");
				if (personagem.getVidaAtual()>personagem.getVidaTotal()){
					personagem.setVidaAtual(personagem.getVidaTotal());
				}
			}else if (codigo==2){
				personagem.setVidaAtual(personagem.getVidaAtual()+50);
				System.out.println("Item usado!");
				if (personagem.getVidaAtual()>personagem.getVidaTotal()){
					personagem.setVidaAtual(personagem.getVidaTotal());
				}
			}
		}else{
			System.out.println("Item nao encontrado no inventario!");
		}
	}
	public void droparItem(){
		System.out.println("Codigo do item a dropar: ");
		int codigo=ler.nextInt();
		for (int i=0;i<espaco.size();i++){
			if (this.espaco.get(i).getCodigo()==codigo){
				this.espaco.set(i,new Item());
				System.out.println("Item dropado!");
				return;
			}
		}
		System.out.println("Item nao encontrado no inventario!");
	}
	public boolean droparItem(int codigo){
		for (int i=0;i<espaco.size();i++){
			if (this.espaco.get(i).getCodigo()==codigo){
				this.espaco.set(i,new Item());
				return true;
			}
		}
		return false;
	}
	public void setTamanho(){
		this.tamanho=32;
	}
	
	public void exibirInventario(){
		System.out.println("\n---INVENTARIO---\n-------");
		for (int i=0;i<this.espaco.size();i++){
			System.out.println("NOME: "+this.espaco.get(i).getNome()+"\nCODIGO: "+this.espaco.get(i).getCodigo()+"\nTAMANHO: "+this.espaco.get(i).tamanho+"\n-------\n");
		}
	}
	
}