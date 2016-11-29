package br.com.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.teste.model.Acao;
import br.com.teste.service.CaminhoMaisCurto;
import br.com.teste.service.Distancia;
import br.com.teste.service.Viagem;


public class AcaoFactoryTest {

	private AcaoFactory acaoFactory;
	
	@Test
	public void criandoAcoes() {
		acaoFactory = new AcaoFactory();
		Acao acao = acaoFactory.criandoAcao("teste");
		assertTrue(acao == null);
		Acao distance = acaoFactory.criandoAcao("distancia?");
		assertTrue(distance.getClass().equals(Distancia.class));
		Acao trips = acaoFactory.criandoAcao("viagem?");
		assertTrue(trips.getClass().equals(Viagem.class));
		Acao shortest = acaoFactory.criandoAcao("rotaMaisCurta?");
		assertTrue(shortest.getClass().equals(CaminhoMaisCurto.class));
	}
	
}
