package br.com.teste;

import java.io.IOException;
import java.io.InputStream;

import br.com.teste.service.Acoes;
import br.com.teste.service.Grafo;

public class Principal {

	public static void main(String[] args) {

		Grafo grafo = null;
		Acoes acoes = null;

		InputStream graph_input = ClassLoader.class.getResourceAsStream("/entradas.txt");
		InputStream commands = ClassLoader.class.getResourceAsStream("/comandos.txt");

		try {
			grafo = new Grafo(graph_input);
			acoes = new Acoes(commands);
		} catch (IOException e) {
			System.err.println("FATAL: " + e.getMessage());
			System.exit(1);
		}

		System.out.println(acoes.execute(grafo));
	}

}
