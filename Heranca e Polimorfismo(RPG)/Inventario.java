import java.util.ArrayList;
import java.util.Scanner;
public class Inventario extends Armazenamento{
	public ArrayList<Item> espaco= new ArrayList<Item>();
	Scanner ler=new Scanner(System.in);
	public Inventario(){
		this.setTamanho();
		this.setEspaco();
	}
	public int getEspaco(){
		return this.espaco.size();
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
	public void droparItem(){
		System.out.println("Codigo do item a dropar: ");
		int codigo=ler.nextInt();
		for (int i=0;i<espaco.size();i++){
			if (this.espaco.get(i).codigo==codigo){
				this.espaco.set(i,new Item());
				System.out.println("Item dropado!");
				return;
			}
		}
	}
	public void setTamanho(){
		this.tamanho=32;
	}
	
	public void exibirInventario(){
		System.out.println("\n---INVENTARIO---\n-------");
		for (int i=0;i<this.espaco.size();i++){
			System.out.println("NOME: "+this.espaco.get(i).nome+"\nCODIGO: "+this.espaco.get(i).codigo+"\nTAMANHO: "+this.espaco.get(i).tamanho+"\n-------\n");
		}
	}
	
}