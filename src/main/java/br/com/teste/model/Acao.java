package br.com.teste.model;

import br.com.teste.service.Grafo;

public class Acao {
	private String [] parametros;

	public void setParametros(String[] parametros)  {
		this.parametros = parametros;
	}
	
	public String[] getParametros() {
		return parametros;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (String s : parametros) {
			str.append(s + " ");
		}
		return str.toString();
	}
	
	public String execute(Grafo g) {
		return "Não implementado";
	}
	
	protected No[] getNos(Grafo grafo, String s) {
		No[] nos = new No[s.length()];
		int i = 0;
		for (char c: s.toCharArray()) {
			String nome = String.valueOf(c);
			nos[i++] = grafo.getNo(nome);
		}
		return nos;
	}
}
