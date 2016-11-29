package br.com.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.teste.service.Condicao;
import br.com.teste.service.Grafo;
import br.com.teste.service.Localizacao;

public class CaminhoMaisCurtoTest {

	@Test
	public void buscarCaminhoMaisCurto() {
		Grafo g1 = new Grafo("AB3, BC3, CD3, DA3");
		
		Localizacao pf1_1 = new Localizacao(new Condicao("<", 101, "stop"), null, false);
		assertTrue(pf1_1.findAllPaths(g1, g1.getNo("A"), g1.getNo("A")).length == 25);
		
		Localizacao pf1_2 = new Localizacao(new Condicao("<", 12, "distancia"), null, false);
		assertTrue(pf1_2.findAllPaths(g1, g1.getNo("D"), g1.getNo("D")).length == 0);
		assertTrue(pf1_2.findAllPaths(g1, g1.getNo("D"), g1.getNo("C")).length == 1);
		
		Grafo g2 = new Grafo("AB2, BA3, BD5, BE7, DB11, EB13, CE17, EC19, DE23, ED29, CF31 " +
		                     "FC37, EF41, FE43, FA53, AF59, DA61, AD67, EA71, AE73");
		
		Localizacao pf2_1 = new Localizacao(new Condicao("<", 4, "stop"), null, true);
		assertTrue(pf2_1.findAllPaths(g2, g2.getNo("A"), g2.getNo("A")).length == 12);

		Localizacao pf2_2 = new Localizacao(new Condicao("<", 5, "stop"), null, true);
		assertTrue(pf2_2.findAllPaths(g2, g2.getNo("A"), g2.getNo("A")).length == 34);
		
		// The acid test. If this one fails, might have to increase the Java Heap space
		Localizacao pf2_3 = new Localizacao(new Condicao("<", 10, "stop"), null, false);
		assertTrue(pf2_3.findAllPaths(g2, g2.getNo("A"), g2.getNo("A")).length == 26776);
		
		Localizacao pf2_4 = new Localizacao(new Condicao("<", 6, "stop"), 
										  new Condicao("=", 88, "distancia"), 
										  false);
		assertTrue(pf2_4.findAllPaths(g2, g2.getNo("A"), g2.getNo("A")).length == 1);
	}
	
}
