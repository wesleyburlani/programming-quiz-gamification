package funcoes;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jplay.GameObject;
import jplay.Keyboard;
import jplay.Scene;
import jplay.TileInfo;
import jplay.Window;
import personagem.Personagem;

public class Controle extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Problema pr = new Problema();
	boolean flag1000 = false, flag1001 = false, flag1002 = false, flag1003 = false, flag1004 = false,
			flag1005 = false, flag1006 = false, flag1007 = false, flag1008 = false, flag1009 = false;
	
	public boolean validaProb(String prob, Pontos  p, boolean flag){
		System.out.println("1: " + flag);
		if(flag == false){
			JDialog.setDefaultLookAndFeelDecorated(false);
			String problem = pr.transformString(prob);
			int response = JOptionPane.showConfirmDialog(null, problem, "Problema "+prob+".c",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (response == JOptionPane.NO_OPTION) {
		      System.out.println("No button");
		    } else if (response == JOptionPane.YES_OPTION) {
		      System.out.println("Yes button");
		      String arq = prob;
				new TelaDeCode(arq, p, flag);
		    } else if (response == JOptionPane.CLOSED_OPTION) {
		      System.out.println("closed");
		    }
			
		}
		return flag;
	}
	
	
	public boolean colisao(GameObject obj, TileInfo tile, Window janela, Keyboard teclado, Scene cena, Personagem personagem, Pontos p){			
		
		// Tile 1 home
		if(tile.id == 1  && obj.collided(tile) && teclado.keyDown(Keyboard.ENTER_KEY)){
			String resp = JOptionPane.showInputDialog("printf(\"%d %f %c\");\nQuais os tipo a ser impresso?");
			boolean r = resp.equals("int float char");
			
			if(r){
				JOptionPane.showMessageDialog(null, "Resposta Correta.");
				p.setPontos(1);
			}else{
				JOptionPane.showMessageDialog(null, "Resposta Incorreta.");
			}

		}
		
		// enter home collision 
		if(obj.collided(tile) && teclado.keyDown(Keyboard.ENTER_KEY)){
			switch(tile.id){
			case 24:
				this.flag1000 = validaProb("1000", p, this.flag1000);
				break;
			case 25:
				this.flag1001 = validaProb("1001", p, this.flag1001);
				break;
			case 26:
				this.flag1002 = validaProb("1002", p, this.flag1002);
				break;
			case 27:
				this.flag1003 = validaProb("1003", p, this.flag1003);
				break;
			default:
				break;
			}
		}
		
		//if(tile.id == 24  && obj.collided(tile) && teclado.keyDown(Keyboard.ENTER_KEY))validaProb("1000");
	
		

		// Tile elements collision
		if((tile.id != 3 && tile.id != 16 && tile.id != 20 && tile.id != 0)&& obj.collided(tile))return true;		 
		return false;
	}
}
