package br.com.teste.model;

import java.util.ArrayList;
import java.util.List;

public class No {
	
	private List<Local> locais;
	private String nome;
	
	public No(String nome) {
		locais = new ArrayList<Local>();
		this.nome = nome;
	}
	
	public List<Local> getLocais() {
		return locais;
	}
	public String getNome() {
		return nome;
	}
	
	public boolean isEqual(No no) {
		return this.nome == no.nome;
	}
	
	public void add(Local local) {
		locais.add(local);
	}

	
	
	
}
