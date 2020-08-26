package br.com.andy.modelo;

public class Produto {
	
	private String nome;
	private Double preco;
	
	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto() {
	}

	public String getNome() {
		return nome;
	}
	
	public Double getPreco() {
		return preco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto nome: " + nome + ", preco: " + preco;
	}
}
