package br.com.teste.service;

import br.com.teste.model.Acao;
import br.com.teste.model.Local;
import br.com.teste.model.No;

public class CaminhoMaisCurto extends Acao {

	public String execute(Grafo grafo) {
		String[] parametro = getParametros();

		// second parameter contains the nodes specification
		if (parametro.length < 2) {
			throw new IllegalArgumentException("Ação inválida");
		}
		
		String no = parametro[1];
		No[] nos     = getNos(grafo, no);
	
		if (nos.length != 2) {
			throw new IllegalArgumentException("Ação inválida");
		}
		
		No inicio = nos[0];
		No destino = nos[1];
		
		int menorDistancia = Integer.MAX_VALUE;
		
		// Por que usar Rota?
		// I * could * tão bem reutilizar a classe PathFinder para esta ação, e
		// depois de encontrar todos os caminhos possíveis entre os nós de início e de destino, simplesmente
		// iterar pelos caminhos e selecionar o menor. Isso no entanto, implica
		// selecionando um número máximo arbitrário de saltos, após o qual a busca do
		// caminho mais curto deve ser desistido. Além disso, é altamente ineficiente. Então eu
		// decidiu implementar a busca pelo caminho mais curto usando o bem conhecido
		// Dijkstra algorithm

		if (inicio.isEqual(destino)) {
			// Este é um pouco de um caso especial. O algoritmo encontra o
			// caminho mais curto entre dois nós. Quando os nós inicial e final são
			// o mesmo, a distância será naturalmente 0. O problema solicita
			// (implicitamente) que neste caso um caminho diferente seja encontrado em vez disso
			// de apenas devolver a resposta óbvia (não há necessidade de viajar).
			for (Local local : inicio.getLocais()) {
				int distancia = Rota.run(grafo, local.getDestino(), destino);
				if (distancia != Integer.MAX_VALUE) {
					// um caminho foi encontrado a partir de um vizinho do nó de início
					// ao nó de início. A distância total, naturalmente,
					// a distância do nó de início para este vizinho.
					distancia += local.getDistancia();
					if (distancia < menorDistancia) {
						// uma nova distância mais curta foi encontrada
						menorDistancia = distancia;
					}
				}
			}
		} else {
			menorDistancia = Rota.run(grafo, nos[0], nos[1]);
		}
		
		if (menorDistancia == Integer.MAX_VALUE) {
			return "Nenhuma rota";
		}
		return String.valueOf(menorDistancia);
	}
}
