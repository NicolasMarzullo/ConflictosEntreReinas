package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.conflicto.ArchivoReina;
import edu.unlam.conflicto.Reina;
import edu.unlam.conflicto.Tablero;

public class TestReinas {

	/*
	 * @Test public void testCargaReinas() throws FileNotFoundException { Tablero
	 * tablero = ArchivoReina.leerReinas("test/lotes/in/01_CasoEnunciado.in");
	 * 
	 * List<Reina> reinas = new ArrayList<>(); reinas = tablero.getReinas();
	 * 
	 * 
	 * for(int i=0; i<reinas.size();i++) System.out.println(reinas.get(i));
	 * 
	 * }
	 */

	@Test
	public void testEnunciado() throws IOException {
		Tablero tablero = ArchivoReina.leerReinas("test/lotes/in/01_CasoEnunciado.in");

		ArchivoReina.imprimirReinas("test/lotes/out/01_CasoEnunciado.out", tablero.resolverConflictos());

		Assert.assertEquals(true, ArchivoReina.comparadorArchivos("test/lotes/expected/01_CasoEnunciado.out",
				"test/lotes/out/01_CasoEnunciado.out"));
	}

	@Test
	public void testEnunciado2() throws IOException {
		Tablero tablero = ArchivoReina.leerReinas("test/lotes/in/02_CasoEnunciado.in");

		ArchivoReina.imprimirReinas("test/lotes/out/02_CasoEnunciado.out", tablero.resolverConflictos());

		Assert.assertEquals(true, ArchivoReina.comparadorArchivos("test/lotes/expected/02_CasoEnunciado.out",
				"test/lotes/out/02_CasoEnunciado.out"));
	}

	@Test
	public void testCuadradoCentral() throws IOException {
		Tablero tablero = ArchivoReina.leerReinas("test/lotes/in/03_CuadradoCentral.in");

		ArchivoReina.imprimirReinas("test/lotes/out/03_CuadradoCentral.out", tablero.resolverConflictos());

		Assert.assertEquals(true, ArchivoReina.comparadorArchivos("test/lotes/expected/03_CuadradoCentral.out",
				"test/lotes/out/03_CuadradoCentral.out"));
	}
}
