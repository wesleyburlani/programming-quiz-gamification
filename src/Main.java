
import java.io.File;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import cenario.*;
import dbConnect.DBConnect;
import funcoes.Ranking;
import jplay.*;

public class Main {
		
	public static void main(String[] args){
		
		//-- Variáveis da classe Principal
		
		GameImage plano = new GameImage("img/imagemInicial001.png");
		GameImage planoTutorial01 = new GameImage("img/Move_controles.png");
		GameImage planoTutorial02 = new GameImage("img/Controles_fase.png");
		GameImage planoRanking = new GameImage("img/fundoG.jpg");
		Window janela = new Window(800,600);
		Keyboard teclado = janela.getKeyboard();
		String arq = "100";
		int flag = 0, cont=2;
		DBConnect connect = new DBConnect();
		

		for(int i = 0; i < 10; i++){
			File file = new File("/home/eduardo-motta/workspace/FinalWorkProg1/prob/"+arq+ i + ".out");
			file.delete();
			System.out.println(file);
		}
		
		//-- Início da laço infinito.
		
		while(true){
			
			if(flag < 1){
				plano.draw();
				janela.update();
			}
			
			//-- Desenho do tutorial.
			
			if(teclado.keyDown(Keyboard.SPACE_KEY) && flag == 0){
				while(cont>0){
					if(cont==2)planoTutorial01.draw();
					else planoTutorial02.draw();
					cont--;
					++flag;
					janela.update();
					try {
						Thread.currentThread();
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
			}
			
			//-- Chamada do Banco para a pontuação.

			if(teclado.keyDown(Keyboard.UP_KEY) && flag == 0){
				janela.update();
				planoRanking.draw();
				Ranking rk = new Ranking();
				try {
					rk.paintPonto(janela, connect.getSelect());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connect.closeConnect();
				flag = 3;
				janela.update();
			}
			
			
			if(teclado.keyDown(Keyboard.DOWN_KEY) && flag == 0){
				JOptionPane.showInputDialog("Username:");
				new Cenario(janela);
				flag = 1;
			}
			
			if(flag == 3 && teclado.keyDown(Keyboard.ESCAPE_KEY)){
				planoTutorial01.draw();
				janela.update();
				flag = 0;
			}
			
			if(teclado.keyDown(Keyboard.ESCAPE_KEY) && flag == 0){
				JDialog.setDefaultLookAndFeelDecorated(false);
				int response = JOptionPane.showConfirmDialog(null, "Sair do Jogo?", "Exit",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    
			    if (response == JOptionPane.NO_OPTION) {
			      System.out.println("No button");
			    } else if (response == JOptionPane.YES_OPTION) {
			      System.out.println("Yes button");
			      System.exit(0);
			    } else if (response == JOptionPane.CLOSED_OPTION) {
			      System.out.println("closed");
			    }
			}
			if(teclado.keyDown(Keyboard.ENTER_KEY) || flag == 2){
				new Cenario(janela);
				flag = 1;
			}
		}
	}
}