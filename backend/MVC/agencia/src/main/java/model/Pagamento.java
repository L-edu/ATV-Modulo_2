package model;

public class Pagamento {

	private int id;
	private double valor;
	private String tipo;
	private int fk_reserva;

	public Pagamento() {
	}

	public Pagamento(double valor, String tipo, int fk_reserva) {
		this.valor = valor;
		this.tipo = tipo;
		this.fk_reserva = fk_reserva;
	}

	public Pagamento(int id, double valor, String tipo, int fk_reserva) {
		this.id = id;
		this.valor = valor;
		this.tipo = tipo;
		this.fk_reserva = fk_reserva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getFk_reserva() {
		return fk_reserva;
	}

	public void setFk_reserva(int fk_reserva) {
		this.fk_reserva = fk_reserva;
	}

}
