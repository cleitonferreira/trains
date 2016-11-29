package br.com.teste.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.teste.AcaoFactory;
import br.com.teste.model.Acao;


public class Acoes {
	private List<Acao> listaAcoes;
	private AcaoFactory acaoFactory;
	
	/**
	 * Lê uma ação do objeto Action
	 * E o coloca na lista de ações para execução mais tarde.
	 * @param str
	 * @throws IllegalArgumentException
	 */
	public void read(String str) throws IllegalArgumentException {
		if (!str.isEmpty()) {
			String palavras[] = str.split("\\s");
			
			// A sintaxe geral das ações é:
			// <action query> [param1] [param2]...
			String nome = palavras[0];
			Acao acao = acaoFactory.criandoAcao(nome);
			
			if (acao == null) {
				throw new IllegalArgumentException("Ação desconhecida: " + nome);
			}
			
			acao.setParametros(palavras);
			
			listaAcoes.add(acao);
		}
	}
	
	/**
	 * contrutor do objeto Acao, lendo as ações a serem executadas a partir de um
	 * fluxo de entrada
	 * @param stream
	 * @throws IOException
	 */
	public Acoes(InputStream stream) throws IOException {
		this();
		
		// Ler ações do fluxo de entrada
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String str;
		while((str = reader.readLine()) != null) {
			read(str);
		}
	}
	
	public Acoes() {
		acaoFactory = new AcaoFactory();
		listaAcoes   = new ArrayList<Acao>();
	}
	
	/**
	 * executa esta ação no grafo
	 * @param grafo
	 * @return o resultado da ação
	 */
	public String execute(Grafo grafo) {
		StringBuilder s = new StringBuilder();

		for (Acao acao : listaAcoes) {
			s.append("Saída" + " => " + acao.execute(grafo) + "\n");
		}
		
		return s.toString();
	}
}
