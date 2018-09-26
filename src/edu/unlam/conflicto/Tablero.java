package edu.unlam.conflicto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tablero {
	private List<Reina> reinas;
	private int dimensi�n;

	public Tablero(List<Reina> reinas, int dimensi�n) {
		this.reinas = reinas;
		this.dimensi�n = dimensi�n;
	}

	public List<Reina> getReinas() {
		return reinas;
	}

	public int[][] resolverConflictos(){
		/*Este ejercicio es resuelto con una matriz de N(cant de reinas) filas x 9 columnas
		 * la primer columna la uso para guardar (al final de todo) la cantidad de conflictos 
		 * de cada reina las otras 8 columnas corresponden a los 8 posibles conflictos 
		 * que una reina puede tener: Arriba, abajo, izquierda, derecha, diagAribaDer, diagArribaIzq
		 * diagAbajoIzq diagAbajoDer
		 * 
		 * Dicha matriz es devuelta para su posterior impresi�n en el .out
		 * en el .out
		 */
		
		Reina reinaActualI, reinaActualJ;
		
		int lugarDeConflicto;
		int matResultado[][] = new int[this.reinas.size()][9];
		int vecCantidades[] = new int[this.reinas.size()]; 
		
		for(int i=0; i<this.reinas.size();i++) {	//recorro el arraylist
			reinaActualI = this.reinas.get(i);
			
			for(int j=0; j<this.reinas.size();j++) {	//recorro de vuelta para comparar todas con todas
				reinaActualJ = this.reinas.get(j);
				
				if(i!=j) {	//evito que se compare consigo misma
					
					lugarDeConflicto = reinaActualI.tieneConflicto(reinaActualJ);
					
					if(lugarDeConflicto != -1){ //hubo conflicto
						
						if(matResultado[i][lugarDeConflicto] == 0) {//aun no hubo ningun conlficto en esa direccion
							matResultado[i][lugarDeConflicto] = reinaActualJ.getNro(); //guardo la reina con la que hubo conflicto
							vecCantidades[i] ++;	//cuento el conflicto
						}
						else if(reinaActualJ.estaMasCercaQue(this.reinas.get(matResultado[i][lugarDeConflicto]-1), lugarDeConflicto))
								matResultado[i][lugarDeConflicto] = reinaActualJ.getNro();
					}
				}	
			}
		
		}
		
		
		//Primero ordeno las filas y luego pongo las cantidades en la primer columna 
		for(int i=0; i<this.reinas.size();i++) {
			Arrays.sort(matResultado[i]);
			matResultado[i][0] = vecCantidades[i];
		}
		

		return matResultado;
	}
	
	
}