package br.com.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.teste.service.Grafo;
import br.com.teste.service.Rota;

public class RotaTest {

	@Test
	public void assertRota() {
		Grafo g1 = new Grafo("AB5, AC9, BC2, BD7, CD4");
		assertTrue(Rota.run(g1, g1.getNo("A"), g1.getNo("D")) == 11);
		
		Grafo g2 = new Grafo("AB5, AB1, BC2, CA1, CD4, BD6");
		assertTrue(Rota.run(g2, g2.getNo("A"), g2.getNo("D")) == 7);
		assertTrue(Rota.run(g2, g2.getNo("A"), g2.getNo("F")) == Integer.MAX_VALUE);
		assertTrue(Rota.run(g2, g2.getNo("F"), g2.getNo("F")) == 0);
		assertFalse(Rota.run(g2, g2.getNo("D"), g2.getNo("A")) == 7);
		
		Grafo g3 = new Grafo("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		assertTrue(Rota.run(g3, g3.getNo("A"), g3.getNo("C")) == 9);
		assertTrue(Rota.run(g3, g3.getNo("B"), g3.getNo("B")) == 0);
	}
	
}
