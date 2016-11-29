package br.com.teste.model;

public class Caminho {
	
	private int distancia;
	private int etapa;

	public Caminho(int distancia, int etapa) {
		this.distancia = distancia;
		this.etapa = etapa;
	}
	
	public int getDistancia() {
		return distancia;
	}
	public int getEtapa() {
		return etapa;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public void setHops(int hops) {
		this.etapa = hops;
	}

	public String toString() {
		return "(" + distancia + ", " + etapa +")";
	}
}
