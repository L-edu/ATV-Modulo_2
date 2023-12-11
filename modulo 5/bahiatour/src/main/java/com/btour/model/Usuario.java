package com.btour.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = false, length = 80, unique = true)
	private String email;

	@Column(nullable = false, length = 15)
	private String telefone;

	@Column(nullable = false, length = 15)
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	private List <Reserva> reserva;
}
