package br.com.teste.service;

import br.com.teste.model.Acao;
import br.com.teste.model.Caminho;
import br.com.teste.model.No;

public class Viagem extends Acao {
	
	public String execute(Grafo grafo) {
		String[] parametros = getParametros();

		if (parametros.length < 4) {
			throw new IllegalArgumentException("Ação inválida: ");
		}
		
		String condicao = parametros[1];
		String entidade    = parametros[2];
		String n = parametros[3];
		
		String operacao  = condicao.substring(0,1);
		int valor        = Integer.parseInt(condicao.substring(1));
		
		No[] nos     = getNos(grafo, n);
		
		if (nos.length != 2) {
			throw new IllegalArgumentException("Ação inválida: ");
		}
		
		No inicio = nos[0];
		No no = nos[1];
		Condicao filtroCondicao = new Condicao(operacao, valor, entidade);
		Condicao executaCondicao = filtroCondicao;
		
		// quando a condição de filtragem é encontrar todos os caminhos que correspondem a um dado valor, 
		// o teste é executado desde que o número de saltos da distância seja ainda menor do que o valor 
		// que estamos procurando
		if (operacao.equals("=")) {
			executaCondicao = new Condicao("<", valor + 1, entidade);
		}
		
		Caminho[] caminhos = new Localizacao(executaCondicao, filtroCondicao, false).findAllPaths(grafo, inicio, no);
		
		return String.valueOf(caminhos.length);
	}
}
