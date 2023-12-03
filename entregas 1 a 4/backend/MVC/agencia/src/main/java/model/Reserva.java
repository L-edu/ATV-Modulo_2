package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
	private int id;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	private int qtd_pessoas;
	private String status_reserva;
	private Usuario fk_usuario;
	private Pacote fk_pacote;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(int id, String data_inicio, String data_fim, int qtd_pessoas, String status_reserva, Usuario fk_usuario,
			Pacote fk_pacote) {
		this.id = id;
		this.data_inicio = LocalDate.parse(data_inicio, formatter);
		this.data_fim = LocalDate.parse(data_fim, formatter);
		this.qtd_pessoas = qtd_pessoas;
		this.status_reserva = status_reserva;
		this.fk_usuario = fk_usuario;
		this.fk_pacote = fk_pacote;
	}

	public Reserva(String data_inicio, String data_fim, int qtd_pessoas, String status_reserva, Usuario fk_usuario,
			Pacote fk_pacote) {
		this.data_inicio = LocalDate.parse(data_inicio, formatter);
		this.data_fim = LocalDate.parse(data_fim, formatter);
		this.qtd_pessoas = qtd_pessoas;
		this.status_reserva = status_reserva;
		this.fk_usuario = fk_usuario;
		this.fk_pacote = fk_pacote;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData_inicio() {
	    if (data_inicio != null) {
	        return formatter.format(data_inicio);
	    } else {
	        return "";
	    }
	}

    public void setData_inicio(String data_inicio) {
        this.data_inicio = LocalDate.parse(data_inicio, formatter);
    }

	public String getData_fim() {
	    if (data_fim != null) {
	        return formatter.format(data_fim);
	    } else {
	        return "";
	    }
	}

    public void setData_fim(String data_fim) {
        this.data_fim = LocalDate.parse(data_fim, formatter);
    }

	public int getQtd_pessoas() {
		return qtd_pessoas;
	}

	public void setQtd_pessoas(int qtd_pessoas) {
		this.qtd_pessoas = qtd_pessoas;
	}

	public String getStatus_reserva() {
		return status_reserva;
	}

	public void setStatus_reserva(String status_reserva) {
		this.status_reserva = status_reserva;
	}

	public Usuario getFk_usuario() {
		return fk_usuario;
	}

	public void setFk_usuario(Usuario fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	public Pacote getFk_pacote() {
		return fk_pacote;
	}

	public void setFk_pacote(Pacote fk_pacote) {
		this.fk_pacote = fk_pacote;
	}


}
