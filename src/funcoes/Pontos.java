package funcoes;

import java.awt.Color;
import java.awt.Font;

import jplay.Window;

public class Pontos {
	
	private int pontos = 0;
	
	public void setPontos(int p){
		this.pontos += p;
	}
	
	public int getPontos(){
		return this.pontos;
	}
	
	public void paintPonto(Window pt){
		pt.drawText("Pontos: " + getPontos(), 50, 30, Color.WHITE);
		Font font = new Font("Serif", Font.BOLD, 30);
		pt.setFont(font);
	}

}
