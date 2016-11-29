package br.com.teste.service;

import java.util.Map;
import java.util.TreeMap;

import br.com.teste.model.Caminho;

public class Condicao {
	private interface Operacao {
		public boolean avalie(int x, int y);
	}

	private int valor;
	private String entidade;
	private Operacao operacao;
	
	static Map<String, Operacao> mapaOperacao;
	
	static {
		mapaOperacao = new TreeMap<String, Operacao>();
		mapaOperacao.put(">", new Operacao() {
			public boolean avalie(int x, int y) {
				return x > y;
			}
		});
		mapaOperacao.put("<", new Operacao() {
			public boolean avalie(int x, int y) {
				return x < y;
			}
		});
		mapaOperacao.put("=", new Operacao() {
			public boolean avalie(int x, int y) {
				return x == y;
			}
		});
	}
	
	public boolean avalie(Caminho caminho) {
		boolean rc;
		if (entidade.equals("stop")) {
			rc = operacao.avalie(caminho.getEtapa(), valor);
		} else if (entidade.equals("distancia")) {
			rc = operacao.avalie(caminho.getDistancia(), valor);
		} else {
			throw new IllegalArgumentException("Entidade desconhecida: " + entidade);
		}
		return rc;
	}

	/**
	 * contrutor do objeto Condição, que pode ser avaliado em relação a um determinado caminho 
	 * @param operador um de "<", ">" ou "="
	 * @param valor a ser usado na comparação
	 * @param entidate quer "stop" or "distancia"
	 */
	public Condicao(String operacao, int valor, String entidade) {
		this.operacao = mapaOperacao.get(operacao);
		
		if (this.operacao == null) {
			throw new IllegalArgumentException("Operação desconhecida: " + operacao);
		}
		this.valor  = valor;
		this.entidade = entidade;
	}
}
