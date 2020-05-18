package funcoes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class AbreArquivo  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbreArquivo(JTextArea codigo){
		JFileChooser arquivo = new JFileChooser();
		arquivo.showOpenDialog(this);
		File file = arquivo.getSelectedFile();
		
		try{
			Path path = Paths.get(file.getAbsolutePath());
			String retorno = new String(Files.readAllBytes(path));
			codigo.setText(retorno);
			
		}catch(Exception erro){
			JOptionPane.showMessageDialog(this, "Não foi possível abrir o arquivo");
		}
	}
}
