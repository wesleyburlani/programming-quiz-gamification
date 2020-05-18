package personagem;
import java.awt.Point;
import java.util.Vector;

import funcoes.*;
import jplay.*;

public class Personagem extends Sprite{
	
	public double velocidade = 1;
	private int direcao = 3;
	private boolean movendo = false;
	Controle controle = new Controle();
	Mensagens mensagem = new Mensagens();
		
	//--Constructor 
	public Personagem(int x, int y){							
		super ("img/Personagem/personagemNG32.png", 20);	
		this.x = x;	this.y = y;this.setTotalDuration(2000);	
	}
	
	//--Character Moves
	public void mover(Window janela, Keyboard teclado){			
		if(teclado.keyDown(Keyboard.LEFT_KEY)){
			if(this.x > 0)
				this.x-=velocidade;
			if(direcao != 1){
				setSequence(4,8);
				direcao=1;
			}
			movendo=true;
		}else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
			if(this.x < janela.getWidth()+janela.getWidth())
				this.x+=velocidade;
			if(direcao != 2){
				setSequence(8,12);
				direcao=2;
			}
			movendo=true;
		}else if(teclado.keyDown(Keyboard.UP_KEY)){
			if(this.y > 0)
				this.y-=velocidade;
			if(direcao != 4){
				setSequence(12,16);
				direcao=4;
			}
			movendo=true;
		}else if(teclado.keyDown(Keyboard.DOWN_KEY)){
			if(this.y < janela.getHeight()-32)
				this.y+=velocidade;
			if(direcao != 5){
				setSequence(0,4);
				direcao=5;
			}
			movendo=true;
		}
		if(movendo){
			update();
			movendo = false;
		}
	}
	
	//--Collision verify 
	public void caminho(Scene cena, Window janela, Keyboard teclado, Pontos p) {
		
		Point min = new Point((int)this.x, (int)this.y);
		Point max = new Point((int)this.x +this.width, (int)this.y+this.height);
		
		//--Tiles receive
		Vector<?>tiles = cena.getTilesFromPosition(min, max);

		//--Collision verify with current Tile
		for(int i = 0;i<tiles.size();i++){
			TileInfo tile = (TileInfo)tiles.elementAt(i);
			if(controle.colisao(this, tile, janela, teclado, cena, this, p)==true){
				
				//--Height collision
				if(colVer(this,tile)){							
					if(tile.y + tile.height-2 < this.y)
						this.y = tile.y + tile.height;
					else if(tile.y > this.y + this.height-2)
						this.y = tile.y - this.height;
				}
				
				//--Width collision
				if(colHor(this,tile)){							
					 this.x = (tile.x > this.x + this.width-2) ? 
							  (tile.x - this.width): 
							  (tile.x + tile.width); 
				}
			}
		}
	}
	
	//--Width collision tests
	private boolean colVer(GameObject obj, GameObject obj2){
			return (obj2.x + obj2.width <= obj.x || obj.x + obj.width <= obj2.x) ? false: true ;
	}
	
	//--Height collision tests
	private boolean colHor(GameObject obj, GameObject obj2){
			return (obj2.y + obj2.height <= obj.y  || obj.y + obj.height <= obj2.y) ? false: true ;
	}
}
