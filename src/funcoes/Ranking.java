package funcoes;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import jplay.Window;

public class Ranking {
	
	public void paintPonto(Window pt, ArrayList<String> str){
		int i;
		pt.drawText("Ranking:\n", 350, 25, Color.WHITE);
		for(i = 0; i < str.size(); i++){
			pt.drawText("Pontos: " + str.get(i) + "\n", 280, 40 * i+1, Color.CYAN);
			Font font = new Font("Serif", Font.BOLD, 20);
			pt.setFont(font);
		}
	}
	//Arrays.toString( str.toArray() )
}
