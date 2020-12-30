/**
 * 
 * @author Mauro
 * @version 1.0
 *
 */

package com.jogo.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class AnimalTest {

	String nomeAnimal = "Cão";
    String caracteristicaAnimal = "Late";    
    String nomeAnimalIrmao = "Gato";
    String caracteristicaAnimalIrmao = "Mia";
    String nomeAnimalFilho = "Pássaro";
    String caracteristicaAnimalFilho = "Voa";
    Animal animal = new Animal(nomeAnimal, caracteristicaAnimal);    
    Animal irmao = new Animal(nomeAnimalIrmao, caracteristicaAnimalIrmao);
    Animal filho = new Animal(nomeAnimalFilho, caracteristicaAnimalFilho);
    
	
	@Test
	void testGetFilhoSetFilho() {		
		animal.setFilho(filho);
		assertEquals(animal.getFilho().getNome(), nomeAnimalFilho);		
	}

	@Test
	void testGetIrmaoSetIrmao() {
		animal.setIrmao(irmao);
		assertEquals(animal.getIrmao().getNome(), nomeAnimalIrmao);	
	}

}
