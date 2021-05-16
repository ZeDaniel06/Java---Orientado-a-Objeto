import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
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
		Object[] item= {"Poção +25 hp","Poção +50 hp"};
		int codigo=JOptionPane.showOptionDialog(null, "Qual Item Deseja Usar?", "RPG", 0, 0, null, item, item[0]);
		codigo+=1;
		boolean uso=this.droparItem(codigo);
		if(uso){
			if (codigo==1){
				personagem.setVidaAtual(personagem.getVidaAtual()+25);
				JOptionPane.showMessageDialog(null,"Item usado!");
				if (personagem.getVidaAtual()>personagem.getVidaTotal()){
					personagem.setVidaAtual(personagem.getVidaTotal());
				}
			}else if (codigo==2){
				personagem.setVidaAtual(personagem.getVidaAtual()+50);
				JOptionPane.showMessageDialog(null,"Item usado!");
				if (personagem.getVidaAtual()>personagem.getVidaTotal()){
					personagem.setVidaAtual(personagem.getVidaTotal());
				}
			}
		}else{
			JOptionPane.showMessageDialog(null,"Item nao encontrado no inventario!");
		}
	}
	public void droparItem(){
		String a="";
		for(int i=0;i<this.getTamanho();i++){
			if (this.getEspaco().get(i).getCodigo()!=0){
				a=a+"Nome: "+this.getEspaco().get(i).getNome()+"\nCodigo: "+this.getEspaco().get(i).getCodigo()+"\n";
			}
		}
		JOptionPane.showMessageDialog(null, a);
		int codigo=Integer.parseInt(JOptionPane.showInputDialog("Codigo do item a dropar:"));
		for (int i=0;i<espaco.size();i++){
			if (this.espaco.get(i).getCodigo()==codigo){
				this.espaco.set(i,new Item());
				JOptionPane.showMessageDialog(null,"Item dropado!");
				return;
			}
		}
		JOptionPane.showMessageDialog(null,"Item nao encontrado no inventario!");
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
		int vazio=0;
		String a="---INVENTARIO---\n\n";
		for(int i=0;i<this.getTamanho();i++){
			if (this.getEspaco().get(i).getCodigo()!=0){
				a=a+"Nome: "+this.getEspaco().get(i).getNome()+"\nCodigo: "+this.getEspaco().get(i).getCodigo()+"\n";
			}else{
				vazio+=1;
			}
		}a=a+"\n\n"+"Espaco Total: 32\nEspaco Livre: "+vazio;
		JOptionPane.showMessageDialog(null, a);
	}
	
}