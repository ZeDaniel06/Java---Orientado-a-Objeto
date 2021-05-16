import java.util.Random;
import javax.swing.JOptionPane;
public class Monstro extends SerVivo{
	Random random=new Random();
	private int velo;
	public Monstro(Personagem personagem){
		this.nivel=personagem.getNivel();
		this.nome="Monstro Nivel "+this.nivel;
		this.vidaTotal=100+(this.nivel*random.nextInt(30));
		this.vidaAtual=this.vidaTotal;
		this.forca=25+(this.nivel*random.nextInt(15));
		this.defesa=25+(this.nivel*random.nextInt(15));
		this.exp=(int)(this.nivel*random.nextInt(15));
		this.velocidade=10+((int)(this.nivel*random.nextInt(3)));
		this.velo=this.velocidade;
	}
	public void atacar(Personagem personagem){
		this.velocidade=this.velo;
		if (this.vidaAtual<=0){
			return;
		}
		int decisao=random.nextInt(2);
		if (decisao==1){
			boolean acerto=random.nextBoolean();
			if(acerto){
				personagem.setVidaAtual(personagem.getVidaAtual()-(this.forca-((int)(personagem.getDefesa()/2))));
				JOptionPane.showMessageDialog(null,"O Monstro Atacou!");
			}else{
				JOptionPane.showMessageDialog(null,"O Monstro Tentou Te Atacar, mas errou...");
			}
		}else{
			this.velocidade=this.velocidade+7;
			JOptionPane.showMessageDialog(null,"O Monstro Nao Atacou, Mas Ficou Mais Rapido!");
		}
	}
}