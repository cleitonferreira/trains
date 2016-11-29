package br.com.teste.service;

import br.com.teste.model.Acao;
import br.com.teste.model.Local;
import br.com.teste.model.No;

public class Distancia extends Acao {
	
	public String execute(Grafo grafo) {
		String[] parametros = getParametros();

		if (parametros.length < 2) {
			throw new IllegalArgumentException("Ação inválida: ");
		}
		
		String n = parametros[1];
		No[] nos = getNos(grafo, n);
				
		int distancia = 0;
		
		// o "último nó" é o nó de início ...
		No ultimoNo = nos[0];
		
		// Iterar a partir do segundo nó em diante ...
		for (int i = 1; i < nos.length; ++i) {
			No no = nos[i];
			boolean rotaEncontrada = false;
			// descobrir se existe realmente um caminho do
			// nó anterior visitado a este ...
			for (Local local: ultimoNo.getLocais()) {
				if (local.getDestino().isEqual(no)) {
					// encontrou um caminho
					distancia += local.getDistancia();
					rotaEncontrada = true;
					break;
				}
			}
			if (!rotaEncontrada) {
				// rota não existe. A distância é infinita
				distancia = Integer.MAX_VALUE;
				break;
			}
			ultimoNo = no;
		}
		
		if (distancia == Integer.MAX_VALUE) {
			return "Nenhuma rota";
		}
		return String.valueOf(distancia);
	}
}
