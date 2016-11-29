package br.com.teste;

import java.util.Map;
import java.util.TreeMap;

import br.com.teste.model.Acao;
import br.com.teste.service.CaminhoMaisCurto;
import br.com.teste.service.Distancia;
import br.com.teste.service.Viagem;

public class AcaoFactory {
private Map<String, Class<?> > actionsMap;
	
	public Acao criandoAcao(String s) {
		Class<?> c = actionsMap.get(s);
		Acao acao = null;

		if (c != null) {
			try {
				acao = (Acao) c.newInstance();
			} catch (Exception e) {
				System.err.println("Erro interno ao criar " + s + " ação: " + e.getMessage());
			}
		}		

		return acao;
	}
	
	public AcaoFactory() {
		actionsMap = new TreeMap<String, Class<?> >();
		
		actionsMap.put("distancia?", Distancia.class);
		actionsMap.put("viagem?", Viagem.class);
		actionsMap.put("rotaMaisCurta?", CaminhoMaisCurto.class);
	}
}
