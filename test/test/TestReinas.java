package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import edu.unlam.conflicto.ArchivoReina;
import edu.unlam.conflicto.Reina;
import edu.unlam.conflicto.Tablero;

public class TestReinas {
	
	/*@Test
	public void testCargaReinas() throws FileNotFoundException {
		Tablero tablero = ArchivoReina.leerReinas("test/lotes/in/01_CasoEnunciado.in");
		
		List<Reina> reinas = new ArrayList<>();
		reinas =  tablero.getReinas();
		
		
		for(int i=0; i<reinas.size();i++)
			System.out.println(reinas.get(i));
		
	}*/
	
	/*@Test
	public void testEnunciado() throws FileNotFoundException {
		Tablero tablero = ArchivoReina.leerReinas("test/lotes/in/01_CasoEnunciado.in");
		
		int matResultado[][] = tablero.resolverConflictos();
		
		
		for(int i=0; i<10;i++) {
			System.out.print(matResultado[i][0] + "\t");			
			for(int j=1; j<9; j++) {
				if(matResultado[i][j] !=0) {
					System.out.print(matResultado[i][j]);
					System.out.print("\t");	
				}
				
			}
			System.out.println();
		}
	}*/
	
	/*@Test
	public void testEnunciado2() throws FileNotFoundException {
		Tablero tablero = ArchivoReina.leerReinas("test/lotes/in/02_CasoEnunciado.in");
		
		int matResultado[][] = tablero.resolverConflictos();
		
		
		for(int i=0; i<8;i++) {
			System.out.print(matResultado[i][0] + "\t");
			for(int j=1; j<9; j++) {
				if(matResultado[i][j] !=0) {
					System.out.print(matResultado[i][j]);
					System.out.print("\t");	
				}
				
			}
			System.out.println();
		}

	}*/
	
	@Test
	public void testCuadradoCentral() throws FileNotFoundException {
		Tablero tablero = ArchivoReina.leerReinas("test/lotes/in/03_CuadradoCentral.in");
		
		int matResultado[][] = tablero.resolverConflictos();
		
		
		for(int i=0; i<9;i++) {
			System.out.print(matResultado[i][0] + "\t");			
			for(int j=1; j<9; j++) {
				if(matResultado[i][j] !=0) {
					System.out.print(matResultado[i][j]);
					System.out.print("\t");	
				}
				
			}
			System.out.println();
		}
	}

}
