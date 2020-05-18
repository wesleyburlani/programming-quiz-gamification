package funcoes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SalvaArquivo extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public SalvaArquivo(JTextArea codigo, String arq) throws IOException{
		
		String cod;
		cod = codigo.getText();
		FileWriter writer = new FileWriter(new File("/home/eduardo-motta/workspace/FinalWorkProg1/prob/"+arq));  
		PrintWriter saida = new PrintWriter(writer); 
		saida.println(cod);
		JOptionPane.showMessageDialog(null, "Eviado "+ arq);
		saida.close();  
		writer.close();  
	}
}
