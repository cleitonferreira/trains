package br.com.teste.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import br.com.teste.model.Local;
import br.com.teste.model.No;

public class Rota {
	/**
	 * Executa um algoritmo para calcular 
	 * a rota mais curta possível entre um nó de início e de destino
	 * @param grafo
	 * @param inicio
	 * @param destino
	 * @return
	 */
	public static int run(Grafo grafo, No inicio, No destino) {
		Set<No> visitado = new HashSet<No>();
		Set<No> naoVisitado = new HashSet<No>();
		
		No[] nos = grafo.getNos();
		Map<String, Integer> distancia = new TreeMap<String, Integer>();

		// Comece definindo as distâncias de todos
		for (No no: nos) {
			distancia.put(no.getNome(), Integer.MAX_VALUE);
		}
		
		// Mover o nó de início para a lista de nós não visitados 
		// e definir a distância para 0 (ou seja, a distância do nó de início para si mesmo)
		naoVisitado.add(inicio);
		distancia.put(inicio.getNome(), 0);
		
		// verifica enquanto a lista de nós não visitados não está vazia ...
		while(!naoVisitado.isEmpty()) {
			
			// Encontrar o nó na lista não visitada com a distância mais curta conhecida
			No noMaisProximo=null;
			int minDistance = Integer.MAX_VALUE;
			for(No n : naoVisitado) {
				Integer dist = distancia.get(n.getNome());
				if ( dist < minDistance) {
					noMaisProximo = n;
					minDistance = dist ;
				}
			}
			
			// Mova o nó mais próximo para a lista de nós visitados
			naoVisitado.remove(noMaisProximo);
			visitado.add(noMaisProximo);
			

			for (Local local : noMaisProximo.getLocais()) {
				// verifica se os nós não foram visitados
				if (!visitado.contains(local.getDestino())) {
					// Encontrar um caminho melhor (mais curto) 
					int novaDistancia = distancia.get(noMaisProximo.getNome()) + local.getDistancia();
					Integer dist = distancia.get(local.getDestino().getNome());
					if (novaDistancia < dist) {
						// salvar a nova distância mais curta
						distancia.put(local.getDestino().getNome(), novaDistancia);
						naoVisitado.add(local.getDestino());
					}
				}
			}
			
			// se o nó de destino já tiver sido visitado, podemos parar a pesquisa
			if (visitado.contains(destino)) {
				break;
			}
		}
		// Retorna a menor distância gravada do nó de destino, para o nó de início
		return distancia.get(destino.getNome());
	}
}
