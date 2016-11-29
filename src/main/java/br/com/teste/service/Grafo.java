package br.com.teste.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import br.com.teste.model.Local;
import br.com.teste.model.No;

public class Grafo {
	
	Map<String, No> noMap = new TreeMap<String, No>();
    
    public No[] getNos() {
    	return noMap.values().toArray(new No[0]);
    }
    
    /**
     * Consulta um determinado nó neste grafo pelo nome. Se não existir, um novo
     * nó é criado e inserido no grafo.
     * @param nome
     * @return
     */
    public No getNo(String nome) {
    	No no = noMap.get(nome);
    	if (no == null) {
    		no = new No(nome);
    		noMap.put(nome, no);
    	}
    	return no;
    }
    
	/**
	* Lê uma série de grafos (ou seja, conexões entre nós) de
	* uma determinada string contendo uma vírgula ou uma lista separada por
	* conexões da forma XYZ, onde X e Y correspondem a uma fonte
	* Nós alvo respectivamente Z corresponde à distância
	* ou peso entre os dois nós. Por exemplo "AB3".
	 * 
	 * @param str
	 */
	public void read(String str) {
		for (String s : str.split("[\\s,]")) {
			if (!s.isEmpty()) {
				// Uma especificação de aresta deve ter pelo menos 3 caracteres .. i.e.
				// AB3
				if (s.length() < 3) {
					throw new IllegalArgumentException("Grafo incorreto: " + s);
				}
				String noOrigem = s.substring(0,1);
				String noDestino = s.substring(1,2);
				
				int distancia;
				
				try {
					distancia = Integer.parseInt(s.substring(2));
				} catch(NumberFormatException e) {
					throw new IllegalArgumentException("Grafo incorreto: " + s +
							": " + s.substring(2) + " não é um inteiro válido");
				}
				No source = getNo(noOrigem);
				No target = getNo(noDestino);
				
				source.add(new Local(target, distancia));
			}
		}
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Map.Entry<String, No> entry : noMap.entrySet()) {
			s.append(entry.getKey() + ":\n");
			for (Local local : entry.getValue().getLocais()) {
				s.append("  -> " + local + "\n");
			}
		}
		return s.toString();
	}
	
	/**
	* Contrutor do Grafo baseado em um InputStream
	* A especificação é uma vírgula (ou espaço em branco) lista separada de
	* Conexões da forma XYZ, onde X e Y correspondem a uma fonte
	 * @param stream
	 * @throws IOException
	 */
	public Grafo(InputStream stream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String str;
		while((str = reader.readLine()) != null) {
			read(str);
		}
	}
	
	public Grafo(String str) {
		read(str);
	}
}
