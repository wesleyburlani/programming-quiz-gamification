package funcoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ComparaSaidas {
	
	public boolean lerInput(String arq){
		String arquivoIn = null , arquivoOut = null;
		
		try {
			arquivoIn  = new Scanner(new File("/home/eduardo-motta/workspace/FinalWorkProg1/prob/"+arq+".txt")).next();
			arquivoOut = new Scanner(new File("/home/eduardo-motta/workspace/FinalWorkProg1/prob/"+arq+".out")).next();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		if(arquivoIn.equals(arquivoOut))return true;
		return false;
	}
}