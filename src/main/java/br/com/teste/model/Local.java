package br.com.teste.model;

public class Local {
	
	private No destino;
	private int distancia;
	
	public Local() {
		destino = null;
		distancia = 0;
	}
	
	public Local(No destino, int distancia) {
		this.destino = destino;
		this.distancia = distancia;
	}
	
	public No getDestino() {
		return destino;
	}

	public int getDistancia() {
		return distancia;
	}
	
	public String toString() {
		return destino.getNome() + ": " + distancia;
	}
}
