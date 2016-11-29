package br.com.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.teste.service.Distancia;
import br.com.teste.service.Grafo;

public class DistanciaTest {

	@Test
	public void deveExecutarDistancia() {
		Grafo g1 = new Grafo("AB2, BA3, BD5, BE7, DB11, EB13, CE17, EC19, DE23, ED29, CF31 " +
							  "FC37, EF41, FE43, FA53, AF59, DA61, AD67, EA71, AE73");	
		
		Distancia a1 = new Distancia();
		a1.setParametros(new String[] {"distancia?", "EDBEF"});
		assertEquals(a1.execute(g1), "88");
		
		Distancia a2 = new Distancia();
		a2.setParametros(new String[] {"test", "EDBEF"});
		assertEquals(a2.execute(g1), "88");

		try {
			Distancia a3 = new Distancia();
			a3.setParametros(new String[] {"distancia?"});
			a3.execute(g1);
			fail("Ação incompleta");
		} catch(IllegalArgumentException e) {
			
		}
	}
	
}
