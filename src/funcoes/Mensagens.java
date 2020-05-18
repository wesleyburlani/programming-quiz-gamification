package funcoes;
import java.awt.Color;
import jplay.GameObject;
import jplay.TileInfo;
import jplay.Window;

public class Mensagens {

	public  void Escreve(GameObject obj, TileInfo tile,Window janela) {
	
		if(tile.id == 1 && obj.collided(tile)){			// Mostra a mensagem de vontade de entrara na casa quando colidido.
			janela.drawText("Casa", 30,100, Color.BLACK);	
		}
	}
	
}
