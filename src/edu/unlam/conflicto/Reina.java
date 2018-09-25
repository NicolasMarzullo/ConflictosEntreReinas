package edu.unlam.conflicto;

public class Reina{

	private int fila;
	private int columna;
	private int nro;

	public Reina(int fila, int columna, int nro) {
		this.fila = fila;
		this.columna = columna;
		this.nro = nro;
	}

	@Override
	public String toString() {
		return fila + "  " + columna;
	}

	public int tieneConflicto(Reina otra) {
		/*
		 * Así será como indexo los conflictos y como los retorno 
		 * 8 	1	 2
		 *
		 * 7  REINA	 3
		 *
		 * 6    5 	 4
		 */

		if (this.fila == otra.fila)// horizontal
			if (this.columna < otra.columna)	//derecha
				return 3;
			else	//izquierda
				return 7;

		if (this.columna == otra.columna)// vertical
			if (this.fila < otra.fila) // abajo
				return 5;
			else // arriba
				return 1;

		if (Math.abs(this.fila - otra.fila) == Math.abs(this.columna - otra.columna)) {// diagonal
			if (otra.fila < this.fila && otra.columna > this.columna)
				return 2;
			if (otra.fila > this.fila && otra.columna > this.columna)
				return 4;
			if (otra.fila > this.fila && otra.columna < this.columna)
				return 6;

			return 8;
		}

		return -1; // no hay conflicto
	}

	public int getNro() {
		return nro;
	}

	public boolean estaMasCercaQue(Reina otra, int direccion) {
		
		if((direccion  == 1 || direccion == 2 || direccion == 8) && this.fila > otra.fila)
			return true;
		
		if((direccion  == 4 || direccion == 5 || direccion == 6) && this.fila < otra.fila)
			return true;
		
		if(direccion == 3 && this.columna< otra.columna)
			return true;
		
		if(direccion == 7 && this.columna > otra.columna)
			return true;
		
		return false;
		
	}
}