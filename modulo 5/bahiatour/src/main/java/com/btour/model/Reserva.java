package com.btour.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(of = "id")
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_fk", nullable = false)
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacote_fk", nullable = false)
	private Pacote pacote;

	//@Column(nullable = false)
	//@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	//private BigDecimal orcamento;

}
