package com.btour.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "qtd_pessoa", nullable = false)
	private Integer qtdPessoa;

	@Column(name = "data_inicio", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataInicio;

	@Column(name = "data_fim")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataFim;

	@ManyToOne
	@JoinColumn(name = "usuario_fk", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "pacote_fk", nullable = false)
	private Pacote pacote;

	public Reserva(Long id, Integer qtdPessoa, LocalDate dataInicio, LocalDate dataFim, Usuario usuario,
			Pacote pacote) {
		super();
		this.id = id;
		this.qtdPessoa = qtdPessoa;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.usuario = usuario;
		this.pacote = pacote;
	}

	public Reserva() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtdPessoa() {
		return qtdPessoa;
	}

	public void setQtdPessoa(Integer qtdPessoa) {
		this.qtdPessoa = qtdPessoa;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

}
