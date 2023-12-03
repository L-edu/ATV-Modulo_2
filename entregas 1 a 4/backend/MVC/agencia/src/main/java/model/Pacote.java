package model;


public class Pacote {
	private int id;
	private String destino;
	private double preco;


	public Pacote() {
	}
	
	public Pacote(String destino, double preco) {
		this.destino = destino;
		this.preco = preco;
	}

	public Pacote(int id, String destino, double preco) {
		this.id = id;
		this.destino = destino;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

}
