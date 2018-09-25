package edu.unlam.conflicto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tablero {
	private List<Reina> reinas;
	private int dimensión;

	public Tablero(List<Reina> reinas, int dimensión) {
		this.reinas = reinas;
		this.dimensión = dimensión;
	}

	public List<Reina> getReinas() {
		return reinas;
	}

	public int[][] resolverConflictos(){
		/*Este ejercicio es resuelto con una matriz de N(cant de reinas) filas x 9 columnas
		 * la primer columna la uso para guardar la cantidad de conflictos de cada reina 
		 * las otras 8 columnas corresponden a los 8 posibles conflictos que una reina puede
		 * tener. (Arriba, abajo, izquierda, derecha, diagAribaDer, diagArribaIzq
		 * diagAbajoIzq diagAbajoDer
		 * 
		 * Esto es lo que devuelvo para que luego el metodo de ArchivoReina se encargue de imprimirlo
		 * en el .out
		 */
		
		Reina reinaActualI, reinaActualJ;
		
		int lugarDeConflicto;
		int matResultado[][] = new int[this.reinas.size()][9];
		
		for(int i=0; i<this.reinas.size();i++) {	//recorro el arraylist
			reinaActualI = this.reinas.get(i);
			
			for(int j=0; j<this.reinas.size();j++) {	//recorro de vuelta para comparar todas con todas
				reinaActualJ = this.reinas.get(j);
				
				if(i!=j) {	//evito que se compare consigo misma
					
					lugarDeConflicto = reinaActualI.tieneConflicto(reinaActualJ);
					
					if(lugarDeConflicto != -1){ //hubo conflicto
						
						if(matResultado[i][lugarDeConflicto] == 0) {//aun no hubo ningun conlficto en esa direccion
							matResultado[i][lugarDeConflicto] = reinaActualJ.getNro(); //guardo la reina con la que hubo conflicto
							matResultado[i][0] ++;	//cuento el conflicto
						}
						else if(reinaActualJ.estaMasCercaQue(this.reinas.get(matResultado[i][lugarDeConflicto]-1), lugarDeConflicto))
								matResultado[i][lugarDeConflicto] = reinaActualJ.getNro();
					}
				}	
			}
		
		}
		
		
		return matResultado;
	}
	
	
}