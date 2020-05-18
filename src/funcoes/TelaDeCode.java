package funcoes;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaDeCode extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	String arq;
	JTextArea codigo = new JTextArea();
	JScrollPane scroll = new JScrollPane(codigo);
	JButton BEnviar = new JButton("Enviar"), BClose = new JButton("Fechar");
	Container container = getContentPane();
	Pontos pp;
	boolean flag;

	public Color mudarCor(String texto){
		return (texto.contains("(") && texto.contains(")"))?
				Color.blue: 
				Color.white;
	}
	
	public TelaDeCode(String arq, Pontos p, boolean flag){
		
	// Global Definitions 
		super("Console");
		setUndecorated(true);
		setLayout(null);
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.gray);
		this.arq = arq;
		pp = p;
		this.flag = flag;
	// Buttons definitions
		BClose.addActionListener(this);
		BEnviar.addActionListener(this);
		
	// Text area settings
		codigo.setBackground(Color.DARK_GRAY);
		codigo.setTabSize(2);
		codigo.setForeground(Color.white);
		codigo.setCaretColor(Color.white);

		
	// text area panel and scroll bar settings
		scroll.setBackground(Color.DARK_GRAY);
		scroll.setBounds(0, 15, 798, 570);
		container.add(scroll);
		
	// Close Button settings
		BClose.setBackground(Color.gray);
		BClose.setBounds(700,0,100, 15);
		container.add(BClose);

	//Save Button settings
		BEnviar.setBackground(Color.gray);
		BEnviar.setBounds(600,0,100, 15);
		container.add(BEnviar);
		setVisible(true);	
	}
	
	// Event Detections
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == BClose){	
			BClose.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					dispose();
				}
			});
		}
			
		if(evento.getSource() == BEnviar){
			try {
				new SalvaArquivo(codigo, arq+".out");
				File file = new File("/home/eduardo-motta/workspace/FinalWorkProg1/prob/"+arq+".out");
				ComparaSaidas fl = new ComparaSaidas();
				
				try {
					if(fl.lerInput(arq) == true){
						System.out.println("ok");
						JOptionPane.showMessageDialog(null, "Resposta Correta.");
						pp.setPontos(1);
						this.flag = true;
						System.out.println("2: " + this.flag);
					}else{
						System.out.println("Deu ruim");
						JOptionPane.showMessageDialog(null, "Resposta Incorreta.");
						System.out.println("2: " + this.flag);
						file.delete();
					}
				} catch (HeadlessException e) {
					e.printStackTrace();
				}	
			
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } 
	}
}
