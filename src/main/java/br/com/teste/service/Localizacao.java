package br.com.teste.service;

import java.util.ArrayList;

import br.com.teste.model.Caminho;
import br.com.teste.model.Local;
import br.com.teste.model.No;

public class Localizacao {
	private Condicao executaCondicao;
	private Condicao filtroCondicao;
	private boolean pare;

	private ArrayList<Caminho> procurarCaminhos(Grafo grafo, No inicio, No no, Caminho caminho) {
		ArrayList<Caminho> caminhos = new ArrayList<Caminho>();

		// Para todos os locais diretamente acessíveis a partir do nó atual ...
		for (Local local : inicio.getLocais()) {
			No destino = local.getDestino();
			int distancia = local.getDistancia();
			Caminho novoCaminho = new Caminho(caminho.getDistancia() + distancia, caminho.getEtapa() + 1);

			// Se o caminho que chega a este destino, significa que a condição de execução não está mais satisfeita
			if (!executaCondicao.avalie(novoCaminho)) {
				continue;
			}

			// Se este destino é o alvo que estamos procurando ...
			if (destino.isEqual(no)) {
				// Se nenhum filtro foi especificado * ou * o filtro seleciona este caminho, então ele é adicionado à lista atual de resultados
				if (filtroCondicao == null || filtroCondicao.avalie(novoCaminho)) {
					caminhos.add(novoCaminho);
				}

				// Isso pode parecer contraditório, mas isso realmente 
				// significa que estamos parando a pesquisa neste ramo 
				// da árvore e continuar com outros ramos de pesquisa
				if (pare) {
					continue;
				}
			}

			// Procure recursivamente todos os caminhos que podem ser encontrados através deste vizinho
			for (Caminho c : procurarCaminhos(grafo, destino, no, novoCaminho)) {
				caminhos.add(c);
			}
		}
		return caminhos;
	}

	/**
	 * Executa uma árvore de pesquisa sob as restrições neste objeto Localização
	 * 
	 * @param grafo
	 * @param inicio
	 * @param no
	 * @return
	 */
	public Caminho[] findAllPaths(Grafo grafo, No inicio, No no) {
		return procurarCaminhos(grafo, inicio, no, new Caminho(0, 0)).toArray(new Caminho[0]);
	}

	/**
	 * Construtor do objeto Localização. A busca será direcionada de acordo com as restrições fornecidas.
	 * 
	 * @param executaCondicao
	 *            Determina em que circunstâncias a pesquisa deve continuar.
	 * @param filtroCondicao
	 *            Este filtro especifica quais caminhos devem ser incluídos no resultado.
	 * @param pare
	 *            Especifica se a pesquisa deve parar quando o nó de destino for atingido.
	 */
	public Localizacao(Condicao executaCondicao, Condicao filtroCondicao, boolean pare) {
		this.executaCondicao = executaCondicao;
		this.filtroCondicao = filtroCondicao;
		this.pare = pare;
	}
}
