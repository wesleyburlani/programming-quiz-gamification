package cenario;

import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import dbConnect.DBConnect;
import funcoes.*;
import personagem.*;
import jplay.*;

public class Cenario {
	
	private Window janela;
	private Scene cena;
	private Personagem personagem;
	private Keyboard teclado;
	
	
	public Cenario(Window window){
		janela =  window;
		cena =  new Scene();
		cena.loadFromFile("secenes/cena1.scn");	
		personagem = new Personagem(96,520); 		
		teclado = janela.getKeyboard();					
		run();											
	}
	
	Pontos p = new Pontos();
	DBConnect connect = new DBConnect();
	
	private void run(){	
		
		while(true){
			personagem.mover(janela, teclado);
			personagem.caminho(cena, janela, teclado, this.p);
			cena.moveScene(personagem);
			
			p.paintPonto(janela);
			
			personagem.x += cena.getXOffset();
			personagem.y += cena.getYOffset();
			personagem.draw();
			
			if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
				JDialog.setDefaultLookAndFeelDecorated(false);
			    int response = JOptionPane.showConfirmDialog(null, "Sair do Jogo?", "Exit",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    
			    if (response == JOptionPane.NO_OPTION) {
			      System.out.println("No button");
			    } else if (response == JOptionPane.YES_OPTION) {
			      System.out.println("Yes button");
			      int salveResponse = JOptionPane.showConfirmDialog(null, "Salvar Pontuação?", "Exit",
					        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    
					    if (salveResponse == JOptionPane.NO_OPTION) {
					      System.out.println("No button");
					      System.exit(0);
					    } else if (salveResponse == JOptionPane.YES_OPTION) {
					      System.out.println("Yes button");
					      String name = JOptionPane.showInputDialog("Username:");
					      System.out.println(name);
					      try {
							connect.insertData(name, p.getPontos());
							connect.closeConnect();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					      System.exit(0);
					    } else if (salveResponse == JOptionPane.CLOSED_OPTION) {
					      System.out.println("closed");
					      System.exit(0);
					    }
			      System.exit(0);
			    } else if (response == JOptionPane.CLOSED_OPTION) {
			      System.out.println("closed");
			    }
			}
			janela.update();
		}
	}
}

