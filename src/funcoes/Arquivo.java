package funcoes;
import javax.swing.*;

public class Arquivo extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	
	public Arquivo(){
		super("Digite seu Código");
		Box box = Box.createHorizontalBox();
		
		textArea = new JTextArea();
		box.add(new JScrollPane(textArea));
		
		add(box);
	}
}
