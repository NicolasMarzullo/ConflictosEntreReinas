package edu.unlam.conflicto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	public static void imprimirReinas(String path, int matResultado[][]) throws IOException {
		PrintWriter writer = new PrintWriter(new File(path));
		
		for(int i=0; i<matResultado.length;i++) {
			writer.print(matResultado[i][0]);
			for(int j=1; j<9;j++) {
				if(matResultado[i][j] != 0) {
						writer.print(" " + matResultado[i][j]);
				}
					
			}
			
			writer.println();
		}
			
		writer.close();
			
	}
	
	public static boolean comparadorArchivos(String pathOrigen, String pathDestino) {

		String cadenaOrigen;
		String cadenaDestino;
		boolean iguales = true;

		Scanner scOrigen = null;
		Scanner scDestino = null;
		try {
			scOrigen = new Scanner(new File(pathOrigen));
			scDestino = new Scanner(new File(pathDestino));

			cadenaOrigen = scOrigen.nextLine();
			cadenaDestino = scDestino.nextLine();

			while (scOrigen.hasNextLine() && scDestino.hasNextLine() && iguales) {

				cadenaOrigen = scOrigen.nextLine();
				cadenaDestino = scDestino.nextLine();

				if (!cadenaOrigen.equals(cadenaDestino))
					iguales = false;
			}

			if (scOrigen.hasNextLine() || scDestino.hasNextLine())
				iguales = false;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scOrigen.close();
			scDestino.close();
		}

		return iguales;
	}

}
