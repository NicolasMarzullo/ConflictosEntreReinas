package edu.unlam.conflicto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoReina {
	
	public static Tablero leerReinas(String path) throws FileNotFoundException {
		List<Reina> reinas = new ArrayList<>();
		Scanner lector = new Scanner(new File(path));
		int dimTablero, cantReinas;
		
		dimTablero = lector.nextInt();
		cantReinas = lector.nextInt(); 
		
		for(int i=0; i<cantReinas;i++)
			reinas.add(new Reina(lector.nextInt(), lector.nextInt(), i+1));
		
		lector.close();

		return new Tablero(reinas,dimTablero);
	}

}
