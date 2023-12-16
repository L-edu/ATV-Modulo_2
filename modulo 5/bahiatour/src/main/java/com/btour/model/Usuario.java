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




@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = false, length = 80)
	private String email;

	@Column(nullable = false, length = 15)
	private String telefone;

	@Column(nullable = false, length = 15)
	private String senha;
	
	//@OneToMany(mappedBy = "usuario")
	//private List <Reserva> reserva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//public List<Reserva> getReserva() {
	//	return reserva;
	//}

	//public void setReserva(List<Reserva> reserva) {
	//	this.reserva = reserva;
	//}

	public Usuario(Long id, String nome, String email, String telefone, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Usuario() {
		super();
	}
	
	
}
