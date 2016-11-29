package br.com.teste;

import static org.junit.Assert.*;
import org.junit.Test;

import br.com.teste.model.Caminho;
import br.com.teste.service.Condicao;


public class CondicaoTest {
	
	@Test
	public void verificandoCaminho() {
		Condicao c1 = new Condicao("<", 5, "stop");
		Caminho p1_1 = new Caminho(10, 2);
		Caminho p1_2 = new Caminho(3, 8);
		assertTrue(c1.avalie(p1_1));
		assertFalse(c1.avalie(p1_2));
		
		Condicao c2 = new Condicao("=", 7, "distancia");
		Caminho p2_1 = new Caminho(1, 7);
		Caminho p2_2 = new Caminho(7, 5);
		assertFalse(c2.avalie(p2_1));
		assertTrue(c2.avalie(p2_2));
		
		Condicao c3 = new Condicao(">", 3, "stop");
		Caminho p3_1 = new Caminho(3, 5);
		Caminho p3_2 = new Caminho(3, 3);
		Caminho p3_3 = new Caminho(3, 4);
		assertTrue(c3.avalie(p3_1));
		assertFalse(c3.avalie(p3_2));
		assertTrue(c3.avalie(p3_3));
	}
	
	
}
