package br.com.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.teste.service.Grafo;
import br.com.teste.service.Viagem;

public class ViagemTest {

	@Test
	public void buscarViagem() {
		Grafo g1 = new Grafo("AB3, BC3, CD3, DA3");
		Viagem a1 = new Viagem();
		a1.setParametros(new String[] {"-", "<101", "stop", "AA"});
		assertEquals(a1.execute(g1), "25");
		
		try {
			Viagem a2 = new Viagem();
			a2.setParametros(new String[] {"-", "<101", "stop"});
			a2.execute(g1);
			fail("ação inválida");
		} catch (IllegalArgumentException e) {
		}
		
		Viagem a3 = new Viagem();
		a3.setParametros(new String[] {"-", "=6", "distancia", "BD"});
		assertEquals(a3.execute(g1),"1");
	}
	
}
