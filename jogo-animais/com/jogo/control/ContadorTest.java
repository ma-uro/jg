/**
 * 
 * @author Mauro
 * @version 1.0
 *
 */

package com.jogo.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ContadorTest {

	private static Contador contador = new Contador();
	
	@Test
	void testGetContadoIncrementa() {
		ContadorTest.contador.incrementa();
		int cont = Contador.getContador();
		assertEquals(cont, 2);
	}

}
